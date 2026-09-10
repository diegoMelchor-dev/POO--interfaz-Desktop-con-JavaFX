package vallegrande.edu.pe.sistemas.controller;

import vallegrande.edu.pe.sistemas.view.MainView;

public class Maincontroller {

    private MainView view;
    public Maincontroller(MainView view){
        this.view = view;
        configurarEventos();
    }
    private void configurarEventos(){
        view.getBtnInicio().setOnAction( ActionEvent -> {
            view.mostrarInicio();
        });

        view.getBtnUsuarios().setOnAction( ActionEvent -> {
            view.mostrarUsuarios();
        });
        view.getBtnProductos().setOnAction( ActionEvent -> {
            view.mostrarProductos();
        });
        view.getBtnReportes().setOnAction( ActionEvent -> {
            view.mostrarReportes();
        });
        view.getBtnConfiguracion().setOnAction( ActionEvent -> {
            view.mostrarConfiguracion();
        });
        view.getBtnCitas().setOnAction( ActionEvent -> {
            view.mostrarCitas();
        });
    }

}