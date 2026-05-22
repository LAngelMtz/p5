package com.example.p5;

import javafx.application.Application;

import java.util.ArrayList;

public class Launcher {
    public static void main(String[] args) {
        Medidor medidor = new Medidor();
        //medidor.ordenarTitulo();
        //medidor.ordenarFecha();
        //medidor.ordenarEquipo();
        //medidor.ordenarCalificacion();
        //medidor.ordenarCantidadListado();
        //medidor.ordenarCantidadReview();
        //medidor.ordenarGenero();
        //medidor.ordenarResumen();
        medidor.ordenarReview();
        Application.launch(HelloApplication.class, args);

    }
}
