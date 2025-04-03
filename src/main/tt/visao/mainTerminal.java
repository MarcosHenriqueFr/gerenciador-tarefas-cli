package main.tt.visao;

import main.tt.modelo.Commands;
import main.tt.modelo.TaskManager;

import java.util.Scanner;

// TODO fazer testes unitarios
public class mainTerminal {

    TaskManager manager = new TaskManager();
    Scanner scan = new Scanner(System.in);

    public mainTerminal() {

        begin();
        mainMenu();
    }

    private void begin() {
        System.out.println("Digite help se precisar de ajuda!");
    }

    private void mainMenu() {
        System.out.println("Digite 'exit' para sair!");

        String comandos;
        do {
            comandos = userInput();
            String[] args = comandos.split("\\s+");

            switch (args[0]) {
                case "add":
                    Commands.addTask(manager, args);
                    break;
                case "list":
                    Commands.listCommand(manager, args);
                    break;
                case "mark-in-progress":
                    Commands.markProgress(manager, args);
                    break;
                case "mark-done":
                    Commands.markDone(manager, args);
                    System.out.println("Marcada como feita");
                    break;
                case "update":
                    Commands.updateTaskName(manager, args);
                    break;
                case "delete":
                    Commands.deleteTask(manager, args);
                    System.out.println("Task eliminada");
                    break;
                case "help":
                    Commands.help();
                    break;
                case "clear":
                    Commands.limpar();
                case "exit":
                    System.out.println("Fim do programa!");
                    break;
                default:
                    System.out.println("Comando desconhecido! Digite 'help' se precisar de ajuda!");
            }
        } while (!comandos.equalsIgnoreCase("exit"));
    }

    /*
        Modifica a cor do texto no terminal e reseta para a cor padrão
     */
    private String userInput(){
        String INPUT_COLOR = "\u001B[33m";
        String TERMINAL_COLOR_RESET = "\033[0m";

        String consoleText = INPUT_COLOR + "task-cli => " + TERMINAL_COLOR_RESET;
        System.out.print(consoleText);

        return scan.nextLine();
    }
}