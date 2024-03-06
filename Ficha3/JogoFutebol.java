public class JogoFutebol {
    private final int porIniciar = 0;
    private final int aDecorrer = 1;
    private final int terminado = 2;

    private int estado;
    private int golosCasa;
    private int golosVisitante;

    public JogoFutebol(){
        this.estado = porIniciar;
        this.golosCasa = 0;
        this.golosVisitante = 0;
    }

    public JogoFutebol(int estado, int golosCasa, int golosVisitante){
        this.estado = estado;
        this.golosCasa = golosCasa;
        this.golosVisitante = golosVisitante;
    }

    public JogoFutebol(JogoFutebol jogo){
        this.estado = jogo.estado;
        this.golosCasa = jogo.golosCasa;
        this.golosVisitante = jogo.golosVisitante;
    }

    public int getEstado() {
        return estado;
    }

    public int getGolosCasa() {
        return golosCasa;
    }

    public int getGolosVisitante() {
        return golosVisitante;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public void setGolosVisitante(int golosVisitante) {
        this.golosVisitante = golosVisitante;
    }

    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        JogoFutebol jogo = (JogoFutebol) obj;
        return (this.estado == jogo.estado && this.golosCasa == jogo.golosCasa && this.golosVisitante == jogo.golosVisitante);
    }

    public String toString(){
        String estadoStr;
        if(this.estado == porIniciar){
            estadoStr = "Por Iniciar";
        }
        else if (this.estado == aDecorrer){
            estadoStr = "A Decorrer";
        }
        else{
            estadoStr = "Terminado";
        }

        return "Estado: " + estadoStr + " | Golos Equipa Casa: " + golosCasa + " | Golos Equipa Visitante" + golosVisitante;
    }

    public JogoFutebol clone(){
        return new JogoFutebol(this);
    }

    public void startGame(){
        if(this.estado == porIniciar){
            this.estado = aDecorrer;
        }
    }

    public void endGame(){
        if(this.estado == aDecorrer){
            this.estado = terminado;
        }
    }

    public void goloVisitado(){
        if(this.estado == aDecorrer){
            this.golosCasa++;
        }
    }

    public void goloVisitante(){
        if(this.estado == aDecorrer){
            this.golosVisitante++;
        }
    }

    public String resultadoActual(){
        if(this.estado != porIniciar) {
            return golosCasa + " - " + golosVisitante;
        }

        return "Jogo não iniciado";
    }
}
