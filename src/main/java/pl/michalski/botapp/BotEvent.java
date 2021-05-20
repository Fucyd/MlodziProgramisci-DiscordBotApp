package pl.michalski.botapp;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

public class BotEvent extends ListenerAdapter {

    private final MessageService messageService;

    @Autowired
    public BotEvent(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        //#support
        final String authorName = event.getAuthor().getName();
        final String messageSent = event.getMessage().getContentRaw();
        if(messageSent.contains("#support") && !event.getAuthor().isBot()){
            final SupportMessageDto dto = new SupportMessageDto();
            dto.setAuthor(authorName);
            dto.setMessage(messageSent.replace("#support", ""));
            messageService.saveMessage(dto);
            event.getChannel()
                    .sendMessage("Dziękujemy za kontakt z supportem. Postaramy się na nią odpowiedzieć tak szybko, jak to możliwe")
                    .queue();
        }
    }
}
