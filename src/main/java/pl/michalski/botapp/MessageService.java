package pl.michalski.botapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final SupportMessageRepository messageRepository;

    @Autowired
    public MessageService(final SupportMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MessageDto> getMessages() {
        return messageRepository.findAll().stream()
                .map(supportMessage -> new MessageDto(supportMessage.getUuid(),
                        supportMessage.getAuthor(),
                        supportMessage.getMessage(),
                        supportMessage.getCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))))
                .collect(Collectors.toList());
    }

    public void saveMessage(final SupportMessageDto messageDto) {
        final SupportMessage supportMessage = new SupportMessage();
        supportMessage.setUuid(UUID.randomUUID());
        supportMessage.setAuthor(messageDto.getAuthor());
        supportMessage.setMessage(messageDto.getMessage());
        supportMessage.setCreated(LocalDateTime.now());

        messageRepository.save(supportMessage);
    }
}
