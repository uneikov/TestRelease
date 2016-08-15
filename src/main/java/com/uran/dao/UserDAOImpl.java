package com.uran.dao;

import com.uran.model.User;
import org.hibernate.query.Query;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@PropertySource("classpath:application.properties")
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 8;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    public void updateUser(User user) {
        User userToUpdate = getUser(user.getId());
        userToUpdate.setName(user.getName());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setIsAdmin(user.getIsAdmin());
        userToUpdate.setCreatedDate(user.getCreatedDate());
        getCurrentSession().update(userToUpdate);
    }

    public User getUser(int id) {
        return getCurrentSession().get(User.class, id);
    }

    public void deleteUser(int id) {
        User user = getUser(id);
        if (user != null)
            getCurrentSession().delete(user);
    }

    public Integer count(){
        return ((Long)getCurrentSession().createQuery("select count(*) from User").uniqueResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsers(int page) {
        Query query = getCurrentSession().createQuery("from User");
        query.setFirstResult(page * limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsersBySearch(String userName) {
        String searchQuery = "FROM User U WHERE U.name = :user_name";
        Query query = getCurrentSession().createQuery(searchQuery);
        query.setParameter("user_name",userName);
        return query.list();
    }
}
