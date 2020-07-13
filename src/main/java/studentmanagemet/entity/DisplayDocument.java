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
    private Date created = new Date();
    private String summary;
    private boolean accepted;
    private String professorEmail;
    private String download;
    private String mimeType = "application/pdf";
}
