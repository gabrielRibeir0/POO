import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual a capacidade do array das datas?");
        int capacidadeArrayDatas = scanner.nextInt();
        Ficha2 ficha = new Ficha2(capacidadeArrayDatas);

        int ano = 0, mes = 0, dia = 0;
        LocalDate data;
        int escolha = 1, dataValida = 0;
        while(escolha != 0){
            System.out.println("Escolha uma opção:");
            System.out.println("    1 - Inserir uma data no array");
            System.out.println("    2 - Procurar a data mais próxima no array");
            System.out.println("    3 - Listar as datas no array");
            System.out.println("    0 - Sair do programa");
            escolha = scanner.nextInt();
            if(escolha == 1){
                while(dataValida == 0) {
                    System.out.println("Insira o ano da data:");
                    ano = scanner.nextInt();
                    System.out.println("Insira o mês da data:");
                    mes = scanner.nextInt();
                    System.out.println("Insira o dia da data:");
                    dia = scanner.nextInt();

                    if(!(mes < 1 || mes > 12 || dia < 0 || dia > 31)){
                        dataValida = 1;
                    }
                }
                dataValida = 0;

                data = LocalDate.of(ano, mes, dia);
                int posicao = ficha.insereData(data);
                System.out.println(data.toString() + " inserida na posição " + posicao);
            }
            else if (escolha == 2) {
                while(dataValida == 0) {
                    System.out.println("Insira o ano da data:");
                    ano = scanner.nextInt();
                    System.out.println("Insira o mês da data:");
                    mes = scanner.nextInt();
                    System.out.println("Insira o dia da data:");
                    dia = scanner.nextInt();

                    if (!(mes < 1 || mes > 12 || dia < 0 || dia > 31)) {
                        dataValida = 1;
                    }
                }
                dataValida = 0;

                data = LocalDate.of(ano, mes, dia);
                LocalDate dataMaisProxima = ficha.dataMaisProxima(data);
                System.out.println("A data mais próxima de " + data.toString() + " é " + dataMaisProxima.toString());
            }
            else if (escolha == 3) {
                String str = ficha.toString();
                System.out.println(str);
            }
        }
    }
}