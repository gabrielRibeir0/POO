import java.util.Date;

public class Exercise7{
    public static void main(String []args){
        Fatorial fatorial = new Fatorial();
        Date data_inicio = new Date();
        long fat = fatorial.fatorial(5000);
        Date data_fim = new Date();

        Cronometro cronometro = new Cronometro();
        long ms = cronometro.tempoGasto(data_inicio, data_fim);

        System.out.println("Tempo gasto: " + ms + " ms");
    }
}