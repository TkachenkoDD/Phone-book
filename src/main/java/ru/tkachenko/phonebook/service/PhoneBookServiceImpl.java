package ru.tkachenko.phonebook.service;

import org.springframework.stereotype.Service;
import ru.tkachenko.phonebook.model.PhoneBook;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    private final List<PhoneBook> PHONE_BOOK_LIST = new ArrayList<>();
    private int NOTE_ID;

    @Override
    public List<PhoneBook> showAll(int ownerId) {
        List<PhoneBook> ownersPhoneBookList = new ArrayList<>();
        for (PhoneBook phoneBook: PHONE_BOOK_LIST) {
            if (phoneBook.getOwnersId() == ownerId) {
                ownersPhoneBookList.add(phoneBook);
            }
        }
        return ownersPhoneBookList;
    }

    @Override
    public PhoneBook showById(int id) {
        PhoneBook phoneBook = null;
        for (PhoneBook phoneBooks: PHONE_BOOK_LIST){
            if (phoneBooks.getId() == id){
                phoneBook = phoneBooks;
            }
        }
        return phoneBook;
    }

    @Override
    public boolean create(PhoneBook phoneBook) {
    phoneBook.setId(++NOTE_ID);
    return PHONE_BOOK_LIST.add(phoneBook);
    }

    @Override
    public boolean update(PhoneBook phoneBook, int id) {
        PhoneBook phoneBookForUpdate = showById(id);
        PHONE_BOOK_LIST.remove(phoneBookForUpdate);
        phoneBook.setId(id);
        return PHONE_BOOK_LIST.add(phoneBook);
    }

    @Override
    public boolean delete(int id) {
        PhoneBook phoneBookForDelete = showById(id);
        return PHONE_BOOK_LIST.remove(phoneBookForDelete);
    }

    @Override
    public PhoneBook showByNumber(int number) {
        PhoneBook phoneBook = null;
        for (PhoneBook phoneBooks: PHONE_BOOK_LIST){
            if (phoneBooks.getNumber() == number){
                phoneBook = phoneBooks;
            }
        }
        return phoneBook;
    }
}
