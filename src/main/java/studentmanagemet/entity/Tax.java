package studentmanagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tax {

    private int id;
    private String name;
    private String description;
    private String nrDoc;
    private double sum;
}
