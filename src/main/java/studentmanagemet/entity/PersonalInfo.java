package studentmanagemet.entity;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonalInfo implements Serializable {


    private int id;
    private String name;
    private String barCode;
    private String dateOfBirth;
    private String placeOfBirth;
    private String address;
    private String city;
    //    private Image image;
    private String phoneNumber;
    private String email;
    private double wallet;
}
