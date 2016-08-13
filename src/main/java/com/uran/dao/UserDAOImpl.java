package com.uran.dao;

import com.uran.model.User;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

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

    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return getCurrentSession().createQuery("from User").list();
    }

    @Transactional
    public void indexUsers() throws Exception
    {
        FullTextSession fullTextSession = Search.getFullTextSession(getCurrentSession());
        fullTextSession.createIndexer().startAndWait();
    }

    @Transactional
    //@SuppressWarnings("unchecked")
    public List<User> searchUser(String searchText) throws Exception
    {

        FullTextSession fullTextSession = Search.getFullTextSession(getCurrentSession());

        QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(User.class).get();
        org.apache.lucene.search.Query query = qb.keyword().onFields("name").matching(searchText).createQuery();

        //fullTextSession.createFullTextQuery(query, User.class);

        return fullTextSession.createFullTextQuery(query, User.class).list();
    }
}
