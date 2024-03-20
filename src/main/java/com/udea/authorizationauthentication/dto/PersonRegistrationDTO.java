package com.udea.authorizationauthentication.dto;

import java.time.LocalDate;

public class PersonRegistrationDTO {

    private Long id;
    private String idType;
    private String firstname;
    private String lastname;
    private String password;
    private String country;
    private String province;
    private String city;
    private String residence;
    private String phone;
    private String role;
    private String birthday;

    public PersonRegistrationDTO(){

    }

    public PersonRegistrationDTO(Long id, String idType, String firstname, String lastname, String password,
                                 String country, String province, String city, String residence, String phone,
                                 String role, String birthday) {
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
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
