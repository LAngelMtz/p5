package com.example.p5;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.time.LocalDate;
import java.util.ArrayList;

public class HelloController {
    Medidor medidor;

    @FXML
    private GridPane gridComparacion;

    @FXML
    private Button botonComparacion;

    @FXML
    private Button botonDatos;

    @FXML
    private Button botonNose;

    @FXML
    private Button botonOrdenar;

    @FXML
    private TableView<Juego> tablaDatos;

    @FXML
    private CheckBox checkCalificacion;

    @FXML
    private CheckBox checkEquipo;

    @FXML
    private CheckBox checkFecha;

    @FXML
    private CheckBox checkGeneros;

    @FXML
    private CheckBox checkMerge;

    @FXML
    private CheckBox checkNumListado;

    @FXML
    private CheckBox checkNumReviews;

    @FXML
    private CheckBox checkParallel;

    @FXML
    private CheckBox checkQuick;

    @FXML
    private CheckBox checkRadix;

    @FXML
    private CheckBox checkResumen;

    @FXML
    private CheckBox checkReviews;

    @FXML
    private CheckBox checkSeleccion;

    @FXML
    private CheckBox checkShell;

    @FXML
    private CheckBox checkSort;

    @FXML
    private CheckBox checkTitulo;

    @FXML
    private TableColumn<Juego, Integer> colNumero;
    @FXML
    private TableColumn<Juego, String> colTitulo;
    @FXML
    private TableColumn<Juego, LocalDate> colFecha;
    @FXML
    private TableColumn<Juego, String> colEquipo;
    @FXML
    private TableColumn<Juego, Integer> colCalificacion;
    @FXML
    private TableColumn<Juego, Integer> colCantidadListado;
    @FXML
    private TableColumn<Juego, Integer> colCantidadReview;
    @FXML
    private TableColumn<Juego, String> colGeneros;
    @FXML
    private TableColumn<Juego, String> colResumen;
    @FXML
    private TableColumn<Juego, String> colReviews;


    @FXML
    public void initialize(){
        medidor = new Medidor();

        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaLanzamiento"));
        colEquipo.setCellValueFactory(new PropertyValueFactory<>("equipo"));
        colCalificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));
        colCantidadListado.setCellValueFactory(new PropertyValueFactory<>("cantidadListado"));
        colCantidadReview.setCellValueFactory(new PropertyValueFactory<>("cantidadReview"));
        colGeneros.setCellValueFactory(new PropertyValueFactory<>("generos"));
        colResumen.setCellValueFactory(new PropertyValueFactory<>("resumen"));
        colReviews.setCellValueFactory(new PropertyValueFactory<>("reviews"));

        tablaDatos.getItems().setAll(medidor.getJuegos());
    }

    public void crearGrafica(String titulo, ArrayList<Double> tiemposMilis, boolean radix){


        CategoryAxis ejeX = new CategoryAxis();
        ejeX.setLabel("Algoritmos");

        NumberAxis ejeY = new NumberAxis();
        ejeY.setLabel("Tiempo (ms)");

        // Instanciar el BarChart pasándole los ejes
        BarChart<String, Number> grafica = new BarChart<>(ejeX, ejeY);
        grafica.setTitle("Comparación de algoritmos con: "+ titulo);
        grafica.setAnimated(false);

        System.out.println("Columnas "+ gridComparacion.getColumnCount());
        System.out.println("filas "+ gridComparacion.getRowCount());
        System.out.println("Size " + gridComparacion.getChildren().size());

        int x = gridComparacion.getChildren().size()/3;
        int y =  gridComparacion.getChildren().size()%3;

        gridComparacion.add(grafica,x,y);


        XYChart.Series<String, Number> serie = new XYChart.Series<>();
        serie.setName("Milisegundos");

        String[] nombresAlgoritmos;

        if(radix) nombresAlgoritmos = new String[]{
                "QuickSort", "MergeSort", "ShellSort", "Sel Directa", "RadixSort", "Sort", "ParallelSort"
        };
        else nombresAlgoritmos = new String[]{
                "QuickSort", "MergeSort", "ShellSort", "Sel Directa", "Sort", "ParallelSort"
        };

        System.out.println(tiemposMilis.size());

        for (int i = 0; i < tiemposMilis.size(); i++) {
            System.out.println(medidor.getPermiso(i) +" | "+  tiemposMilis.get(i));
            if (tiemposMilis.get(i) >= 0) {
                serie.getData().add(new XYChart.Data<>(nombresAlgoritmos[i], tiemposMilis.get(i)));
            }
        }


        grafica.getData().add(serie);
    }

    public boolean[] obtenerChecksColumnas(){
        boolean[] checksColumnas = new boolean[9];
        checksColumnas[0] = checkTitulo.isSelected();
        checksColumnas[1] = checkFecha.isSelected();
        checksColumnas[2] = checkEquipo.isSelected();
        checksColumnas[3] = checkCalificacion.isSelected();
        checksColumnas[4] = checkNumListado.isSelected();
        checksColumnas[5] = checkNumReviews.isSelected();
        checksColumnas[6] = checkGeneros.isSelected();
        checksColumnas[7] = checkResumen.isSelected();
        checksColumnas[8] = checkReviews.isSelected();
        return checksColumnas;
    }

    public void actualizarPermisosAlgoritmos(){
        medidor.setPermisos(checkQuick.isSelected(), 0);
        medidor.setPermisos(checkMerge.isSelected(), 1);
        medidor.setPermisos(checkShell.isSelected(), 2);
        medidor.setPermisos(checkSeleccion.isSelected(), 3);
        medidor.setPermisos(checkRadix.isSelected(), 4);
        medidor.setPermisos(checkSort.isSelected(), 5);
        medidor.setPermisos(checkParallel.isSelected(), 6);
    }

    @FXML
    void actualizarCampo(MouseEvent event) {
        if(botonComparacion.isDisable() && !botonDatos.isDisable()){
            actualizarPermisosAlgoritmos();
        }
    }

    @FXML
    void actualizarMetodos(MouseEvent event) {
        if(botonComparacion.isDisable()){

        }
    }

    @FXML
    void mostrarComparacion(MouseEvent event) {
        tablaDatos.setVisible(false);
        gridComparacion.setVisible(true);
        botonComparacion.setDisable(true);
        botonDatos.setDisable(false);
    }

    @FXML
    void mostrarDatos(MouseEvent event) {
        tablaDatos.setVisible(true);
        gridComparacion.setVisible(false);
        botonComparacion.setDisable(false);
        botonDatos.setDisable(true);
    }

    @FXML
    void ordenar(MouseEvent event) {
        if(botonComparacion.isDisable() && botonDatos.isDisable()) botonComparacion.setDisable(false);
        int cantidadGraficas = 0;
        int filas = 1;
        int columnas = 1;
        boolean[] checksColumnas = obtenerChecksColumnas();
        for(boolean c: checksColumnas) if(c) cantidadGraficas++;
        actualizarPermisosAlgoritmos();

        if(cantidadGraficas >= 3) filas = 3;
        else  if(cantidadGraficas == 2) filas = 2;
        if(cantidadGraficas >= 7) columnas = 3;
        else  if(cantidadGraficas >= 4) columnas = 2;

        gridComparacion.getChildren().clear();
        gridComparacion.getColumnConstraints().clear();
        gridComparacion.getRowConstraints().clear();

        // Configurar restricciones de Columnas
        double anchoPorcentaje = 100.0 / columnas;
        for (int i = 0; i < columnas; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(anchoPorcentaje); // Divide el espacio de forma equitativa
            cc.setHgrow(Priority.ALWAYS);       // Obliga a expandirse horizontalmente
            gridComparacion.getColumnConstraints().add(cc);
        }

        // Configurar restricciones de Filas
        double altoPorcentaje = 100.0 / filas;
        for (int i = 0; i < filas; i++) {
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(altoPorcentaje); // Divide el espacio de forma equitativa
            rc.setVgrow(Priority.ALWAYS);       // Obliga a expandirse verticalmente
            gridComparacion.getRowConstraints().add(rc);
        }

        if(checksColumnas[0]) crearGrafica("Titulos", medidor.ordenarTitulo(), false);
        if(checksColumnas[1]) crearGrafica("Fecha de lanzamiento", medidor.ordenarFecha(), false);
        if(checksColumnas[2]) crearGrafica("Equipo", medidor.ordenarEquipo(), false);
        if(checksColumnas[3]) crearGrafica("Calificacion", medidor.ordenarCalificacion(), true);
        if(checksColumnas[4]) crearGrafica("Cantidad de listados", medidor.ordenarCantidadListado(), true);
        if(checksColumnas[5]) crearGrafica("Cantidad de reviews", medidor.ordenarCantidadReview(), true);
        if(checksColumnas[6]) crearGrafica("Genero", medidor.ordenarGenero(), false);
        if(checksColumnas[7]) crearGrafica("Resumen", medidor.ordenarResumen(), false);
        if(checksColumnas[8]) crearGrafica("Reviews", medidor.ordenarReview(), false);

    }

}
