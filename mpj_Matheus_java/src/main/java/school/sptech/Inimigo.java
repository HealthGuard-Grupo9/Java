package school.sptech;

import java.util.Random;

public class Inimigo {
    private final String nome;
    private int vida;
    private final int ataque;
    private final String arteAscii;

    // === ASCII ART (Java 15+ text blocks) ===
    private static final String ASCII_ESQUELETO = """
                              _.--""-._
      .                         ."         ".
     / \\    ,^.         /(     Y             |      )\\
    /   `---. |--'\\    (  \\__..'--   -   -- -'""-.-'  )
    |        :|    `>   '.     l_..-------.._l      .'
    |      __l;__ .'      "-.__.||_.-'v'-._||`"----"
     \\  .-' | |  `              l._       _.'
      \\/    | |                   l`^^'^^'j
            | |                _   \\_____/     _
            j |               l `--__)-'(__.--' |
            | |               | /`---``-----'"1 |  ,-----.
            | |               )/  `--' '---'   \\'-'  ___  `-.
            | |              //  `-'  '`----'  /  ,-'   I`.  \\
          _ L |_            //  `-.-.'`-----' /  /  |   |  `. \\
         '._' / \\         _/(   `/   )- ---' ;  /__.J   L.__.\\ :
          `._;/7(-.......'  /        ) (     |  |            | |
          `._;l _'--------_/        )-'/     :  |___.    _._./ ;
            | |                 .__ )-'\\  __  \\  \\  I   1   / /
            `-'                /   `-\\-(-'   \\ \\  `.|   | ,' /
                               \\__  `-'    __/  `-. `---'',-'
                                  )-._.-- (        `-----'
                                 )(  l\\ o ('..-.
                           _..--' _'-' '--'.-. |
                    __,,-'' _,,-''            \\ \\
                   f'. _,,-'                   \\ \\
                  ()--  |                       \\ \\
                    \\.  |                       /  \\
                      \\ \\                      |._  |
                       \\ \\                     |  ()|
                        \\ \\                     \\  /
                         ) `-.                   | |
                        // .__)                  | |
                     _.//7'                      | |
                   '---'                         j_| `
                                                  (| |
                                                   |  \\
                                                   |lllj
                                                   |||||
            """;

    private static final String ASCII_ORC = """
               _......._
           .-'.'.'.'.'.'.`-.
         .'.'.'.'.'.'.'.'.'.`.
        /.'.'               '.\\
        |.'    _.--...--._     |
        \\    `._.-.....-._.'   /
        |     _..- .-. -.._   |
     .-.'    `.   ((@))  .'   '.-.
    ( ^ \\      `--.   .-'     / ^ )
     \\  /         .   .       \\  /
     /          .'     '.  .-    \\
    ( _\\.    \\ (_`-._.-'_)    /._\\)
     `-' \\   ' .--.          / `-'
         |  / /|_| `-._.'\\   |
         |   |       |_| |   /-.._
     _..-\\   `.--.______.'  |
          \\       .....     |
           `.  .'      `.  /
             \\           .'
               `-..___..-`
            """;

    private static final String ASCII_CENTAUR0 = """
             =*===
           $$- - $$$
           $ <    D$$
           $ -   $$$
     ,     $$$$  |
    ///; ,---' _ |----.
     \\ )(           /  )
     | \\/ \\.   '  _.|  \\              $
     |  \\ /(   /    /\\_ \\          $$$$$
      \\ /  (       / /  )         $$$ $$$
           (  ,   /_/ ,`_,-----.,$$  $$$
           |   <----|  \\---##     \\   $$
           /         \\\\\\           |    $
          '   '                    |
          |                 \\      /
          /  \\_|    /______,/     /
         /   / |   /    |   |    /
        (   /--|  /.     \\  (\\  (_
         `----,( ( _\\     \\ / / ,/
               | /        /,_/,/
              _|/        / / (
             / (        ^-/, |
            /, |          ^-
            ^-
            """;

    public Inimigo(String nome, int vida, int ataque, String arteAscii) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.arteAscii = arteAscii;
    }

    // ==== FÁBRICAS ESTÁTICAS ====
    public static Inimigo criarEsqueleto() {
        return new Inimigo("Esqueleto", 60, 12, ASCII_ESQUELETO);
    }

    public static Inimigo criarOrc() {
        return new Inimigo("Orc", 80, 14, ASCII_ORC);
    }

    public static Inimigo criarCentauro() {
        return new Inimigo("Centauro", 70, 13, ASCII_CENTAUR0);
    }

    // (Opcional) ainda pode usar aleatório em outros pontos
    public static Inimigo gerarAleatorio() {
        return switch (new Random().nextInt(3)) {
            case 0 -> criarEsqueleto();
            case 1 -> criarOrc();
            default -> criarCentauro();
        };
    }

    // ==== AÇÕES ====
    public void atacar(Heroi heroi) {
        System.out.println(nome + " ataca causando " + ataque + " de dano!");
        heroi.receberDano(ataque);
    }

    public void receberDano(int dano) {
        vida -= dano;
        System.out.println(nome + " recebeu " + dano + " de dano!");
    }

    public void exibir() {
        System.out.println(arteAscii);
    }

    // ==== CONSULTAS ====
    public boolean estaVivo() { return vida > 0; }
    public String getNome()   { return nome; }
    public int getVida()      { return vida; }
    public int getAtaque()    { return ataque; }
}
