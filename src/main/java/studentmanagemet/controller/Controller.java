package studentmanagemet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import studentmanagemet.entity.Student;
import studentmanagemet.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    @PostMapping("/upload")
    public ResponseEntity upload(HttpServletRequest request) throws URISyntaxException, IOException {
        StandardMultipartHttpServletRequest multipartRequest = new StandardMultipartHttpServletRequest(request);

        MultipartFile pdf = multipartRequest.getFile("pdf");
        System.out.println(pdf.getContentType());

        studentService.saveDocument(1, pdf,"email");

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
