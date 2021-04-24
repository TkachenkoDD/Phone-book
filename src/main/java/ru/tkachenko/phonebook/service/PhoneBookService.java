package ru.tkachenko.phonebook.service;

import ru.tkachenko.phonebook.model.PhoneBook;

import java.util.List;

public interface PhoneBookService {

    List<PhoneBook> showAll (int ownerId);

    PhoneBook showById (int id);

    boolean create (PhoneBook phoneBook);

    boolean update(PhoneBook phoneBook, int id);

    boolean delete(int id);

    PhoneBook showByNumber (int number);
}
