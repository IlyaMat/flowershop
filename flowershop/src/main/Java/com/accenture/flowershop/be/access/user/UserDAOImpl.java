package com.accenture.flowershop.be.access.user;

import com.accenture.flowershop.be.entity.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUserById(long userId) {
        TypedQuery<User> q = entityManager.createQuery(
                "select u from User u where u.id = :id", User.class
        );
        q.setParameter("id", userId);
        //User user = q.getSingleResult();
        return q.getSingleResult();
    }

    @Override
    public User findUserByUsername(String username) {
        /*TypedQuery<User> q = entityManager.createQuery(
                "select u from User u where u.username = :username", User.class
        );
        q.setParameter("username", username);
        return q.getSingleResult();*/
        TypedQuery<User> q = entityManager.createQuery(
                "select u from User u where u.username = :username", User.class
        );
        q.setParameter("username", username);
        //q.setMaxResults(1);
        List<User> users = q.getResultList();
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery(
                "select u from User u", User.class
        ).getResultList();
    }
}
