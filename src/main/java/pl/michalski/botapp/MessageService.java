package pl.michalski.botapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class MessageService {

    private final SupportMessageRepository messageRepository;

    @Autowired
    public MessageService(final SupportMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    //potrzebujemy metody do zapisu wiadomośći z discorda w bazie
    // musi zapisać nowy obiekt SupportMessage w bazie - jego wartości pobierzemy z SupportMessageDto,
    // które te wartości pobierze z BotEventu


    public void saveMessage(final SupportMessageDto messageDto) {
        final SupportMessage supportMessage = new SupportMessage();
        supportMessage.setUuid(UUID.randomUUID());
        supportMessage.setAuthor(messageDto.getAuthor());
        supportMessage.setMessage(messageDto.getMessage());
        supportMessage.setCreated(LocalDateTime.now());

        messageRepository.save(supportMessage);
    }
}
