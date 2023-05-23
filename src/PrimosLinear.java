import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimosLinear {
    public static List<Integer> p(int n) {
        List<Integer> primos = new ArrayList<>();
        if (n < 2) {
            return primos;
        }

        boolean[] numeros = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            numeros[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (numeros[p]) {
                for (int i = p * p; i <= n; i += p) {
                    numeros[i] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (numeros[i]) {
                primos.add(i);
            }
        }

        return primos;
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