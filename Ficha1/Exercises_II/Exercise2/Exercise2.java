import java.util.Scanner;

public class Exercise2 {
    public static void main(String []args){
        System.out.println("Insira o primeiro número:");
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();

        System.out.println("Insira o segundo número:");
        int n2 = scanner.nextInt();

        Comparador comparar = new Comparador();
        int maior = comparar.maximoNumeros(n1, n2);

        System.out.println("O maior número é " + maior);
    }
}