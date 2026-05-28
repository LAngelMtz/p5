package com.example.p5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LectorCsv {

    public static ArrayList<Juego> leerArchivo() {
        ArrayList<Juego> listaVideojuegos = new ArrayList<>();
        String linea;
        String rutaInterna = "/com/example/p5/games.csv";
        InputStream is = LectorCsv.class.getResourceAsStream(rutaInterna);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            // Pasar el encabezado
            String encabezado = br.readLine();

            // 2. Leer el resto de las filas línea por línea
            while ((linea = br.readLine()) != null) {

                // Expresión regular para separar por comas ignorando las comas dentro de comillas
                String[] datos = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // La linea cuenta con los 10 campos
                if (datos.length >= 10) {
                    try {
                        int numero = Integer.parseInt(datos[0]);
                        String nombre = datos[1].replace("\"", "").trim();
                        String fechaRaw = datos[2].replace("\"", "").trim();
                        LocalDate fechaLanzamiento;
                        if(!fechaRaw.equalsIgnoreCase("releases on TBD"))
                            fechaLanzamiento = LocalDate.parse(fechaRaw, DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH));
                        else fechaLanzamiento = LocalDate.MAX;
                        String equipo = datos[3].replace("[", "").replace("]", "").replace("\"", "").replace("'", "").trim();
                        int calificacion = (int) (Float.parseFloat(datos[4]) * 10);
                        int cantidadListado = (int) (Float.parseFloat(datos[5].replace("K","")) * 1000);
                        int cantidadReview = (int)  (Float.parseFloat(datos[6].replace("K","")) * 1000);
                        String generos = datos[7].replace("[", "").replace("]", "").replace("\"", "").replace("'", "").trim();
                        String resumen = datos[8].replace("[", "").replace("]", "").replace("\"", "").replace("'", "").trim();
                        String reviews = datos[9].replace("[", "").replace("]", "").replace("\"", "").replace("'", "").trim();


                        //System.out.println(numero + " : " + nombre);

                        // Crear el objeto y añadirlo a la lista
                        listaVideojuegos.add(new Juego(numero, nombre, fechaLanzamiento, equipo, calificacion, cantidadListado, cantidadReview, generos, resumen, reviews));

                    } catch (NumberFormatException e) {
                        // En caso de datos corruptos
                        continue;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaVideojuegos;
    }
}
