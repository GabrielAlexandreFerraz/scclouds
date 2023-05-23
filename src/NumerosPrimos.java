import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumerosPrimos {

    public static List<Integer> p(int n) {
        List<Integer> primos = new ArrayList<>();
        if (n < 2) {
            return primos;
        }

        return encontrarPrimos(n, 2, primos);
    }

    private static List<Integer> encontrarPrimos(int n, int atual, List<Integer> primos) {
        if (atual > n) {
            return primos;
        }

        if (ePrimo(atual, primos)) {
            primos.add(atual);
        }

        return encontrarPrimos(n, atual + 1, primos);
    }

    private static boolean ePrimo(int num, List<Integer> primos) {
        for (int primo : primos) {
            if (num % primo == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print("Iniciando o Sistema--");
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {

                System.out.print("Digite um número inteiro maior que 1: ");
                int numero = scanner.nextInt();

                List<Integer> primos = p(numero);
                System.out.println("Números primos até " + numero + ": " + primos);

                System.out.print("Deseja testar outro valor? (S/N): ");
                String escolha = scanner.next();

                if (escolha.equalsIgnoreCase("N")) {
                    continuar = false;
                }
            } catch (Exception e) {
                System.out.println("Erro: O valor digitado não é um número inteiro. Tente novamente.");
                scanner.nextLine();
            }
        }

        System.out.println("Encerrando o sistema.");
    }
}
