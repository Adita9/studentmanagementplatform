package studentmanagemet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import studentmanagemet.entity.Student;
import studentmanagemet.service.StudentService;

import java.net.URISyntaxException;

@RestController
public class Controller {

    private StudentService studentService;

    @Autowired
    public Controller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity index(Model model) throws URISyntaxException {

        Student student = studentService.getStudent(1);
        model.addAttribute("Studentul", "stud");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity(student, httpHeaders, HttpStatus.OK);

    }


}
