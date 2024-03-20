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

    private Long id; // The unique identifier for the person.
    private String idType; // The type of identification (e.g., passport, driver's license).
    private String firstname; // The first name of the person.
    private String lastname; // The last name of the person.
    private String password; // The password for the person's account.
    private String country; // The country of residence of the person.
    private String province; // The province or state of residence of the person.
    private String city; // The city of residence of the person.
    private String residence; // The residence address of the person.
    private String phone; // The contact phone number of the person.
    private String role; // The role or designation of the person.
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
     * @param password The password for the person's account.
     * @param country The country of residence of the person.
     * @param province The province or state of residence of the person.
     * @param city The city of residence of the person.
     * @param residence The residence address of the person.
     * @param phone The contact phone number of the person.
     * @param role The role or designation of the person.
     * @param birthdate The birthdate of the person, in ISO format (yyyy-MM-dd).
     */
    public PersonRegistrationDTO(Long id, String idType, String firstname, String lastname, String password,
                                 String country, String province, String city, String residence, String phone,
                                 String role, String birthdate) {
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
     * Returns the ID of the person.
     *
     * @return the ID of the person.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the person.
     *
     * @param id The unique identifier for the person.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the type of ID associated with the person.
     *
     * @return the type of ID.
     */
    public String getIdType() {
        return idType;
    }

    /**
     * Sets the type of ID for the person.
     *
     * @param idType A string representing the type of ID.
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * Gets the first name of the person.
     *
     * @return the first name.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstname A string representing the first name.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the last name of the person.
     *
     * @return the last name.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastname A string representing the last name.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the password of the person.
     *
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the person's account.
     *
     * @param password A string representing the password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the country of residence of the person.
     *
     * @return the country of residence.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country of residence for the person.
     *
     * @param country A string representing the country of residence.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the province or state of residence of the person.
     *
     * @return the province or state.
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province or state of residence for the person.
     *
     * @param province A string representing the province or state.
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets the city of residence of the person.
     *
     * @return the city of residence.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of residence for the person.
     *
     * @param city A string representing the city of residence.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the residential address of the person.
     *
     * @return the residential address.
     */
    public String getResidence() {
        return residence;
    }

    /**
     * Sets the residential address for the person.
     *
     * @param residence A string representing the residential address.
     */
    public void setResidence(String residence) {
        this.residence = residence;
    }

    /**
     * Gets the phone number of the person.
     *
     * @return the phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number for the person.
     *
     * @param phone A string representing the phone number.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the role or designation of the person.
     *
     * @return the role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role or designation for the person.
     *
     * @param role A string representing the role.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the birthday of the person.
     *
     * @return the birthday in ISO format (yyyy-MM-dd).
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthday of the person.
     *
     * @param birthdate A string representing the birthday in ISO format (yyyy-MM-dd).
     */
    public void setBirthday(String birthdate) {
        this.birthdate = birthdate;
    }

}
