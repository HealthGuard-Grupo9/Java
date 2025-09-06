package school.sptech;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("🌎✨ Olá! Bem-vindo(a) ao Time on Earth ✨🌎");
        System.out.print("Antes de começarmos, digite seu primeiro nome: ");
        String nome = scanner.nextLine();

        System.out.printf("\nOlá %s! Esse projeto vai mostrar quanto tempo você está vivo(a) na Terra.\n", nome);
        System.out.print("Vamos lá? (sim/não): ");
        String decisao = scanner.nextLine().trim().toLowerCase();

        if (!decisao.equals("sim")) {
            System.out.println("Obrigado por nos conhecer! Encerrando programa...");
            return;
        }

        LocalDate nascimento = null;

        
        while (nascimento == null) {
            System.out.print("\nInforme sua data de nascimento (AAAA-MM-DD): ");
            String dtNasc = scanner.nextLine();

            try {
                nascimento = LocalDate.parse(dtNasc, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Data inválida! Certifique-se de usar o formato AAAA-MM-DD e uma data real.");
            }
        }


        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(nascimento, hoje);

        long totalDias = java.time.temporal.ChronoUnit.DAYS.between(nascimento, hoje);
        long horas = totalDias * 24;
        long minutos = horas * 60;
        long segundos = minutos * 60;


        System.out.println("\n🎉 Resultado 🎉");
        System.out.printf("Você está vivo(a) há aproximadamente:\n");
        System.out.printf("➡ %d anos, %d meses e %d dias\n", idade.getYears(), idade.getMonths(), idade.getDays());
        System.out.printf("➡ %d horas\n", horas);
        System.out.printf("➡ %d minutos\n", minutos);
        System.out.printf("➡ %d segundos\n", segundos);
        System.out.println("\nObrigado por usar o Time on Earth! 🌟");

        scanner.close();
    }
}
