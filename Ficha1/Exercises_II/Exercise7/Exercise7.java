import java.time.LocalTime;

public class Exercise7{
    public static void main(String []args){
        Fatorial fatorial = new Fatorial();
        LocalTime tempo_inicio = LocalTime.now();
        long fat = fatorial.fatorial(5000);
        LocalTime tempo_fim = LocalTime.now();

        Cronometro cronometro = new Cronometro();
        long ms = cronometro.tempoGasto(tempo_inicio, tempo_fim);

        System.out.println("Tempo gasto: " + ms + " ms");
    }
}