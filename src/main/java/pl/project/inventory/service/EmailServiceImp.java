package pl.project.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.project.inventory.entity.Wine;
import pl.project.inventory.repository.EmailRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableAsync
@EnableScheduling
public class EmailServiceImp implements EmailService{

    @Autowired
    private JavaMailSender emailSender;

    private TemplateEngine templateEngine;

    private EmailRepository emailRepository;


    public EmailServiceImp(JavaMailSender emailSender, TemplateEngine templateEngine, EmailRepository emailRepository) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
        this.emailRepository= emailRepository;
    }


@Override
//@Scheduled(fixedRate=50000)
//@Scheduled(cron = "@daily")
    public void sendHtmlMessage() throws MessagingException {
    Wine wine = new Wine();
    List<Wine> wines = new ArrayList<>();
    Context context = new Context();
    context.setVariable("wine", wine);
    context.setVariable("wines", emailRepository.getWineByAmount(wine.getName()));


    String EmailTemplate = templateEngine.process("/EmailTemplate", context);
    MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
    helper.setTo("admin@inventory.pl");
    helper.setSubject("Zamowienie");
    helper.setText(EmailTemplate, true);
    emailSender.send(message);

}

}

