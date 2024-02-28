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

    public Sensor(){}

    public Sensor(double valor){
        this.pressao = valor;
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
        return "Pressão: " + pressao;
    }

    public Sensor clone() {
        return new Sensor(this.pressao);
    }
}
