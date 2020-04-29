package studentmanagemet.entity;

import lombok.*;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {

    private int id;
    private PersonalInfo personalInfo;
    private SchoolInformation schoolInformation;


}
