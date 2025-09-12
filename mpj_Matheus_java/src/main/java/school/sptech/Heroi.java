package school.sptech;

import java.util.Random;

public class Heroi {
    private String nome;
    private int vida;
    private int ataque;
    private int pocoes;

    // Construtor completo (usado em JogoRPG)
    public Heroi(String nome, int vida, int ataque, int pocoes) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.pocoes = pocoes;
    }

    // Construtor padrão (valores por omissão)
    public Heroi(String nome) {
        this(nome, 100, 15, 3);
    }

    // Exibe status resumido do herói
    public void exibirStatus() {
        System.out.printf("Herói: %s | Vida: %d | Ataque: %d | Poções: %d%n",
                nome, vida, ataque, pocoes);
    }

    // Ataca um inimigo
    public void atacar(Inimigo inimigo) {
        System.out.println(nome + " ataca o " + inimigo.getNome() + " causando " + ataque + " de dano!");
        inimigo.receberDano(ataque);
    }

    // Usa uma poção de cura (cura fixa)
    public void usarPocao() {
        if (pocoes > 0) {
            vida += 30;
            pocoes--;
            System.out.println(nome + " usou uma poção e recuperou 30 de vida!");
        } else {
            System.out.println("Você não tem mais poções!");
        }
    }

    // Evento de encontrar um baú (mostra ASCII e aplica loot)
    public void encontrarBau() {
        Random random = new Random();

        // ASCII do baú
        System.out.println(
                "⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣠⣾⣿⠿⢋⣡⣴⣶⣶⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⢀⣾⣿⡟⢁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⠆⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⢀⣾⣿⠏⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢁⣴⣾⣿⠟⠋⣀⣤⣤⡀⠀⠀\n" +
                "⠀⣼⣿⡟⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠁⣴⣿⣿⠟⢁⣴⣿⣿⣿⣿⣿⡄⠀\n" +
                "⠀⣉⠛⠃⠸⢿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢀⣾⣿⡿⠁⣰⣿⣿⣿⣿⣿⣿⣿⡧⠀\n" +
                "⠀⣿⣿⡆⢠⣤⠀⣉⠙⠛⠿⢿⣿⣿⠀⣾⣿⣿⠃⣼⣿⣿⣿⣿⠿⠛⢉⣡⣤⠀\n" +
                "⠀⣿⣿⡇⢸⣿⠀⣿⠿⠷⣶⠀⣈⡁⠀⠻⠿⡟⠀⠿⠟⠋⣁⣠⣴⣾⣿⣿⣿⠀\n" +
                "⠀⣿⣿⡇⢸⣿⠀⣿⡄⢠⣿⠀⣿⡇⠀⣶⣦⡄⠀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⠀\n" +
                "⠀⣿⣿⡇⢸⣿⠀⠿⢧⣾⣿⠀⣿⡇⠀⣿⣿⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\n" +
                "⠀⣿⣿⡇⢸⣿⣷⣶⣤⣄⣉⠀⣿⡇⠀⣿⣿⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\n" +
                "⠀⠉⠛⠃⢸⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣿⣿⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠉⠙⠛⠿⣿⣿⣿⡇⠀⣿⣿⡇⠀⣿⣿⣿⣿⣿⣿⠿⠛⠉⠁⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠻⢿⡇⠀⣿⠿⠛⠉⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");

        // 50% arma (+5 ataque) / 50% poções (+2)
        if (random.nextInt(100) < 50) {
            ataque += 5;
            System.out.println("Você encontrou um baú com uma arma melhor! Seu ataque aumentou para " + ataque);
        } else {
            pocoes += 2;
            System.out.println("Você encontrou um baú com 2 poções de cura! Poções agora: " + pocoes);
        }
    }

    // Recebe dano
    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
        System.out.println(nome + " recebeu " + dano + " de dano!");
    }

    // Consultas / getters
    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getPocoes() {
        return pocoes;
    }
}
