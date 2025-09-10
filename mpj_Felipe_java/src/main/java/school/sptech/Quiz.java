import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {

        Scanner leitorRespostas = new Scanner(System.in);





        String[] perguntas = {
                "1) Qual palavra-chave usamos para criar uma classe em Java?",
                "2) Qual operador representa \"OU lógico\" em Java?",
                "3) Qual operador representa \"E lógico\" em Java?",
                "4) Qual palavra-chave usamos para encerrar um loop imediatamente?",
                "5) Qual palavra-chave usamos para verificar uma condição?",
                "6) Java é uma linguagem híbrida/interpretada/compilada?",

        };


        String[] respostas = {
                "class",
                "||",
                "&&",
                "break",
                "if",
                "híbrida",
        };

        Integer score = 0;


        System.out.println("""
                
                
                 $$$$$$\\            $$\\                    $$$$$\\                             \s
                $$  __$$\\           \\__|                   \\__$$ |                            \s
                $$ /  $$ |$$\\   $$\\ $$\\ $$$$$$$$\\             $$ | $$$$$$\\ $$\\    $$\\ $$$$$$\\ \s
                $$ |  $$ |$$ |  $$ |$$ |\\____$$  |            $$ | \\____$$\\\\$$\\  $$  |\\____$$\\\s
                $$ |  $$ |$$ |  $$ |$$ |  $$$$ _/       $$\\   $$ | $$$$$$$ |\\$$\\$$  / $$$$$$$ |
                $$ $$\\$$ |$$ |  $$ |$$ | $$  _/         $$ |  $$ |$$  __$$ | \\$$$  / $$  __$$ |
                \\$$$$$$ / \\$$$$$$  |$$ |$$$$$$$$\\       \\$$$$$$  |\\$$$$$$$ |  \\$  /  \\$$$$$$$ |
                 \\___$$$\\  \\______/ \\__|\\________|       \\______/  \\_______|   \\_/    \\_______|
                     \\___|                                                                    \s
                                     """);


        for (int i = 0; i < perguntas.length; i++) {
            System.out.println(perguntas[i]);
            String resposta = leitorRespostas.nextLine().toLowerCase();


            if (resposta.equals(respostas[i])) {
                System.out.println("Acertou!");
                System.out.println("-".repeat(55));
                score++;
            } else {
                System.out.println("Errou! A resposta certa é: " + respostas[i]);
                System.out.println("-".repeat(55));
            }
        }

        System.out.println("Quiz finalizado!");
        System.out.println("Você acertou " + score + " de " + perguntas.length + " perguntas.");


    }
}
