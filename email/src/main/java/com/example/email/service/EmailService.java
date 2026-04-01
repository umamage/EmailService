package com.example.email.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class EmailService {
    private static TemplateEngine templateEngine;
    private static Context context;
    private Logger log = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender emailSender;

    public void prepareAndSendEmail() throws MessagingException {
        String htmlTemplate = "templates/emailTemplate";
        String mailTo = "kugapryank@gmail.com";
        initializeTemplateEngine();
        context.setVariable("sender","ThymeLeaf Email");
        context.setVariable("mailTo", mailTo);
        String htmlBody = templateEngine.process(htmlTemplate,context);
        sendEmail(mailTo,"ThymeLeaf Email Demo", htmlBody);

    }
    private void sendEmail(String mailTo, String subject, String mailBody) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(mailTo);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(mailBody,true);
        emailSender.send(mimeMessage);
        log.info("Email sent to "+mailTo);

    }
    private static void initializeTemplateEngine()
    {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode("HTML");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        context = new Context(Locale.US);


    }


}
