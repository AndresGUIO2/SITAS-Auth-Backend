package com.udea.authorizationauthentication.model;

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
public class Person {
    private Long id; // The person's ID
    private String idType; // The type of the person's ID (e.g., passport, national ID)
    private String firstname; // The person's first name
    private String lastname; // The person's last name
    private String password; // The person's password
    private String country; // The country where the person resides
    private String province; // The province or state where the person resides
    private String city; // The city where the person resides
    private String residence; // The specific residence address of the person
    private String phone; // The person's phone number
    private String role; // The person's role or occupation
    private String birthdate; // The person's birthdate

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
    public Person(Long id, String idType, String firstname, String lastname, String password, String country,
                  String province, String city, String residence, String phone, String role, String birthdate) {
        this.id = id;
        this.idType = idType;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.country = country;
        this.province = province;
        this.city = city;
        this.residence = residence;
        this.phone = phone;
        this.role = role;
        this.birthdate = birthdate;
    }

    /**
     * Gets the ID of the person.
     *
     * @return the person's ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the person.
     *
     * @param id the person's ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the type of ID of the person.
     *
     * @return the type of ID (e.g., passport, national ID)
     */
    public String getIdType() {
        return idType;
    }

    /**
     * Sets the type of ID of the person.
     *
     * @param idType the type of ID (e.g., passport, national ID)
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * Gets the first name of the person.
     *
     * @return the person's first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstname the person's first name
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the last name of the person.
     *
     * @return the person's last name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastname the person's last name
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the password of the person.
     *
     * @return the person's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the person.
     *
     * @param password the person's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the country where the person resides.
     *
     * @return the country where the person resides
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country where the person resides.
     *
     * @param country the country where the person resides
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the province where the person resides.
     *
     * @return the province where the person resides
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province where the person resides.
     *
     * @param province the province where the person resides
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets the city where the person resides.
     *
     * @return the city where the person resides
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the person resides.
     *
     * @param city the city where the person resides
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the specific residence address of the person.
     *
     * @return the specific residence address of the person
     */
    public String getResidence() {
        return residence;
    }

    /**
     * Sets the specific residence address of the person.
     *
     * @param residence the specific residence address of the person
     */
    public void setResidence(String residence) {
        this.residence = residence;
    }

    /**
     * Gets the phone number of the person.
     *
     * @return the person's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phone the person's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the role or occupation of the person.
     *
     * @return the person's role or occupation
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role or occupation of the person.
     *
     * @param role the person's role or occupation
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the birthdate of the person.
     *
     * @return the person's birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate of the person.
     *
     * @param birthdate the person's birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
