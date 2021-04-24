package ru.tkachenko.phonebook.service;

import ru.tkachenko.phonebook.model.User;

import java.util.List;

public interface UserService {

List<User> showAll ();

User showById (int id);

boolean create (User user);

boolean update(User user, int id);

boolean delete(int id);

List<User> showByName(String surname);
}
