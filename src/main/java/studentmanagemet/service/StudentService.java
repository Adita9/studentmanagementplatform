package studentmanagemet.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import studentmanagemet.entity.FileDocument;
import studentmanagemet.entity.Student;
import studentmanagemet.entity.StudentDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class StudentService {

    public RestTemplate restTemplate;

    @Autowired
    public StudentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Student getStudent(final Integer id) throws URISyntaxException {

        URI uri = new URI("http://localhost:9090/studentstorage/students/" + String.valueOf(id));

        return restTemplate.getForObject(uri, Student.class);
    }

    public byte[] getFiles(final String id) throws URISyntaxException, IOException {

        URI uri = new URI("http://localhost:9090/studentstorage/students/" + String.valueOf(id) + "/files");

        StudentDocument[] result = restTemplate.getForObject(uri, StudentDocument[].class);
        FileDocument fileValue = result[0].getFileValue();
        return fileValue.getContent();
//
    }

    public Student saveDocument(final Integer id, MultipartFile file, String email) throws URISyntaxException, IOException {
        byte[] bytes = file.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

//        MultiValueMap<String, Object> body
////                = new LinkedMultiValueMap<>();
////        body.add("file", bytes);

        FileDocument document = new FileDocument(bytes);

        StudentDocument studentDocument = StudentDocument.builder()
                .created(new Date())
                .accepted(false)
                .fileValue(document)
                .mimeType(file.getContentType())
                .name(file.getName())
                .professorEmail("catalin.boja@ie.ase.ro")
                .build();

        HttpEntity<StudentDocument> requestEntity
                = new HttpEntity<>(studentDocument);


        URI uri = new URI("http://localhost:9090/studentstorage/students/" + String.valueOf(id) + "/documents");

        return restTemplate.postForObject(uri, requestEntity, Student.class);
    }

    public List<StudentDocument> studentDocument(String id) throws URISyntaxException {


        URI uri = new URI("http://localhost:9090/studentstorage/students/" + id + "/files");

        StudentDocument[] forObject = restTemplate.getForObject(uri, StudentDocument[].class);

        return Arrays.asList(forObject);
    }

    static File writeByte(byte[] bytes, String name) {
        File file = new File("C:/Users/aneagoe/IdeaProjects/studentmanagementplatform/" + name);
        try {

            // Initialize a pointer
            // in file using OutputStream
            OutputStream
                    os
                    = new FileOutputStream(file);

            // Starts writing the bytes in it
            os.write(bytes);
            System.out.println("Successfully"
                    + " byte inserted");

            // Close the file
            os.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return file;
    }

    public void updateStatus(String id) throws URISyntaxException {

        URI uri = new URI("http://localhost:9090/studentstorage/students/" + String.valueOf(id) + "/status");

        log.info("Updating the status");

        restTemplate.getForObject(uri, Void.class);
    }
}
