public class Output {
    public Output(){

    }

    public String escreveOrdemDecrescente(int a, int b, float media){
        String ret;
        if(a > b){
            ret = a + " " + b + " " + media;
        }
        else{
            ret = b + " " + a + " " + media;
        }

        return ret;
    }
}