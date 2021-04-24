package ru.tkachenko.phonebook.model;

import java.util.Objects;

public class PhoneBook {

    private int id;
    private int number;
    private String contactsName;
    private int ownersId;

    public PhoneBook() {}

    public PhoneBook(int id, int number, String contactsName, int ownersId) {
        this.id = id;
        this.number = number;
        this.contactsName = contactsName;
        this.ownersId = ownersId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public int getOwnersId() {
        return ownersId;
    }

    public void setOwnersId(int ownersId) {
        this.ownersId = ownersId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof PhoneBook)) {
            return false;
        }
        PhoneBook phoneBook = (PhoneBook) obj;

        return id == phoneBook.id;
    }
}
