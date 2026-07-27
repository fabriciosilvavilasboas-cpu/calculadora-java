import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 8) {
            exibirMenu();
            System.out.print("Digite a opção desejada: ");
            opcao = teclado.nextInt();

            if (opcao == 8) {
                System.out.println("\n=================================");
                System.out.println("   Encerrando a Calculadora...   ");
                System.out.println("       Até a próxima!      ");
                System.out.println("=================================");
            } else if (opcao >= 1 && opcao <= 7) {
                processarOperacao(opcao, teclado);
            } else {
                System.out.println("\n❌ Opção inválida! Escolha um número de 1 a 8.");
            }
        }
    }

    // Método para exibir o menu bonito
    public static void exibirMenu() {
        System.out.println("\n=================================");
        System.out.println("            CALCULADORA    ");
        System.out.println("=================================");
        System.out.println("  1 - Somar (+)");
        System.out.println("  2 - Subtrair (-)");
        System.out.println("  3 - Multiplicar (*)");
        System.out.println("  4 - Dividir (/)");
        System.out.println("  5 - Porcentagem (%)");
        System.out.println("  6 - Potência (x^y)");
        System.out.println("  7 - Raiz Quadrada (√)");
        System.out.println("  8 - Sair (Exit)");
        System.out.println("=================================");
    }

    // Método para processar a escolha do usuário
    public static void processarOperacao(int opcao, Scanner teclado) {
        // Se for Raiz Quadrada (opção 7), só precisamos de 1 número!
        if (opcao == 7) {
            System.out.print("Digite o número: ");
            double num = teclado.nextDouble();
            if (num < 0) {
                System.out.println(" Erro: Não existe raiz quadrada de número negativo nos reais!");
            } else {
                System.out.println(" Resultado da Raiz Quadrada: " + Math.sqrt(num));
            }
            return;
        }

        // Para as outras operações (1 a 6), precisamos de 2 números
        System.out.print("Digite o primeiro número: ");
        double num1 = teclado.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = teclado.nextDouble();

        switch (opcao) {
            case 1:
                System.out.println(" Resultado da Soma: " + (num1 + num2));
                break;
            case 2:
                System.out.println(" Resultado da Subtração: " + (num1 - num2));
                break;
            case 3:
                System.out.println(" Resultado da Multiplicação: " + (num1 * num2));
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println(" Erro: Não é possível dividir por zero!");
                } else {
                    System.out.println(" Resultado da Divisão: " + (num1 / num2));
                }
                break;
            case 5:
                // num1 é a taxa (%) e num2 é o valor total
                // Exemplo: num1 = 5, num2 = 10 -> (5 * 10) / 100 = 0.5
                double porcentagem = (num1 * num2) / 100;
                System.out.println( + num1 + "% de " + num2 + " é: " + porcentagem);
                break;
            case 6:
                System.out.println(" Resultado da Potência: " + Math.pow(num1, num2));
                break;
        }
    }
}