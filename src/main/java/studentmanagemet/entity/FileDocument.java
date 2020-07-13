package studentmanagemet.entity;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileDocument {

    private byte[] content;
}
