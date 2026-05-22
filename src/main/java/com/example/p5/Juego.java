package com.example.p5;

import java.time.LocalDate;

public class Juego {
    private String titulo;
    private LocalDate fechaLanzamiento;
    private String equipo;
    private int calificacion;
    private int cantidadListado;
    private int cantidadReview;
    private String generos;
    private String resumen;
    private String reviews;

    public Juego(String titulo, LocalDate fechaLanzamiento, String equipo, int calificacion,
                 int cantidadListado, int cantidadReview, String generos, String resumen, String reviews){
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.equipo = equipo;
        this.calificacion = calificacion;
        this.cantidadListado = cantidadListado;
        this.cantidadReview = cantidadReview;
        this.generos = generos;
        this.resumen = resumen;
        this.reviews = reviews;
    }

    public String getTitulo() {return titulo;}
    public LocalDate getFechaLanzamiento() {return fechaLanzamiento;}
    public String getEquipo() {return equipo;}
    public int getCalificacion() {return calificacion;}
    public int getCantidadListado() {return cantidadListado;}
    public int getCantidadReview() {return cantidadReview;}
    public String getGeneros() {return generos;}
    public String getResumen() {return resumen;}
    public String getReviews() {return reviews;}
}
