package co.udea.airline.api.model.DTO.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * The PersonInfoDTO class is a data transfer object used to return user information.
 */
@Getter
@Setter
public class PersonInfoDTO {
    private String cc;
    private String idType;
    private String firstname;
    private String lastname;
    private String mail;
    private String country;
    private String province;
    private String city;
    private String residence;
    private String phone;
    private String role;
    private String birthdate;

    public PersonInfoDTO(String cc, String idType, String firstname, String lastname, String mail,
                         String country, String province, String city, String residence,
                         String phone, String role, String birthdate) {
        this.cc = cc;
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
}
