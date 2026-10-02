package vallegrande.edu.pe.sistemas;

import javafx.application.Application;
import javafx.stage.Stage;
import vallegrande.edu.pe.sistemas.controller.MainController;
import vallegrande.edu.pe.sistemas.view.MainView;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        MainView view = new MainView(stage);
        new MainController(view);
    }

    public static void main(String[] args) {
        launch(args);
    }
}