import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o primeiro número:");
        int a = scanner.nextInt();

        System.out.println("Insira o segundo número:");
        int b = scanner.nextInt();

        Calculador calcular = new Calculador();
        float media = calcular.calculaMedia(a, b);

        String linha;
        Output output = new Output();
        linha = output.escreveOrdemDecrescente(a, b, media);

        System.out.println(linha);
    }
}