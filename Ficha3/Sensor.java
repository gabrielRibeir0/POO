public class Sensor {
    private double pressao;

    public double getPressao() {
        return this.pressao;
    }

    public boolean setPressao(double pressao) {
        if(pressao >= 0) {
            this.pressao = pressao;
            return true;
        }

        return false;
    }

    public Sensor(){
        this.pressao = 0;
    }

    public Sensor(double valor){
        this.pressao = valor;
    }

    public Sensor(Sensor sensor){
        this.pressao = sensor.pressao;
    }

    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        Sensor sensor = (Sensor) obj;
        return sensor.pressao == this.pressao;
    }

    public String toString(){
        return "Pressão: " + this.pressao;
    }

    public Sensor clone() {
        return new Sensor(this.pressao);
    }
}
