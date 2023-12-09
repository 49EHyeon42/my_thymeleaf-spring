package dev.ehyeon.my_thymeleaf;

import java.time.LocalDateTime;

public class User {

    private long id;
    private String name;
    private LocalDateTime createdDate;

    public User(long id, String name, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
