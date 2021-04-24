package ru.tkachenko.phonebook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tkachenko.phonebook.model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class UserServiceImplTest {

    UserServiceImpl userService = new UserServiceImpl();

    @BeforeEach
    void init(){
        userService.create(new User( 0,"Petya", "Sidorov"));
        userService.create(new User( 0,"Afanasiy", "Ivanov"));
        userService.create(new User( 0,"Vasya", "Petrov"));
    }

    @Test
    void showById() {
        User userExpected = new User(1,"Vasya", "Petrov");
        int input = 1;
        User actual = userService.showById(input);
        assertEquals(userExpected, actual);
    }

    @Test
    void showByIdForThree() {
        User userExpected = new User(3,"Vasya", "Petrov");
        int input = 3;
        User actual = userService.showById(input);
        assertEquals(userExpected, actual);
    }

    @Test
    void showByIdForNonExist() {
        User userExpected = new User(0, null, null);
        int input = 5;
        User actual = userService.showById(input);
        assertEquals(userExpected, actual);
    }

    @Test
    void create() {
        List<User> userList = userService.showAll();
        int list1Size = userList.size();
        userService.create(new User( 0,"Joe", "Pupkin"));
        assertEquals(list1Size + 1, userList.size());
    }

    @Test
    void update() {
        User forUpdate = new User(3,"Petya", "Vasechkin");
        userService.update(forUpdate, 3);
        User afterUpdate = userService.showById(3);
        assertEquals(forUpdate, afterUpdate);
    }

    @Test
    void delete() {
        List<User> userList = userService.showAll();
        int sizeBeforeDelete = userList.size();
        userService.delete(2);
        int sizeAfterDelete = userList.size();
        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
    }

    @Test
    void showByName() {
        String name = "Ivan";
        List<User> actual = userService.showByName(name);
        assertEquals(1, actual.size());
    }
}