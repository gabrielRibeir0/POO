import java.util.Arrays;
import java.util.Scanner;

public class Aula2 {
    public static void main(String[] args){
        //Ler array
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos elementos deve ter o array?");
        int nPosicoesArray = scanner.nextInt();

        int[] array = new int[nPosicoesArray];

        for(int i = 0; i < array.length; i++){
            System.out.println("Insira um inteiro:");
            array[i] = scanner.nextInt();
        }

        Ficha2 ficha = new Ficha2(array);

        //1 a)
        int min = ficha.minimo();

        System.out.println("O array é " + Arrays.toString(array));
        System.out.println("O mínimo do array é " + min);

        //1 b)
        System.out.println("Insira o primeiro indíce:");
        int menorIndice = scanner.nextInt();
        System.out.println("Insira o segundo indíce:");
        int maiorIndice = scanner.nextInt();

        int[] subArray = ficha.arrayEntreIndices(menorIndice, maiorIndice);
        System.out.println("Array entre os índices " + menorIndice + " e " + maiorIndice + ": " + Arrays.toString(subArray));

        //1 c)
        System.out.println("Quantos elementos deve ter o segundo array?");
        int nPosicoesArray2 = scanner.nextInt();

        int[] array2 = new int[nPosicoesArray2];
        for(int i = 0; i < array2.length; i++){
            System.out.println("Insira um inteiro:");
            array2[i] = scanner.nextInt();
        }

        int[] arrayComum = ficha.arrayElementosComuns(array2);
        System.out.println("O segundo array é " + Arrays.toString(array2));
        System.out.println("O array de elementos comuns é" + Arrays.toString(arrayComum));
    }
}