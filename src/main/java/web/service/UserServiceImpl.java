package web.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public void setUser(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }

    @Override
    public void save(User user) {

        userDao.getAllUsers();
    }

    @Override
    public void delete(User user) {

        userDao.delete(user);
    }

    @Override
    public void edit(User user) {

        userDao.edit(user);
    }

    @Override
    public User getById(long id) {

        return userDao.getById(id);
    }
}
