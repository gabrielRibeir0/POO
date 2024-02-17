import java.util.Scanner;

public class Exercise1 {
    public static void main(String []args){
        System.out.println("Insira uma temperatura em graus celsius:");

        Scanner scanner = new Scanner(System.in);

        double tempC = scanner.nextDouble();
        Conversor converter = new Conversor();
        
        double ret = converter.celsiusParaFarenheit(tempC);
        System.out.println(ret);
    }
}