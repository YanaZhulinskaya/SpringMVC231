package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {

        entityManager.persist(user);
    }


    @Override
    public void deleteUser(long id) {

        entityManager.remove(getUserById(id));
    }

    @Override
    public User updateUser(User user, long id) {
        User updatedUser = getUserById(id);
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setAge(user.getAge());
        return entityManager.merge(updatedUser);
    }

    @Override
    public User getUserById(long id) {

        return entityManager.find(User.class, id);
    }
}

