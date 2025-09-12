package school.sptech;

import java.util.Scanner;

public class JogoRPG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Random random = new Random();

        // Criar herói
        System.out.println("=== BEM-VINDO AO RPG ===");
        System.out.print("Digite o nome do seu herói: ");
        String nomeHeroi = sc.nextLine();
        Heroi heroi = new Heroi(nomeHeroi);

        // Loop principal do jogo
        while (heroi.estaVivo()) {

            // Gerar inimigo aleatório
            Inimigo inimigo = Inimigo.gerarAleatorio();

            System.out.println("\nUm inimigo apareceu!");
            inimigo.exibir();

            boolean batalhaAtiva = true;

            // Loop de batalha
            while (heroi.estaVivo() && inimigo != null && inimigo.estaVivo() && batalhaAtiva) {
                heroi.exibirStatus();
                System.out.println("\nEscolha uma ação:");
                System.out.println("1 - Atacar");
                System.out.println("2 - Usar Poção");
                System.out.println("3 - Fugir");
                System.out.print("> ");
                int escolha = sc.nextInt();

                limparConsole();

                switch (escolha) {
                    case 1 -> { // Atacar
                        heroi.atacar(inimigo);
                        if (inimigo.estaVivo()) {
                            inimigo.atacar(heroi);
                        } else {
                            System.out.println("\nVocê derrotou o " + inimigo.getNome() + "!");
                            heroi.encontrarBau();
                        }
                    }
                    case 2 -> { // Usar poção
                        heroi.usarPocao();
                        if (inimigo.estaVivo()) {
                            inimigo.atacar(heroi);
                        }
                    }
                    case 3 -> { // Fugir
                        System.out.println("Você fugiu da batalha!");
                        inimigo = null;
                        batalhaAtiva = false; // sai do loop da batalha
                    }
                    default -> System.out.println("Escolha inválida!");
                }
            }
        }

        System.out.println("\n=== GAME OVER ===");
        sc.close();
    }

    // Função utilitária para limpar consoleCléber
    public static void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Não foi possível limpar o console.");
        }
    }
}
