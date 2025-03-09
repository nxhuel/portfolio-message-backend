package com.nxhu.portfolio_message_backend.service.impl;

import com.nxhu.portfolio_message_backend.persistence.entity.MessageEntity;
import com.nxhu.portfolio_message_backend.persistence.repository.MessageRepository;
import com.nxhu.portfolio_message_backend.service.MessageService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService
{
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private JavaMailSender mailSender;

    public MessageServiceImpl(MessageRepository messageRepository, JavaMailSender mailSender)
    {
        this.messageRepository = messageRepository;
        this.mailSender = mailSender;
    }

    @Override
    public MessageEntity saveMessage(MessageEntity message) throws MessagingException
    {
        MessageEntity messageSaved = messageRepository.save(message);
        sendMail(message);

        return messageSaved;
    }

    public void sendMail(MessageEntity message) throws MessagingException
    {
        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);

        helper.setTo("nahueltisera03@gmail.com");
        helper.setSubject("Nuevo mensaje recibido");
        helper.setText(
                "<h2>Has recibido un nuevo mensaje</h2>" +
                        "<p><strong>Nombre:</strong> " + message.getName() + "</p>" +
                        "<p><strong>Apellido:</strong> " + message.getLastname() + "</p>" +
                        "<p><strong>Email:</strong> " + message.getEmail() + "</p>" +
                        "<p><strong>Mensaje:</strong> " + message.getContent() + "</p>",
                true
        );

        mailSender.send(mail);
    }

    @Override
    public List<MessageEntity> getMessages()
    {
        return messageRepository.findAll();
    }
}
