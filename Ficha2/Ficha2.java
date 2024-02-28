import java.time.LocalDate;
import java.util.Arrays;

public class Ficha2 {
    //Ex 1
    private int[] arrayInterno;

    public Ficha2(int[] array){
        this.arrayInterno = array;
    }

    public int minimo(){
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < this.arrayInterno.length; i++){
            if(this.arrayInterno[i] < min){
                min = this.arrayInterno[i];
            }
        }

        return min;
    }

    public int[] arrayEntreIndices(int menorIndice, int maiorIndice){
        int[] arr;
        if(menorIndice < 0 || maiorIndice >= this.arrayInterno.length || menorIndice > maiorIndice){
            arr = new int[0];
        }
        else{
            arr = new int[maiorIndice - menorIndice + 1];
            for(int i = menorIndice; i <= maiorIndice; i++){
                arr[i - menorIndice] = this.arrayInterno[i];
            }
        }

        return arr;
    }

    public int[] arrayElementosComuns(int[] array2){
        int arraySize = Math.max(this.arrayInterno.length, array2.length);

        int[] tempArr = new int[arraySize];
        int elementosComuns = 0;

        for(int i = 0; i < array2.length; i++){
            for(int j = 0; j < this.arrayInterno.length; j++){
                if(array2[i] == this.arrayInterno[j]){
                    tempArr[elementosComuns] = array2[i];
                    elementosComuns++;
                    break;
                }
            }
        }

        int[] arr;
        if(elementosComuns == arraySize){
            arr = tempArr;
        }
        else{
            arr = new int[elementosComuns];
            for(int i = 0; i < elementosComuns; i++){
                arr[i] = tempArr[i];
            }
        }

        return arr;
    }

    //Ex 2
    private LocalDate[] arrayLocalDate;
    private int nDatasInseridas;

    public Ficha2(int capacidade){
        nDatasInseridas = 0;
        arrayLocalDate = new LocalDate[capacidade];
    }

    public int insereData(LocalDate data){
        //inserir ordenadamente?
        if(nDatasInseridas >= this.arrayLocalDate.length) {
            this.arrayLocalDate = Arrays.copyOf(this.arrayLocalDate, this.arrayLocalDate.length * 2);
        }

        arrayLocalDate[nDatasInseridas] = data;
        nDatasInseridas++;
        return nDatasInseridas - 1;
    }

    public LocalDate dataMaisProxima(LocalDate data){
        LocalDate dataMaisProxima = this.arrayLocalDate[0];
        long menorDiferenca = Math.abs(data.toEpochDay() - arrayLocalDate[0].toEpochDay());

        //mudar se inserir ordenadamente
        for (int i = 1; i < this.arrayLocalDate.length; i++) {
            long diferenca = Math.abs(data.toEpochDay() - this.arrayLocalDate[i].toEpochDay());
            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                dataMaisProxima = this.arrayLocalDate[i];
            }
        }

        return dataMaisProxima;
    }

    public String toString(){
        String str = "", dataStr;
        if(nDatasInseridas > 0 ){
            str = arrayLocalDate[0].toString();
            for(int i = 1; i < nDatasInseridas; i++) {
                dataStr = arrayLocalDate[i].toString();
                str += " | " + dataStr;
            }
        }

        return str;
    }

    //Ex 3
    public int[] ordenaArrayCrescente(){
        for (int i = 0; i < this.arrayInterno.length; i++) {
            for (int j = i + 1; j < this.arrayInterno.length; j++) {
                int tmp;
                if (this.arrayInterno[i] > this.arrayInterno[j]) {
                    tmp = this.arrayInterno[i];
                    this.arrayInterno[i] = this.arrayInterno[j];
                    this.arrayInterno[j] = tmp;
                }
            }
        }

        return this.arrayInterno;
    }

    public int pesquisaBinariaArray(int x){
        int first = 0;
        int last = this.arrayInterno.length - 1;
        int middle = (first + last) / 2;

        while (first <= last) {
            if (this.arrayInterno[middle] < x) {
                first = middle + 1;
            }
            else if (this.arrayInterno[middle] == x) {
                return middle;
            }
            else {
                last = middle - 1;
            }

            middle = (first + last) / 2;
        }

        return -1;
    }
}