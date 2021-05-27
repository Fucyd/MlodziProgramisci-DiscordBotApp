package pl.michalski.botapp;

import java.util.UUID;

public class MessageDto {
    private UUID uuid;
    private String author;
    private String message;
    private String created;

    public MessageDto(UUID uuid, String author, String message, String created) {
        this.uuid = uuid;
        this.author = author;
        this.message = message;
        this.created = created;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
