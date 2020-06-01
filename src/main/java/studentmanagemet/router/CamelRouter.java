package studentmanagemet.router;

import org.apache.camel.builder.RouteBuilder;

public class CamelRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:C:/Users/aneagoe/IdeaProjects/studentmanagementplatform?noop=true").doTry().setHeader("subject", simple("JavaInUse Invitation111"))
                .setHeader("to", simple("neagoe96@gmail.com"))
                .to("smtps://smtp.gmail.com:465?username=testcamelsmtp@gmail.com&password=ABC@123");
    }
}
