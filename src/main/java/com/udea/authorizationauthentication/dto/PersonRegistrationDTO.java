package com.udea.authorizationauthentication.dto;

/**
 * The PersonRegistrationDTO class is a data transfer object used to register a new person.
 * It encapsulates the user registration information required during the sign-up process.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
public class PersonRegistrationDTO {

    private Long id;
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
    private String birthdate; // The birthdate of the person, in ISO format (yyyy-MM-dd).

    /**
     * Default constructor for PersonRegistrationDTO.
     */
    public PersonRegistrationDTO(){

    }

    /**
     * Constructs a new PersonRegistrationDTO with the specified detail information.
     *
     * @param id The unique identifier for the person.
     * @param idType The type of identification (e.g., passport, driver's license).
     * @param firstname The first name of the person.
     * @param lastname The last name of the person.
     * @param mail The mail of the perso. Used for logging process.
     * @param country The country of residence of the person.
     * @param province The province or state of residence of the person.
     * @param city The city of residence of the person.
     * @param residence The residence address of the person.
     * @param phone The contact phone number of the person.
     * @param role The role or designation of the person.
     * @param birthdate The birthdate of the person, in ISO format (yyyy-MM-dd).
     */
    public PersonRegistrationDTO(Long id, String idType, String firstname, String lastname, String mail, String password,
                                 String country, String province, String city, String residence, String phone,
                                 String role, String birthdate) {
        this.id = id;
        this.idType = idType;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.country = country;
        this.province = province;
        this.city = city;
        this.residence = residence;
        this.phone = phone;
        this.role = role;
        this.birthdate = birthdate;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
