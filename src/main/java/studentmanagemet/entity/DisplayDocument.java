package studentmanagemet.entity;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisplayDocument {

    private Long id;
    private String name;
    private boolean accepted;
    private String professorEmail;
    private String download;
}
