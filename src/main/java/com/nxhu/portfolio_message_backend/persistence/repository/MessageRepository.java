package com.nxhu.portfolio_message_backend.persistence.repository;

import com.nxhu.portfolio_message_backend.persistence.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long>
{
}
