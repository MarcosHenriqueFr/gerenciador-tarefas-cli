package main.tt.visao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminalPrincipal {

    Scanner scan = new Scanner(System.in);
    List<String> args = new ArrayList<>();

    public TerminalPrincipal() {

        inicio();
        menuPrincipal();
    }

    private void inicio() {
        System.out.println("Os comandos aceitos no sistema começam com 'task-cli'.\n" +
                        "Digite 'task-cli help' caso possua dúvidas sobre os comandos");
    }

    private void menuPrincipal() {
        String comandosEntrada, comandos;

        System.out.println("O que você quer fazer?");
        comandosEntrada = scan.nextLine();

        comandos = comandosEntrada;
        for(int i = 0; i < comandos.length(); i++){
            // TODO fazer uma melhor implementação ta dando erro
            if(comandos.charAt(i) == ' '){
                args.add(comandos.substring(0, i));
                comandos = comandos.substring(i + 1);
            }
        }

        System.out.println(args.toString());
        System.out.println(comandos);

    }
}
