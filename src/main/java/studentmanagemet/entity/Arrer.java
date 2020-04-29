package studentmanagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Arrer {

    private int id;
    private int year;
    private int semester;
    private boolean isStudentParticipating;

}
