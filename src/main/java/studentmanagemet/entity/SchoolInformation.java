package studentmanagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolInformation implements Serializable {

    private int id;
    private List<ColleageYear> collageYear;
    private Schedule schedule;
    private List<Exam> exam;
    private Map<String, Mark> mark;
    private Map<String, Tax> tax;
    private List<Arrer> arrer;


}
