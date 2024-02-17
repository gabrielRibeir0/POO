import java.util.Scanner;

public class Exercise4 {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o valor em euros:");
        double valorEur = scanner.nextDouble();

        System.out.println("Insira a taxa de conversão para libras:");
        double taxa = scanner.nextDouble();

        ConversorMoeda conversor = new ConversorMoeda();
        double valorLibras = conversor.eurosParaLibras(valorEur, taxa);

        System.out.println("O valor em libras é:" + valorLibras);
    }
}