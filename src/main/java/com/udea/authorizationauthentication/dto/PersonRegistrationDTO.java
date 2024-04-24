package com.udea.authorizationauthentication.dto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The PersonRegistrationDTO class is a data transfer object used to register a new person.
 * It encapsulates the user registration information required during the sign-up process.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@Setter
@Getter
public class PersonRegistrationDTO {

    /**
     * -- GETTER --
     *  Returns the ID of the person.
     *
     *
     * -- SETTER --
     *  Sets the ID of the person.
     *
     @return the ID of the person.
      * @param id The unique identifier for the person.
     */
    @NotBlank(message = "ID (Cédula) is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "ID (cc) must be 10 digits")
    private String id;
    /**
     * -- GETTER --
     *  Gets the type of ID associated with the person.
     *
     *
     * -- SETTER --
     *  Sets the type of ID for the person.
     *
     @return the type of ID.
      * @param idType A string representing the type of ID.
     */
    @NotBlank(message = "ID type is required")
    private String idType;
    /**
     * -- GETTER --
     *  Gets the first name of the person.
     *
     *
     * -- SETTER --
     *  Sets the first name of the person.
     *
     @return the first name.
      * @param firstname A string representing the first name.
     */
    @NotBlank(message = "First name is required")
    private String firstname;
    /**
     * -- GETTER --
     *  Gets the last name of the person.
     *
     *
     * -- SETTER --
     *  Sets the last name of the person.
     *
     @return the last name.
      * @param lastname A string representing the last name.
     */
    @NotBlank(message = "Last name is required")
    private String lastname;
    /**
     * -- GETTER --
     *  Gets the password of the person.
     *
     *
     * -- SETTER --
     *  Sets the password for the person's account.
     *
     @return the password.
      * @param password A string representing the password.
     */
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?!.*[#='$;%]).{8,}$",
            message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one symbol, and cannot contain #='$;%")
    private String password;
    @Email(message = "Email should be valid")
    private String mail;
    /**
     * -- GETTER --
     *  Gets the country of residence of the person.
     *
     *
     * -- SETTER --
     *  Sets the country of residence for the person.
     *
     @return the country of residence.
      * @param country A string representing the country of residence.
     */
    private String country;
    /**
     * -- GETTER --
     *  Gets the province or state of residence of the person.
     *
     *
     * -- SETTER --
     *  Sets the province or state of residence for the person.
     *
     @return the province or state.
      * @param province A string representing the province or state.
     */
    private String province;
    /**
     * -- GETTER --
     *  Gets the city of residence of the person.
     *
     *
     * -- SETTER --
     *  Sets the city of residence for the person.
     *
     @return the city of residence.
      * @param city A string representing the city of residence.
     */
    private String city;
    /**
     * -- GETTER --
     *  Gets the residential address of the person.
     *
     *
     * -- SETTER --
     *  Sets the residential address for the person.
     *
     @return the residential address.
      * @param residence A string representing the residential address.
     */
    private String residence;
    /**
     * -- GETTER --
     *  Gets the phone number of the person.
     *
     *
     * -- SETTER --
     *  Sets the phone number for the person.
     *
     @return the phone number.
      * @param phone A string representing the phone number.
     */
    private String phone;
    /**
     * -- GETTER --
     *  Gets the role or designation of the person.
     *
     *
     * -- SETTER --
     *  Sets the role or designation for the person.
     *
     @return the role.
      * @param role A string representing the role.
     */
    private String role;
    /**
     * -- GETTER --
     *  Gets the birthdate of the person.
     *
     *
     * -- SETTER --
     *  Sets the birthdate of the person.
     *
     @return the birthdate in ISO format (yyyy-MM-dd).
      * @param birthdate A string representing the birthdate in ISO format (yyyy-MM-dd).
     */
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
     * @param mail The mail of the perso. Used for logging process.
     * @param country The country of residence of the person.
     * @param province The province or state of residence of the person.
     * @param city The city of residence of the person.
     * @param residence The residence address of the person.
     * @param phone The contact phone number of the person.
     * @param role The role or designation of the person.
     * @param birthdate The birthdate of the person, in ISO format (yyyy-MM-dd).
     */
    public PersonRegistrationDTO(String id, String idType, String firstname, String lastname, String mail, String password,
                                 String country, String province, String city, String residence, String phone,
                                 String role, String birthdate) {
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
