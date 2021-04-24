package ru.tkachenko.phonebook.service;

import org.springframework.stereotype.Service;
import ru.tkachenko.phonebook.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

private final List<User> USER_LIST = new ArrayList<>();
private int USER_ID;

    @Override
    public List<User> showAll() {
        return USER_LIST;
    }

    @Override
    public User showById(int id) {
        User user = new User();
        for (User users : USER_LIST) {
            if (users.getId() == id)
                user = users;
        }
        return user;
    }

    @Override
    public boolean create(User user) {
    user.setId(++USER_ID);
    return USER_LIST.add(user);
    }

    @Override
    public boolean update(User user, int id) {
        User updatedUser = showById(id);
        USER_LIST.remove(updatedUser);
        user.setId(id);
        return USER_LIST.add(user);
    }

    @Override
    public boolean delete(int id) {
        User userForDelete = showById(id);
       return USER_LIST.remove(userForDelete);
    }

    @Override
    public List<User> showByName(String surname) {
        List<User> userList = new ArrayList<>();
        for (User user: USER_LIST){
            if (user.getSurname().startsWith(surname)){
                userList.add(user);
            }
        }
        return userList;
    }
}
