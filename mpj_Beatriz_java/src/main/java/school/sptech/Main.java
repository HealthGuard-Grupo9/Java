package school.sptech;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        List<String> tarefas = new ArrayList<>();


        Scanner leitor = new Scanner(System.in);


        while (true) {
            System.out.println("-".repeat(46));
            System.out.println("-".repeat(46));
            System.out.println("  HealthTask — Simplificando sua rotina.   ");
            System.out.println("-".repeat(46));
            System.out.println("| 1 - Ver tarefas                            |");
            System.out.println("| 2 - Cadastrar tarefa                       |");
            System.out.println("| 3 - Excluir tarefa                         |");
            System.out.println("| 0 - Sair                                   |");
            System.out.println("-".repeat(46));
            System.out.print("Digite: ");

            Integer numero = leitor.nextInt();

            leitor.nextLine();



            if (numero == 1) {
                if (tarefas.isEmpty()) {
                    System.out.println("Nenhuma tarefa cadastrada ainda!");
                }

                else {
                    System.out.println("Tarefas cadastradas:");

                    for (int i = 0; i < tarefas.size(); i++) {

                        System.out.println((i + 1) + " - " + tarefas.get(i));

                    }
                }


            }


            else if (numero == 2) {

                System.out.print("Digite a tarefa: ");

                String tarefa = leitor.nextLine();


                tarefas.add(tarefa);
                System.out.println("Tarefa cadastrada!");
            }


            else if (numero == 3) {

                if (tarefas.isEmpty()) {
                    System.out.println("Não há tarefas para excluir!");
                }

                else {
                    System.out.println("Escolha a tarefa para excluir:");

                    for (int i = 0; i < tarefas.size(); i++) {


                        System.out.println((i + 1) + " - " + tarefas.get(i));
                    }

                    System.out.print("Digite o número da tarefa: ");
                    Integer numeroTarefa = leitor.nextInt();




                    if (numeroTarefa >= 1 && numeroTarefa <= tarefas.size()) {

                        String removida = tarefas.remove(numeroTarefa - 1);
                        System.out.println("Tarefa \"" + removida + "\" excluída!");
                    }

                    else {
                        System.out.println("Número inválido!");
                    }
                }
            } else if (numero == 0) {
                System.out.println("Encerrando...");
                break;
            }
            else {
                System.out.println("Por favor, escolha uma opção válida!");
            }
        }


        leitor.close();
    }

}
