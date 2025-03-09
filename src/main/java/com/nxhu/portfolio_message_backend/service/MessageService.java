package com.nxhu.portfolio_message_backend.service;

import com.nxhu.portfolio_message_backend.persistence.entity.MessageEntity;
import jakarta.mail.MessagingException;

import java.util.List;

public interface MessageService
{
    MessageEntity saveMessage(MessageEntity message) throws MessagingException;

    List<MessageEntity> getMessages();
}
