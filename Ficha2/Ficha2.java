public class Ficha2 {
    int[] arrayInterno;
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
}