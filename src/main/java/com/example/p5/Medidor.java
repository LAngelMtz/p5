package com.example.p5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Medidor {
    private Ordenador ordenador;
    private boolean[] calcularPermisos; // 0 = quick, 1 = mergesort, 2 = shell, 3 = seleccion, 4 = radix, 5 = sort, 6 = parallel
    private ArrayList<Double>[] tiemposMili;
    private ArrayList<Juego> juegos;

    public Medidor(){
        ordenador = new Ordenador();
        calcularPermisos = new boolean[7];
        tiemposMili = new ArrayList[9];
        juegos = LectorCsv.leerArchivo();
        for(int i = 0; i < calcularPermisos.length; i++) calcularPermisos[i] = true;
    }

    public ArrayList<Double> ordenarTitulo(){
        long inicio;
        long fin;
        long duracion;
        ArrayList<Long> tiemposNano = new ArrayList<>();
        ArrayList<Double> tiemposMilis = new ArrayList<>();
        String[] titulos = new String[juegos.size()];
        for(int i = 0; i < titulos.length; i++) titulos[i] = juegos.get(i).getTitulo();

        if(calcularPermisos[0]){
            inicio = System.nanoTime();
            ordenador.quickSort(titulos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[1]){
            inicio = System.nanoTime();
            ordenador.mergeSort(titulos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[2]){
            inicio = System.nanoTime();
            ordenador.shell(titulos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[3]){
            inicio = System.nanoTime();
            ordenador.seleccion(titulos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[4]){
            inicio = System.nanoTime();
            ordenador.radixSortStrings(titulos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[5]){
            inicio = System.nanoTime();
            Arrays.sort(titulos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[6]){
            inicio = System.nanoTime();
            Arrays.parallelSort(titulos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }

        tiemposNano.forEach(System.out::println);
        tiemposMilis.forEach(System.out::println);
        tiemposMili[0] = tiemposMilis;

        return tiemposMilis;
    }

    public ArrayList<Double> ordenarFecha(){
        long inicio;
        long fin;
        long duracion;
        ArrayList<Long> tiemposNano = new ArrayList<>();
        ArrayList<Double> tiemposMilis = new ArrayList<>();
        LocalDate[] fechas = new LocalDate[juegos.size()];
        for(int i = 0; i < fechas.length; i++) fechas[i] = juegos.get(i).getFechaLanzamiento();

        if(calcularPermisos[0]){
            inicio = System.nanoTime();
            ordenador.quickSort(fechas.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[1]){
            inicio = System.nanoTime();
            ordenador.mergeSort(fechas.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[2]){
            inicio = System.nanoTime();
            ordenador.shell(fechas.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[3]){
            inicio = System.nanoTime();
            ordenador.seleccion(fechas.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }

        if(calcularPermisos[5]){
            inicio = System.nanoTime();
            Arrays.sort(fechas.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[6]){
            inicio = System.nanoTime();
            Arrays.parallelSort(fechas.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }

        tiemposNano.forEach(System.out::println);
        tiemposMilis.forEach(System.out::println);
        tiemposMili[1] = tiemposMilis;

        return tiemposMilis;
    }

    public ArrayList<Double> ordenarEquipo(){
        long inicio;
        long fin;
        long duracion;
        ArrayList<Long> tiemposNano = new ArrayList<>();
        ArrayList<Double> tiemposMilis = new ArrayList<>();
        String[] equipos = new String[juegos.size()];
        for(int i = 0; i < equipos.length; i++) equipos[i] = juegos.get(i).getEquipo();

        if(calcularPermisos[0]){
            inicio = System.nanoTime();
            ordenador.quickSort(equipos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[1]){
            inicio = System.nanoTime();
            ordenador.mergeSort(equipos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[2]){
            inicio = System.nanoTime();
            ordenador.shell(equipos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[3]){
            inicio = System.nanoTime();
            ordenador.seleccion(equipos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[4]){
            inicio = System.nanoTime();
            ordenador.radixSortStrings(equipos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[5]){
            inicio = System.nanoTime();
            Arrays.sort(equipos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[6]){
            inicio = System.nanoTime();
            Arrays.parallelSort(equipos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }

        tiemposNano.forEach(System.out::println);
        tiemposMilis.forEach(System.out::println);
        tiemposMili[2] = tiemposMilis;

        return tiemposMilis;
    }

    public ArrayList<Double> ordenarCalificacion(){
        long inicio;
        long fin;
        long duracion;
        ArrayList<Long> tiemposNano = new ArrayList<>();
        ArrayList<Double> tiemposMilis = new ArrayList<>();
        Integer[] calificaciones = new Integer[juegos.size()];
        for(int i = 0; i < calificaciones.length; i++) calificaciones[i] = juegos.get(i).getCalificacion();

        if(calcularPermisos[0]){
            inicio = System.nanoTime();
            ordenador.quickSort(calificaciones.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[1]){
            inicio = System.nanoTime();
            ordenador.mergeSort(calificaciones.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[2]){
            inicio = System.nanoTime();
            ordenador.shell(calificaciones.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[3]){
            inicio = System.nanoTime();
            ordenador.seleccion(calificaciones.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[4]){
            inicio = System.nanoTime();
            ordenador.radixSort(calificaciones.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[5]){
            inicio = System.nanoTime();
            Arrays.sort(calificaciones.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[6]){
            inicio = System.nanoTime();
            Arrays.parallelSort(calificaciones.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }

        tiemposNano.forEach(System.out::println);
        tiemposMilis.forEach(System.out::println);
        tiemposMili[3] = tiemposMilis;

        return tiemposMilis;
    }

    public ArrayList<Double> ordenarCantidadListado(){
        long inicio;
        long fin;
        long duracion;
        ArrayList<Long> tiemposNano = new ArrayList<>();
        ArrayList<Double> tiemposMilis = new ArrayList<>();
        Integer[] cantidadesListado = new Integer[juegos.size()];
        for(int i = 0; i < cantidadesListado.length; i++) cantidadesListado[i] = juegos.get(i).getCantidadListado();

        if(calcularPermisos[0]){
            inicio = System.nanoTime();
            ordenador.quickSort(cantidadesListado.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[1]){
            inicio = System.nanoTime();
            ordenador.mergeSort(cantidadesListado.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[2]){
            inicio = System.nanoTime();
            ordenador.shell(cantidadesListado.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[3]){
            inicio = System.nanoTime();
            ordenador.seleccion(cantidadesListado.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[4]){
            inicio = System.nanoTime();
            ordenador.radixSort(cantidadesListado.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[5]){
            inicio = System.nanoTime();
            Arrays.sort(cantidadesListado.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[6]){
            inicio = System.nanoTime();
            Arrays.parallelSort(cantidadesListado.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }

        tiemposNano.forEach(System.out::println);
        tiemposMilis.forEach(System.out::println);
        tiemposMili[4] = tiemposMilis;

        return tiemposMilis;
    }

    public ArrayList<Double> ordenarCantidadReview(){
        long inicio;
        long fin;
        long duracion;
        ArrayList<Long> tiemposNano = new ArrayList<>();
        ArrayList<Double> tiemposMilis = new ArrayList<>();
        Integer[] cantidadesReview = new Integer[juegos.size()];
        for(int i = 0; i < cantidadesReview.length; i++) cantidadesReview[i] = juegos.get(i).getCantidadReview();

        if(calcularPermisos[0]){
            inicio = System.nanoTime();
            ordenador.quickSort(cantidadesReview.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[1]){
            inicio = System.nanoTime();
            ordenador.mergeSort(cantidadesReview.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[2]){
            inicio = System.nanoTime();
            ordenador.shell(cantidadesReview.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[3]){
            inicio = System.nanoTime();
            ordenador.seleccion(cantidadesReview.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[4]){
            inicio = System.nanoTime();
            ordenador.radixSort(cantidadesReview.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[5]){
            inicio = System.nanoTime();
            Arrays.sort(cantidadesReview.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[6]){
            inicio = System.nanoTime();
            Arrays.parallelSort(cantidadesReview.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }

        tiemposNano.forEach(System.out::println);
        tiemposMilis.forEach(System.out::println);
        tiemposMili[5] = tiemposMilis;

        return tiemposMilis;
    }

    public ArrayList<Double> ordenarGenero(){
        long inicio;
        long fin;
        long duracion;
        ArrayList<Long> tiemposNano = new ArrayList<>();
        ArrayList<Double> tiemposMilis = new ArrayList<>();
        String[] generos = new String[juegos.size()];
        for(int i = 0; i < generos.length; i++) generos[i] = juegos.get(i).getGeneros();

        if(calcularPermisos[0]){
            inicio = System.nanoTime();
            ordenador.quickSort(generos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[1]){
            inicio = System.nanoTime();
            ordenador.mergeSort(generos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[2]){
            inicio = System.nanoTime();
            ordenador.shell(generos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[3]){
            inicio = System.nanoTime();
            ordenador.seleccion(generos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[4]){
            inicio = System.nanoTime();
            ordenador.radixSortStrings(generos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[5]){
            inicio = System.nanoTime();
            Arrays.sort(generos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[6]){
            inicio = System.nanoTime();
            Arrays.parallelSort(generos.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }

        tiemposNano.forEach(System.out::println);
        tiemposMilis.forEach(System.out::println);
        tiemposMili[6] = tiemposMilis;

        return tiemposMilis;
    }

    public ArrayList<Double> ordenarResumen(){
        long inicio;
        long fin;
        long duracion;
        ArrayList<Long> tiemposNano = new ArrayList<>();
        ArrayList<Double> tiemposMilis = new ArrayList<>();
        String[] resumenes = new String[juegos.size()];
        for(int i = 0; i < resumenes.length; i++) resumenes[i] = juegos.get(i).getResumen();

        if(calcularPermisos[0]){
            inicio = System.nanoTime();
            ordenador.quickSort(resumenes.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[1]){
            inicio = System.nanoTime();
            ordenador.mergeSort(resumenes.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[2]){
            inicio = System.nanoTime();
            ordenador.shell(resumenes.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[3]){
            inicio = System.nanoTime();
            ordenador.seleccion(resumenes.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[4]){
            inicio = System.nanoTime();
            ordenador.radixSortStrings(resumenes.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[5]){
            inicio = System.nanoTime();
            Arrays.sort(resumenes.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[6]){
            inicio = System.nanoTime();
            Arrays.parallelSort(resumenes.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }

        tiemposNano.forEach(System.out::println);
        tiemposMilis.forEach(System.out::println);
        tiemposMili[7] = tiemposMilis;

        return tiemposMilis;
    }

    public ArrayList<Double> ordenarReview(){
        long inicio;
        long fin;
        long duracion;
        ArrayList<Long> tiemposNano = new ArrayList<>();
        ArrayList<Double> tiemposMilis = new ArrayList<>();
        String[] reviews = new String[juegos.size()];
        for(int i = 0; i < reviews.length; i++) reviews[i] = juegos.get(i).getReviews();

        if(calcularPermisos[0]){
            inicio = System.nanoTime();
            ordenador.quickSort(reviews.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[1]){
            inicio = System.nanoTime();
            ordenador.mergeSort(reviews.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[2]){
            inicio = System.nanoTime();
            ordenador.shell(reviews.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[3]){
            inicio = System.nanoTime();
            ordenador.seleccion(reviews.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[4]){
            inicio = System.nanoTime();
            ordenador.radixSortStrings(reviews.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[5]){
            inicio = System.nanoTime();
            Arrays.sort(reviews.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }
        if(calcularPermisos[6]){
            inicio = System.nanoTime();
            Arrays.parallelSort(reviews.clone());
            fin = System.nanoTime();
            duracion = fin - inicio;
            tiemposNano.add(duracion);
            tiemposMilis.add(duracion / 1000000.0);
        }else{
            tiemposNano.add((long) -1);
            tiemposMilis.add(-1.0);
        }

        tiemposNano.forEach(System.out::println);
        tiemposMilis.forEach(System.out::println);
        tiemposMili[8] = tiemposMilis;

        return tiemposMilis;
    }

    public ArrayList<Juego> getJuegos(){
        return juegos;
    }

    public void setPermisos(boolean b, int indice){
        if(!(indice > calcularPermisos.length-1) && indice >= 0){
            calcularPermisos[indice] = b;
        }
    }

    public boolean getPermiso(int indice){
        if(!(indice > calcularPermisos.length-1) && indice >= 0){
            return calcularPermisos[indice];
        }
        return false;
    }


}
