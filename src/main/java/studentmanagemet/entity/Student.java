package studentmanagemet.entity;

import lombok.*;

import java.util.List;


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
    private List<StudentDocument> documentsReferences;


}
