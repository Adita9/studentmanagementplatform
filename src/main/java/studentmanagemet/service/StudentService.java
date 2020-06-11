package studentmanagemet.service;


import org.apache.commons.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import studentmanagemet.entity.RequestDto;
import studentmanagemet.entity.Student;
import studentmanagemet.entity.StudentDocument;

import java.io.File;
import java.io.IOException;
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
}
