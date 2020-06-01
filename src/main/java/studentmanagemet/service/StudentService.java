package studentmanagemet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import studentmanagemet.entity.Student;

import java.net.URI;
import java.net.URISyntaxException;

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
}
