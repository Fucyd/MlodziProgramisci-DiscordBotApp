package pl.michalski.botapp;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.LoginException;

@Configuration
public class BotConfiguration {
    private static final String TOKEN = "ODI0Njk0MjI1ODY5NzMzODk5.YFzGWQ.9H1uQSxbipKVK5XdvMQ0BmlL0OM";

    @Autowired
    MessageService messageService;

    @Bean
    public void bot() throws LoginException {
        JDA jda = JDABuilder.createDefault(TOKEN).build();
        jda.addEventListener(new BotEvent(messageService));
    }
}
