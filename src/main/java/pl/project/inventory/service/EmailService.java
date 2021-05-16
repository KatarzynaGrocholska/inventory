package pl.project.inventory.service;

import javax.mail.MessagingException;

public interface EmailService {

    public void sendHtmlMessage() throws MessagingException;


}
