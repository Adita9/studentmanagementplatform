package studentmanagemet.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ColleageYear {

    private int id;
    private String specialization;
    private String year;
    private String semester;
    private String state;
    private LearningForm learningForm;


}
