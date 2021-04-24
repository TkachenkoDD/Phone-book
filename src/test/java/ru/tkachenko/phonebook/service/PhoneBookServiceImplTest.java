package ru.tkachenko.phonebook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tkachenko.phonebook.model.PhoneBook;
import ru.tkachenko.phonebook.model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class PhoneBookServiceImplTest {

    PhoneBookServiceImpl phoneBookService = new PhoneBookServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @BeforeEach
    void init() {
        userService.create(new User( 0,"Petya", "Sidorov"));
        userService.create(new User( 0,"Afanasiy", "Ivanov"));
        userService.create(new User( 0,"Vasya", "Petrov"));
        phoneBookService.create(new PhoneBook(0, 11111, "Roman", 1));
        phoneBookService.create(new PhoneBook(0, 22222, "Sergey", 1));
        phoneBookService.create(new PhoneBook(0, 33333, "Oleg", 2));
        phoneBookService.create(new PhoneBook(0, 44444, "Semen", 3));
    }

    @Test
    void showAll() {
        int ownerId = 1;
        List<PhoneBook> phoneBookList = phoneBookService.showAll(ownerId);
        assertEquals(2, phoneBookList.size());
    }

    @Test
    void showById() {
        PhoneBook phoneBookExpected = new PhoneBook(3, 33333, "Oleg", 2);
        int input = 3;
        PhoneBook actual = phoneBookService.showById(input);
        assertEquals(phoneBookExpected, actual);
    }

    @Test
    void create() {
        List<PhoneBook> phoneBookListBefore = phoneBookService.showAll(1);
        phoneBookService.create(new PhoneBook(0, 12345, "Lena", 1));
        List<PhoneBook> phoneBookListAfter = phoneBookService.showAll(1);
        assertEquals(phoneBookListBefore.size() + 1, phoneBookListAfter.size());
    }

    @Test
    void update() {
        PhoneBook forUpdate = new PhoneBook(2, 22222, "Ahmed", 1);
        phoneBookService.update(forUpdate, 2);
        PhoneBook afterUpdate = phoneBookService.showById(2);
        assertEquals(forUpdate, afterUpdate);
    }

    @Test
    void delete() {
        List<PhoneBook> phoneBookList = phoneBookService.showAll(1);
        int sizeBeforeDelete = phoneBookList.size();
        phoneBookService.delete(1);
        int sizeAfterDelete = phoneBookService.showAll(1).size();
        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
    }

    @Test
    void showByNumber() {
        int num = 33333;
        PhoneBook phoneBookExpected = new PhoneBook(3, 33333, "Oleg", 2);
        assertEquals(phoneBookExpected, phoneBookService.showByNumber(num));
    }
}