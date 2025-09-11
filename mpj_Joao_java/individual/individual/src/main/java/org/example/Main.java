package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        final Integer maximoVetor = 50;

        Double[] valoresEntrada = new Double[maximoVetor];
        Double[] valoresConvertidos = new Double[maximoVetor];
        String[] tiposConversao = new String[maximoVetor];
        Integer contador = 0;

        Integer opcaoMenu;

        do {
            System.out.println("Opções de conversão:");
            System.out.println("1 - Celsius -> Fahrenheit");
            System.out.println("2 - Fahrenheit -> Celsius");
            System.out.println("3 - Metros -> Centímetros");
            System.out.println("4 - Centímetros -> Metros");
            System.out.println("5 - Reais -> Dólares");
            System.out.println("6 - Dólares -> Reais");
            System.out.println("7 - Mostrar histórico");
            System.out.println("0 - Sair");

            System.out.print("Escolha a opção: ");
            opcaoMenu = sc.nextInt();

            if (opcaoMenu == 0) {
                System.out.println("Programa encerrado.");
                break;
            }

            if (opcaoMenu == 7) {
                if (contador == 0) {
                    System.out.println("Nenhuma conversão realizada ainda.");
                } else {
                    System.out.println("\n===== HISTÓRICO DE CONVERSÕES =====");
                    for (int i = 0; i < contador; i++) {
                        System.out.println((i + 1) + ") " + tiposConversao[i] +
                                " -> " + valoresEntrada[i] + " = " + valoresConvertidos[i]);
                    }
                }
                continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            Double valor = sc.nextDouble();

            Double convertido;
            String tipo;

            switch (opcaoMenu) {
                case 1 -> {
                    convertido = (valor * 9 / 5) + 32;
                    tipo = "Celsius -> Fahrenheit";
                }
                case 2 -> {
                    convertido = (valor - 32) * 5 / 9;
                    tipo = "Fahrenheit -> Celsius";
                }
                case 3 -> {
                    convertido = valor * 100;
                    tipo = "Metros -> Centímetros";
                }
                case 4 -> {
                    convertido = valor / 100;
                    tipo = "Centímetros -> Metros";
                }
                case 5 -> {
                    convertido = valor / 5.0;
                    tipo = "Reais -> Dólares";
                }
                case 6 -> {
                    convertido = valor * 5.0;
                    tipo = "Dólares -> Reais";
                }
                default -> {
                    convertido = valor;
                    tipo = "Conversão inválida";
                    System.out.println("Opção inválida, valor não convertido.");
                }
            }


            if (contador < maximoVetor) {
                valoresEntrada[contador] = valor;
                valoresConvertidos[contador] = convertido;
                tiposConversao[contador] = tipo;
                contador++;
            } else {
                System.out.println("Histórico cheio, não é possível armazenar mais conversões.");
            }

            System.out.println("Resultado: " + tipo + " -> " + valor + " = " + convertido);

        } while (true);

        sc.close();
    }
}
