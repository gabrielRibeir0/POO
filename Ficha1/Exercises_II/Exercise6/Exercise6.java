import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);

        Fatorial fatorial = new Fatorial();
        long fat = fatorial.fatorial(num);

        System.out.println("O fatorial de " + num + " é " + fat);
    }
}