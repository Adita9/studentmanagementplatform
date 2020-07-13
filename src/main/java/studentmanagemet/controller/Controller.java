package studentmanagemet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import studentmanagemet.entity.DisplayDocument;
import studentmanagemet.entity.Student;
import studentmanagemet.entity.StudentDocument;
import studentmanagemet.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(value = "/status/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity status(@PathVariable String id) throws URISyntaxException {
        studentService.updateStatus(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity(true, httpHeaders, HttpStatus.OK);
    }


    @GetMapping(value = "/displayFiles/{id}")
    public ResponseEntity getDocuments(@PathVariable String id) throws URISyntaxException {
        List<StudentDocument> documentsReferences = studentService.studentDocument(id);
        List<DisplayDocument> documents = new ArrayList<>();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", "*");

        for (StudentDocument s : documentsReferences) {
            DisplayDocument displayDocument = DisplayDocument.builder()
                    .accepted(s.isAccepted())
                    .download(s.getDownload())
                    .created(s.getCreated())
                    .name(s.getName())
                    .id(s.getId())
                    .professorEmail(s.getProfessorEmail())
                    .build();

            documents.add(displayDocument);
        }

        return new ResponseEntity(documents, httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity getFiles(@PathVariable String id) throws URISyntaxException, IOException {
        byte[] files = studentService.getFiles(id);
//        MultipartFile file = files.get(0);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_PDF);
        httpHeaders.add("Access-Control-Allow-Origin", "*");
        httpHeaders.setContentDispositionFormData("cerere.pdf", "cerere.pdf");
        httpHeaders.add("Content-Type", "application/pdf");
        return new ResponseEntity(files, httpHeaders, HttpStatus.OK);

    }


    @PostMapping("/upload")
    public ResponseEntity upload(HttpServletRequest request) throws URISyntaxException, IOException {
        StandardMultipartHttpServletRequest multipartRequest = new StandardMultipartHttpServletRequest(request);

        MultipartFile pdf = multipartRequest.getFile("pdf");

        System.out.println(pdf.getContentType());

        studentService.saveDocument(1, pdf, "email");

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
