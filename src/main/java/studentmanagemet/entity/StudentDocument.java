package studentmanagemet.entity;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDocument {
    private Long id;
    private String name;
    private Date created = new Date();
    private String summary;
    private boolean accepted;
    private String professorEmail;
    private FileDocument fileValue;
    private String download;

    private String contentId;
    private long contentLength;
    private String mimeType = "application/pdf";

}
