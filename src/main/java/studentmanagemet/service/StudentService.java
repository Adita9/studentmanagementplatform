package studentmanagemet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import studentmanagemet.entity.Student;
import studentmanagemet.entity.StudentDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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
        String fileValue = result[0].getFileValue();
        return fileValue.getBytes();
//        List<MultipartFile> pfds = new ArrayList<>();


//        List<StudentDocument> studentDocuments = Arrays.asList(result);
//        for (StudentDocument s : studentDocuments) {
//            String fileValue = s.getFileValue();
//            File file = writeByte(fileValue.getBytes(), s.getName());
//            DiskFileItem fileItem = new DiskFileItem("file.pdf",
//                    "application/pdf", true, file.getName(),
//                    100000000, file.getParentFile());
//            InputStream input =  new FileInputStream(file);
//            OutputStream os = fileItem.getOutputStream();
//            int ret = input.read();
//            while ( ret != -1 )
//            {
//                os.write(ret);
//                ret = input.read();
//            }
//            os.flush();
//            MultipartFile pdf = new CommonsMultipartFile(fileItem);
//            pfds.add(pdf);
//        }

//        return pfds;
    }

    public Student saveDocument(final Integer id, MultipartFile file, String email) throws URISyntaxException, IOException {
        byte[] bytes = file.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", bytes);

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);


        URI uri = new URI("http://localhost:9090/studentstorage/students/" + String.valueOf(id) + "/documents");

        return restTemplate.postForObject(uri, requestEntity, Student.class);
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
}
