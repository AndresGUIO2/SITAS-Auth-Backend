package com.udea.authorizationauthentication.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Represents a person entity with its attributes such as name, id, password, etc...
 * This class provides getters and setters for accessing and modifying the attributes.
 * Person objects can be serialized and deserialized using JSON format.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@Setter
@Getter
public class Person {
    private String id;
    private String idType;
    private String firstname;
    private String lastname;
    private String password;
    private String mail;
    private String country;
    private String province;
    private String city;
    private String residence;
    private String phone;
    private String role;
    private String birthdate;

    /**
     * Constructs a new Person with default values.
     */
    public Person(){
    }

    /**
     * Constructs a new Person with the specified attributes.
     *
     * @param id the person's ID
     * @param idType the type of ID (e.g., passport, national ID)
     * @param firstname the person's first name
     * @param lastname the person's last name
     * @param password the person's password
     * @param country the country where the person resides
     * @param province the province where the person resides
     * @param city the city where the person resides
     * @param residence the specific residence address of the person
     * @param phone the person's phone number
     * @param role the person's role or occupation
     * @param birthdate the person's birthdate
     */

    public Person(String id, String idType, String firstname, String lastname, String password, String mail, String country,
                  String province, String city, String residence, String phone, String role, String birthdate) {
        this.id = id;
        this.idType = idType;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.mail = mail;
        this.country = country;
        this.province = province;
        this.city = city;
        this.residence = residence;
        this.phone = phone;
        this.role = role;
        this.birthdate = birthdate;
    }

}
