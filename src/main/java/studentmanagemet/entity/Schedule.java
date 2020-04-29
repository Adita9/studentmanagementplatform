package studentmanagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {


    private int id;
    private String year;
//    @OneToMany(mappedBy = "schedule")
//    private Map<Map<String,String>,String> mapSchedule;

}
