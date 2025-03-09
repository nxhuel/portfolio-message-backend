package com.nxhu.portfolio_message_backend.dto;

import com.nxhu.portfolio_message_backend.persistence.entity.MessageEntity;

public class MessageRequest
{
    private MessageEntity message;

    public MessageRequest()
    {
    }

    public MessageRequest(MessageEntity message)
    {
        this.message = message;
    }

    public MessageEntity getMessage()
    {
        return message;
    }

    public void setMessage(MessageEntity message)
    {
        this.message = message;
    }
}
