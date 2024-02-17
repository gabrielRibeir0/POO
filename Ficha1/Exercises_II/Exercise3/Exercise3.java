import java.util.Scanner;

public class Exercise3 {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o nome:");
        String nome = scanner.next();

        System.out.println("Insira o saldo:");
        double saldo = scanner.nextDouble();

        Conta output = new Conta();
        String outputString = output.criaDescricaoConta(nome, saldo);

        System.out.println(outputString);
    }
}