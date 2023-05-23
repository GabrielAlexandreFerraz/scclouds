import java.util.Scanner;

public class FibonacciLinear {
    public static int fibLinear(int n) {
        if (n <= 1) {
            return n;
        }

        int fibonacciMinus0 = 0;
        int fibonacciMinus1 = 1;
        int fibonacciLi = 0;

        for (int i = 2; i <= n; i++) {
            fibonacciLi = fibonacciMinus1 + fibonacciMinus0;
            fibonacciMinus0 = fibonacciMinus1;
            fibonacciMinus1 = fibonacciLi;
        }

        return fibonacciLi;
    }

    public static void main(String[] args) {
        System.out.print("Iniciando o Sitema--");
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("Digite um número inteiro maior que 0 e de preferência menor que 40");
                int n = scanner.nextInt();

                if (n <= 0) {
                    System.out.println("Valor inválido! O número deve ser inteiro e maior que 0.");
                } else {
                    int resultado = fibLinear(n);
                    System.out.println("O número Fibonacci de " + n + " é: " + resultado);
                }

                System.out.print("Deseja testar outro valor? (S/N): ");
                String escolha = scanner.next();

                if (escolha.equalsIgnoreCase("N")) {
                    continuar = false;
                }
            } catch (Exception e) {
                System.out.println("Valor inválido! O número deve ser inteiro e maior que 0.");
                scanner.nextLine();
            }
        }

        System.out.println("Encerrando o sistema.");
    }
}

