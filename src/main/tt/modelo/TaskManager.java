package main.tt.modelo;

import java.util.ArrayList;
import java.util.List;

public final class TaskManager {
    // TODO fazer as principais partes do gerenciador de tarefa - leitura e escrita de arquivo
    // É mais um loader de arquivos
    private final List<Task> tasks = new ArrayList<>();

    public TaskManager(){}

    public List<Task> getTasks() {
        return tasks;
    }
}
