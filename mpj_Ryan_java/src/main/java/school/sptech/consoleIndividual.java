package school.sptech;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class consoleIndividual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tarefas = new ArrayList<>();
        List<Integer> tempoTarefas = new ArrayList<>();
        List<String> semana = List.of("Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo");
        List<Integer> tempoSemana = new ArrayList<>();
        String respAddTarefa = "sim";

        List<String> semanaOrdenada = new ArrayList<>();
        List<String> tarefaOrdenada = new ArrayList<>();

        while (respAddTarefa.equals("sim")) {
            Boolean valorInvalido = true;
            System.out.println("Digite uma tarefa para realizar nessa semana: ");
                String tarefa = scanner.nextLine();
                tarefas.add(tarefa);

                while (valorInvalido) {
                    System.out.println("Adicionar mais alguma? (sim/não)");
                    String respAdd = scanner.nextLine();

                    if (respAdd.equals("sim")) {
                        respAddTarefa = respAdd;
                        valorInvalido = false;
                    }
                    else if (respAdd.equals("não")) {
                        respAddTarefa = respAdd;
                        valorInvalido = false;
                    }
                    else {
                        System.out.println("Digite um valor válido!");
                        valorInvalido = true;
                    }
                }
        }

        System.out.println("Vamos analisá-las:");

        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println("Quanto tempo (em min) você demora para " + tarefas.get(i) + "? ");
            Integer minTarefa = scanner.nextInt();
            tempoTarefas.add(minTarefa);
        }

        System.out.println("Agora vamos ver sua disponibilidade:");

        for (int i = 0; i < semana.size(); i++) {
            System.out.println("Quanto tempo livre (em min) você tem na " + semana.get(i) + "? ");
            Integer minSemana = scanner.nextInt();
            tempoSemana.add(minSemana);
        }

        for (int i = 0; i < tarefas.size(); i++) {
            Integer tempoTarefa = tempoTarefas.get(i);
            Integer contador = 0;

            for (int j = 0; j < tempoSemana.size(); j++) {
                if (tempoTarefa <= tempoSemana.get(j)) {
                    tarefaOrdenada.add(tarefas.get(i));
                    semanaOrdenada.add(semana.get(j));

                    tempoSemana.set(j, tempoSemana.get(j) - tempoTarefa);
                    contador++;
                    break;
                }
            }

            if (contador.equals(0)) {
                tarefaOrdenada.add(tarefas.get(i));
                semanaOrdenada.add("A tarefa não será feita nessa semana.");
            }
        }

        System.out.println("Organizado para você...");
            System.out.printf("%-10s | %-5s\n", "Tarefa:", "Semana:");
            System.out.println("-------------------");

            for (int i = 0; i < semanaOrdenada.size(); i++) {
                System.out.printf("%-10s | %-5s\n", tarefaOrdenada.get(i), semanaOrdenada.get(i));
            }
    }
}