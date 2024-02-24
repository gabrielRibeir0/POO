import java.time.LocalTime;

public class Cronometro {
    public Cronometro(){

    }

    public long tempoGasto(LocalTime data_inicio, LocalTime data_fim){
        int nano_inicio = data_inicio.getNano();
        int nano_fim = data_fim.getNano();
        long ms = (nano_fim - nano_inicio) / 1000000;
        return ms;
    }
}