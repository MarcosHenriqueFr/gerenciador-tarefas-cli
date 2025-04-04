package main.tt.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private static Long quantTasks = 0L;

    private final Long ID;
    private String name;
    private Status status;

    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");


    Task(Long ID, String name){
        this.ID = ID;
        setStatus(Status.TODO);
        setName(name);
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    Task(Long ID, String name, Status status, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.name = name;
        this.ID = ID;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public static Long getQuantTasks(){
        return quantTasks;
    }

    static void aumentarQuant(){
        quantTasks++;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public Long getID() {
        return ID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("Id: %d | Nome: %s | Data: %s | Hora: %s | Status: %s",
                ID, name, updatedAt.format(formatData), updatedAt.format(formatTime), status);
    }
}