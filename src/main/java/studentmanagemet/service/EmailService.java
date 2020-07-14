package studentmanagemet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import studentmanagemet.entity.Student;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


@Component
public class EmailService {

    private String host = "localhost";
    private int port = 587;
    private String username = "admin@licenta.com";
    private String password = "parolalicenta";

    private int fileId = 0;

    @Autowired
    public EmailService() {

        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;

    }

    public void sendMail(MultipartFile file, Student student) {

        File convFile = new File(file.getOriginalFilename());
        try {

            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("admin2@licenta.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("admin@licenta.com"));
            message.setSubject("Mail Subject");
            System.out.println(fileId);
            String msg = " Student :" + student.getPersonalInfo().getName() + "  with email: " + student.getPersonalInfo().getEmail() +" sent you a bachelor degree thesis request. If you want to " +
                    "accept the request "+ "\n<a href=' http://localhost:9090/studentstorage/students/1/files/" + fileId + "'>click here</a>\" ";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(convFile);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);

            Transport.send(message);
            fileId++;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

