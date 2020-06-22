package studentmanagemet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import studentmanagemet.entity.Student;
import studentmanagemet.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;
import static org.springframework.http.MediaType.APPLICATION_PDF;

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

    @GetMapping("/status")
    public ResponseEntity status() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity(true, httpHeaders, HttpStatus.OK);
    }


    @GetMapping(value = "/files/{id}", produces = MediaType.APPLICATION_PDF_VALUE)

    public ResponseEntity getFiles(@PathVariable String id) throws URISyntaxException, IOException {
        byte[] files = studentService.getFiles(id);
//        MultipartFile file = files.get(0);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_PDF);
        httpHeaders.add("Access-Control-Allow-Origin", "*");
        httpHeaders.setContentDispositionFormData("cerere.pdf", "cerere.pdf");
        httpHeaders.add("Content-Type","application/pdf");
        return new ResponseEntity(files, httpHeaders, HttpStatus.OK);

    }


    @PostMapping("/upload")
    public ResponseEntity upload(HttpServletRequest request, @RequestParam String email) throws URISyntaxException, IOException {
        StandardMultipartHttpServletRequest multipartRequest = new StandardMultipartHttpServletRequest(request);

        MultipartFile pdf = multipartRequest.getFile("pdf");
        System.out.println(pdf.getContentType());

        studentService.saveDocument(1, pdf, "email");

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
