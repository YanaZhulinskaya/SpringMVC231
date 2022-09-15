package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    public UserDaoImpl() {
    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {

        entityManager.persist(user);
    }


    @Override
    public void delete(User user) {

        entityManager.remove(entityManager.find(User.class, user.getId()));
    }


    @Override
    public void edit(User user) {

        entityManager.merge(user);
    }


    @Override
    public User getById(long id) {

        return entityManager.find(User.class, id);
    }
}

