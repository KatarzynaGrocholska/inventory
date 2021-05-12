package pl.project.inventory.service;

import ch.qos.logback.classic.pattern.EnsureExceptionHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.project.inventory.config.EmailConfiguration;
import pl.project.inventory.entity.Country;
import pl.project.inventory.entity.Wine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmailServiceImp implements EmailService{

    @Autowired
    private JavaMailSender emailSender;

    private TemplateEngine templateEngine;

    public EmailServiceImp(JavaMailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        EmailConfiguration emailConfiguration= new EmailConfiguration();
        message.setFrom(emailConfiguration.getUsername());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
@Override
    public void sendHtmlMessage(String to, String subject) throws MessagingException {
    Wine wine = new Wine();
    Country country = new Country();
    List<Wine> wines = new ArrayList<>();
    Context context = new Context();
    context.setVariable("wine", wine);
    context.setVariable("country", country);
    context.setVariable("wines", wines);


    String EmailTemplate = templateEngine.process("/EmailTemplate", context);
    MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(EmailTemplate, true);
    emailSender.send(message);

}
@Override
    public void sendHtmlMessageEmpty(String to, String subject) throws MessagingException {

        Context context = new Context();
        String EmailTemplateEmpty = templateEngine.process("/EmailTemplateEmpty", context);
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(EmailTemplateEmpty, true);
        emailSender.send(message);
    }
}

