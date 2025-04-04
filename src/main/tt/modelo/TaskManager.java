package main.tt.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public void writeFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("arquivoBase.txt"));
            for(Task t: tasks){
                writer.write(t.getID() + " ");
                writer.write(t.getName() + " ");
                writer.write(t.getStatus() + " ");
                writer.write(t.getCreatedAt() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }

    /*
        O único objetivo desse read é atualizar o task manager
     */

    public void readFile(){
        try {
            /*
                Por enquanto a manipulação é direto no arquivo.
             */
            BufferedReader reader = new BufferedReader(new FileReader("arquivoBase.txt"));
            String line;
            List<String> taskStrings = new ArrayList<>();
            String[] attributes;

            /*
                Pega cada linha e coloca em uma lista de tarefas como strings
             */

            while((line = reader.readLine()) != null){
                taskStrings.add(line);
            }

            /*
                'Desmembra' cada tarefa com os seus atributos
             */

            for (String taskString : taskStrings) {
                attributes = taskString.split("\\s+");
                DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");

                Long ID = Long.parseLong(attributes[0]);
                String name = attributes[1];
                Status status = Status.valueOf(attributes[2]);
                LocalDateTime createdAt = LocalDateTime.parse(attributes[3], parser);

                tasks.add(new Task(ID, name, status, createdAt));
                Task.aumentarQuant();
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Problema de saída de dados.");
        }
    }
}
