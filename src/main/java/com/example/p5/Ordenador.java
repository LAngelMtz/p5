package com.example.p5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ordenador {

    public <T extends Comparable<T>> T[] seleccion(T[] array){
        T menor;
        int k;
        int n = array.length;

        for(int i=0;i<n;i++){
            menor = array[i];
            k = i;

            for(int j=i+1;j<n;j++){
                if(array[j].compareTo(menor)<0){
                    menor = array[j];
                    k = j;
                }
            }

            array[k] = array[i];
            array[i] = menor;
        }
        return array;
    }

    public <T> T[] seleccion(T[] array, Comparator<T> comparador){
        T menor;
        int k;
        int n = array.length;

        for(int i=0;i<n;i++){
            menor = array[i];
            k = i;

            for(int j=i+1;j<n;j++){
                if(comparador.compare(array[j], menor) < 0){
                    menor = array[j];
                    k = j;
                }
            }

            array[k] = array[i];
            array[i] = menor;
        }
        return array;
    }

    public <T extends Comparable<T>> T[] shell(T[] array){
        int n = array.length;
        int inter = n+1;
        int band;
        int i;
        T aux;


        while(inter > 1){
            inter = inter/2;
            band = 1;

            while(band == 1){
                band = 0;
                i = 0;

                while((i+inter) < n){
                    if(array[i].compareTo(array[i+inter]) > 0){
                        aux = array[i];
                        array[i] = array[i+inter];
                        array[i+inter] = aux;
                        band = 1;
                    }
                    i++;
                }
            }
        }
        return array;
    }

    public <T> T[] shell(T[] array, Comparator<T> comparador){
        int n = array.length;
        int inter = n+1;
        int band;
        int i;
        T aux;


        while(inter > 1){
            inter = inter/2;
            band = 1;

            while(band == 1){
                band = 0;
                i = 0;

                while((i+inter) < n){
                    if(comparador.compare(array[i],array[i+inter]) > 0){
                        aux = array[i];
                        array[i] = array[i+inter];
                        array[i+inter] = aux;
                        band = 1;
                    }
                    i++;
                }
            }
        }
        return array;
    }

    public <T extends Comparable<T>> void quickSort(T[] array){
        int n = array.length;

        if(n > 1) recursivoQuickSort(array,0,n-1);
    }

    public <T> void quickSort(T[] array, Comparator<T> comparador){
        int n = array.length;

        if(n > 1) recursivoQuickSort(array,0,n-1, comparador);
    }

    private <T extends Comparable<T>> void recursivoQuickSort(T[] array, int ini, int fin){
        int izq = ini;
        int der = fin;
        int pos = ini;
        boolean band = true;

        while(band){
            band = false;
            while(array[pos].compareTo(array[der]) <= 0 && pos != der){der--;} // a[pos] <= a[der]
            if(pos != der){
                T aux = array[pos];
                array[pos] = array[der];
                array[der] = aux;
                pos = der;
                while(array[pos].compareTo(array[izq]) >= 0 && pos != izq){izq++;} // a[pos] >= a[izq]
                if(pos != izq){
                    band = true;
                    aux = array[pos];
                    array[pos] = array[izq];
                    array[izq] = aux;
                    pos = izq;
                }
            }
        }


        if(pos-1 > ini) recursivoQuickSort(array, ini,pos-1);
        if(fin > pos+1) recursivoQuickSort(array, pos+1,fin);
    }

    private <T> void recursivoQuickSort(T[] array, int ini, int fin, Comparator<T> comparador){
        int izq = ini;
        int der = fin;
        int pos = ini;
        boolean band = true;

        while(band){
            band = false;
            while(comparador.compare(array[pos],array[der]) <= 0 && pos != der){der--;} // a[pos] <= a[der]
            if(pos != der){
                T aux = array[pos];
                array[pos] = array[der];
                array[der] = aux;
                pos = der;
                while(comparador.compare(array[pos],array[izq]) >= 0 && pos != izq){izq++;} // a[pos] >= a[izq]
                if(pos != izq){
                    band = true;
                    aux = array[pos];
                    array[pos] = array[izq];
                    array[izq] = aux;
                    pos = izq;
                }
            }
        }


        if(pos-1 > ini) recursivoQuickSort(array, ini,pos-1, comparador);
        if(fin > pos+1) recursivoQuickSort(array, pos+1,fin, comparador);
    }

    public <T extends Comparable<T>> void mergeSort(T[] array){
        int size = array.length;
        if(size > 1){
            int puntoMedio =  size/2;

            T[] izquierda = Arrays.copyOfRange(array,0,puntoMedio);
            T[] derecha =  Arrays.copyOfRange(array,puntoMedio,size);

            mergeSort(izquierda);
            mergeSort(derecha);
            merge(array,izquierda,derecha);
        }
    }

    public <T> void mergeSort(T[] array, Comparator<T> comparador){
        int size = array.length;
        if(size > 1){
            int puntoMedio =  size/2;

            T[] izquierda = Arrays.copyOfRange(array,0,puntoMedio);
            T[] derecha =  Arrays.copyOfRange(array,puntoMedio,size);

            mergeSort(izquierda,comparador);
            mergeSort(derecha,comparador);
            merge(array,izquierda,derecha,comparador);
        }
    }

    private <T extends Comparable<T>> void merge(T[] array, T[] izquierda, T[] derecha){
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i].compareTo(derecha[j]) <= 0){
                array[k] = izquierda[i];
                k++;
                i++;
            }
            else{
                array[k] = derecha[j];
                k++;
                j++;
            }
        }
        while (i < izquierda.length){
            array[k] = izquierda[i];
            k++;
            i++;
        }
        while (j < derecha.length){
            array[k] = derecha[j];
            k++;
            j++;
        }
    }

    private <T> void merge(T[] array, T[] izquierda, T[] derecha, Comparator<T> comparador){
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (comparador.compare(izquierda[i],derecha[j]) <= 0){
                array[k] = izquierda[i];
                k++;
                i++;
            }
            else{
                array[k] = derecha[j];
                k++;
                j++;
            }
        }
        while (i < izquierda.length){
            array[k] = izquierda[i];
            k++;
            i++;
        }
        while (j < derecha.length){
            array[k] = derecha[j];
            k++;
            j++;
        }
    }

    public void radixSort(Integer[] array){
        int size = array.length;
        if(size > 1){
            int max = array[0];

            for(int i = 0; i < size; i++){
                if(array[i] > max) max = array[i];
            }

            int digitos = String.valueOf(max).length();
            int exp = 1;
            int pasada = 1;

            while(pasada <= digitos){

                List<Integer>[] cubetas = new ArrayList[10];
                for(int k = 0; k < cubetas.length; k++){
                    cubetas[k] = new ArrayList<>();
                }

                for(int i = 0; i < size; i++){
                    int digito = (array[i] / exp) % 10;
                    cubetas[digito].add(array[i]);
                }

                int pos = 0;
                for(int j = 0; j < cubetas.length; j++){
                    for(int valor: cubetas[j]){
                        array[pos] = valor;
                        pos = pos + 1;
                    }
                }
                exp *= 10;
                pasada++;
            }
        }
    }

    public <T> void mostrar(T[] a){
        int n = a.length;
        for(int i=0;i<n;i++){
            System.out.println((i+1) + ": " + a[i]);
        }
    }
}
