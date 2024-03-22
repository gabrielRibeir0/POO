import java.time.LocalDateTime;

public class MyLampada {
    private final int OFF = 0;
    private final int ON = 1;
    private final int ECO = 2;

    private final double consumoMaximo = 100;
    private final double consumoEco = consumoMaximo / 2;

    private double consumoAtual;
    private double consumoTotal;
    private int estado;
    private LocalDateTime tempoCriacao;
    private LocalDateTime tempoReset;

    public MyLampada(){
        this.consumoAtual = 0;
        this.estado = OFF;
        LocalDateTime tempo = LocalDateTime.now();
        tempoCriacao = tempo;
        tempoReset = tempo;
        consumoTotal = 0;
    }

    public MyLampada(double consumoTotal, int estado, LocalDateTime tempoCriacao, LocalDateTime tempoReset){
        this.estado = estado;
        if(this.estado == OFF){
            this.consumoAtual = 0;
        }
        else if (this.estado == ON){
            this.consumoAtual = consumoMaximo;
        }
        else{
            this.consumoAtual = consumoEco;
        }
        this.tempoCriacao = tempoCriacao;
        this.tempoReset = tempoReset;
        this.consumoTotal = consumoTotal;
    }

    public MyLampada(MyLampada lampada){
        this.consumoAtual = lampada.consumoAtual;
        this.estado = lampada.estado;
        this.tempoCriacao = lampada.tempoCriacao;
        this.tempoReset = lampada.tempoReset;
        this.consumoTotal = lampada.consumoTotal;
    }

    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        MyLampada lampada = (MyLampada) obj;
        return (this.consumoAtual == lampada.consumoAtual && this.consumoTotal == lampada.consumoTotal && this.estado == lampada.estado && this.tempoCriacao.equals(lampada.tempoCriacao) && this.tempoReset.equals(lampada.tempoReset));
    }

    public String toString(){
        String estadoStr;
        if(this.estado == OFF){
            estadoStr = "OFF";
        }
        else if (this.estado == ON){
            estadoStr = "ON";
        }
        else{
            estadoStr = "ECO";
        }

        return "Consumo: " + consumoAtual + " | Consumo Total: "+ consumoTotal + " | Estado: " + estadoStr + " | Data criação: " + this.tempoCriacao.toString() + " | Data último reset: " + this.tempoReset.toString();
    }

    public MyLampada clone(){
        return new MyLampada(this);
    }

    public void lampON(){
        if(this.estado != OFF){
            atualizarConsumoTotal();
        }
        this.estado = ON;
        this.consumoAtual = consumoMaximo;
        tempoReset = LocalDateTime.now();
    }

    public void lampOFF(){
        if(this.estado != OFF){
            atualizarConsumoTotal();
        }
        this.estado = OFF;
        this.consumoAtual = 0;
        tempoReset = LocalDateTime.now();
    }

    public void lampECO(){
        if(this.estado != OFF){
            atualizarConsumoTotal();
        }
        this.estado = ECO;
        this.consumoAtual = consumoEco;
        tempoReset = LocalDateTime.now();
    }

    public double totalConsumo(){
        if(this.estado == OFF){
            return this.consumoTotal;
        }
        else{
            LocalDateTime tempoAtual = LocalDateTime.now();
            long total_ms = ((long)(tempoAtual.getYear() - this.tempoReset.getYear()) * 1000 * 60 * 60 * 24 * 365 +
                    (long)(tempoAtual.getDayOfYear() - this.tempoReset.getDayOfYear()) * 1000 * 60 * 60 * 24 +
                    (tempoAtual.getHour() - this.tempoReset.getHour()) * 1000 * 60 * 60 +
                    (tempoAtual.getMinute() - this.tempoReset.getMinute()) * 1000 * 60 +
                    (tempoAtual.getSecond() - this.tempoReset.getSecond()) * 1000);

            return consumoAtual * total_ms + consumoTotal;
        }
    }

    private void atualizarConsumoTotal(){
        LocalDateTime tempoAtual = LocalDateTime.now();
        long total_ms = ((long)(tempoAtual.getYear() - this.tempoReset.getYear()) * 1000 * 60 * 60 * 24 * 365 +
                (long)(tempoAtual.getDayOfYear() - this.tempoReset.getDayOfYear()) * 1000 * 60 * 60 * 24 +
                (tempoAtual.getHour() - this.tempoReset.getHour()) * 1000 * 60 * 60 +
                (tempoAtual.getMinute() - this.tempoReset.getMinute()) * 1000 * 60 +
                (tempoAtual.getSecond() - this.tempoReset.getSecond()) * 1000);

        this.consumoTotal += consumoAtual * total_ms;
    }

    public double periodoConsumo(){
        if(this.estado == OFF){
            return 0;
        }
        else{
            LocalDateTime tempoAtual = LocalDateTime.now();
            long total_ms = ((long)(tempoAtual.getYear() - this.tempoReset.getYear()) * 1000 * 60 * 60 * 24 * 365 +
                    (long)(tempoAtual.getDayOfYear() - this.tempoReset.getDayOfYear()) * 1000 * 60 * 60 * 24 +
                    (tempoAtual.getHour() - this.tempoReset.getHour()) * 1000 * 60 * 60 +
                    (tempoAtual.getMinute() - this.tempoReset.getMinute()) * 1000 * 60 +
                    (tempoAtual.getSecond() - this.tempoReset.getSecond()) * 1000);

            return consumoAtual * total_ms;
        }
    }
}