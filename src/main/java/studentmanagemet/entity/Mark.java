package studentmanagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Mark {

    private int id;
    private String faculty;
    private String discipline;
    private String typeOfTheExam;
    private String evaluationForm;
    private double mark;
    private double credits;
    private boolean fraud;
    private boolean partialEchivalation;
    private Date dateOfExam;
}
