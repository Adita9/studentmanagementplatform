package studentmanagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Exam {

    private int id;
    private String year;
//    @OneToMany
//    private Map<Map<String, String>, String> mapSchedule;
}
