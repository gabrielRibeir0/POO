public class Circulo {
    private double x;
    private double y;
    private double raio;

    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    public Circulo(double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo(Circulo circulo){
        this.x = circulo.x;
        this.y = circulo.y;
        this.raio = circulo.raio;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRaio(){
        return this.raio;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public void alteraCentro(double x, double y){
        this.x = x;
        this.y = y;
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
        return (circulo.x == this.x && circulo.y == this.y && circulo.raio == this.raio);
    }

    public String toString(){
        return "X: " + this.x + " | Y: " + this.y + " | Raio: " + this.raio;
    }

    public Circulo clone(){
        return new Circulo(this);
    }
}
