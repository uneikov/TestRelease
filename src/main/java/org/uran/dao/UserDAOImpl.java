package org.uran.dao;

import org.springframework.stereotype.Repository;
import org.uran.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = getUser(user.getId());
        userToUpdate.setId(0);
        userToUpdate.setName(user.getName());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setIsAdmin(user.getIsAdmin());
        userToUpdate.setCreatedDate(user.getCreatedDate());
        getCurrentSession().update(userToUpdate);
    }

    @Override
    public User getUser(int id) {
        //User user = (User) getCurrentSession().get(User.class, id);
        return (User) getCurrentSession().get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUser(id);
        if (user != null)
            getCurrentSession().delete(user);
    }

    //????????????????????????????????????????????????
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        //Query query = "from User";
        //return getCurrentSession().createQuery("SELECT * from User").list();
        return null;
    }
}
