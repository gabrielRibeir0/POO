import java.util.Date;

public class Cronometro {
    public Cronometro(){

    }

    public long tempoGasto(Date data_inicio, Date data_fim){
        long ms_inicio = data_inicio.getTime();
        long ms_fim = data_fim.getTime();
        return ms_fim - ms_inicio;
    }
}