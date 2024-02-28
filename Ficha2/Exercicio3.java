import java.util.Arrays;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos elementos deve ter o array?");
        int nPosicoesArray = scanner.nextInt();

        int[] array = new int[nPosicoesArray];

        for(int i = 0; i < array.length; i++){
            System.out.println("Insira um inteiro:");
            array[i] = scanner.nextInt();
        }

        Ficha2 ficha = new Ficha2(array);

        int[] arrayOrdenado = ficha.ordenaArrayCrescente();
        System.out.println("Array ordenado por ordem crescente: " + Arrays.toString(arrayOrdenado));

        System.out.println("Insira o elemento a procurar no array:");
        int elemento = scanner.nextInt();
        int indice = ficha.pesquisaBinariaArray(elemento);
        if(indice == -1) {
            System.out.println("O elemento " + elemento + " não foi encontrado no array.");
        }
        else {
            System.out.println("O elemento " + elemento + " está na posição " + indice);
        }
    }
}
