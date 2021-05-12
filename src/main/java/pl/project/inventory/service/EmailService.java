package pl.project.inventory.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.project.inventory.entity.Country;
import pl.project.inventory.entity.User;
import pl.project.inventory.entity.Wine;

import javax.mail.MessagingException;
import java.util.Arrays;
import java.util.Collection;

public interface EmailService {
    public void sendSimpleMessage(String to, String subject, String text);
    public void sendHtmlMessage(String to, String subject) throws MessagingException;
    public void sendHtmlMessageEmpty(String to, String subject) throws MessagingException;

}
