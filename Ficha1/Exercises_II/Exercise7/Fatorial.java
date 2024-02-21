public class Fatorial{
    public Fatorial(){

    }

    public long fatorial(int num){
        long res = 1;
        while(num > 1){
            res *= num;
            num--;
        }

        return res;
    }
}