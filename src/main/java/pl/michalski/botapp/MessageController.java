package pl.michalski.botapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String showAllSupportMessages(Model model){
        //Musze stworzyć plik HTML, który za pomocą Thymeleaf wyświetli wartości na stronie.
        //musze odwołać się do serwisu, w którym musze wcześniej zrobić metodę,
        // która wyciągnie z bazy wiadomości i zwróci je w formie listy do controllera,
        // który potem przekaże te liste do pliku HTML w formie Atrybutu
        return "nazwa pliku HTML";
    }
}
