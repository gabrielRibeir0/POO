public class Circulo {
    private Ponto centro;
    private double raio;

    public Circulo(){
        this.centro = new Ponto();
        this.raio = 0;
    }

    public Circulo(int x, int y, double raio){
        this.centro = new Ponto(x, y);
        this.raio = raio;
    }

    public Circulo(Circulo circulo){
        this.centro = new Ponto(circulo.centro);
        this.raio = circulo.raio;
    }

    public Ponto getCentro(){
        return this.centro.clone();
    }

    public double getRaio(){
        return this.raio;
    }

    public void setCentro(Ponto ponto){
        this.centro = new Ponto(ponto);
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public void alteraCentro(int x, int y){
        this.centro.setX(x);
        this.centro.setY(y);
    }

    public double calculaArea(){
        return Math.PI * Math.pow(this.raio, 2);
    }

    public double calculaPerimetro(){
        return 2 * Math.PI * this.raio;
    }

    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        Circulo circulo = (Circulo) obj;
        return (this.centro.equals(circulo.centro) && circulo.raio == this.raio);
    }

    public String toString(){
        return this.centro.toString() + " | Raio: " + this.raio;
    }

    public Circulo clone(){
        return new Circulo(this);
    }
}
