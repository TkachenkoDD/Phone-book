package ru.tkachenko.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.tkachenko.phonebook.model.PhoneBook;
import ru.tkachenko.phonebook.service.PhoneBookService;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class PhoneBooksController {

    private final PhoneBookService phoneBookService;

    @Autowired
    public PhoneBooksController(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    @GetMapping("/list/{ownerId}")
    public ResponseEntity<List<PhoneBook>> showAll(@PathVariable("ownerId") int ownerId) {
        List<PhoneBook> phoneBookList = phoneBookService.showAll(ownerId);
        return phoneBookList != null && !phoneBookList.isEmpty()
                ? new ResponseEntity<>(phoneBookList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneBook> showById(@PathVariable("id") int id) {
        PhoneBook phoneBook = phoneBookService.showById(id);
        return phoneBook != null
                ? new ResponseEntity<>(phoneBook, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PhoneBook> create(@RequestBody PhoneBook phoneBook) {
        phoneBookService.create(phoneBook);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneBook> update(@PathVariable("id") int id, @RequestBody PhoneBook phoneBook) {
        phoneBookService.update(phoneBook, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PhoneBook> delete(@PathVariable("id") int id) {
        phoneBookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<PhoneBook> searchByNumber(@RequestParam(value = "number", required = false) int number) {
        PhoneBook phoneBook = phoneBookService.showByNumber(number);
        return phoneBook != null
                ? new ResponseEntity<>(phoneBook, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
