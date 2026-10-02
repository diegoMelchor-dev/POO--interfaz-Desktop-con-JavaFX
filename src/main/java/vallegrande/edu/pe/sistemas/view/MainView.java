package vallegrande.edu.pe.sistemas.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vallegrande.edu.pe.sistemas.model.Usuario;

import java.net.URL;
import java.util.List;

public class MainView {

    private Button btnInicio;
    private Button btnUsuarios;
    private Button btnRegistrar;
    private TextField txtNombre;
    private TextField txtApellido;
    private TextField txtCorreo;
    private TextField txtEstado;
    private VBox panelInicio;
    private VBox panelUsuarios;
    private TableView<Usuario> tablaUsuarios;

    @SuppressWarnings("unchecked")
    public MainView(Stage stage) {
        try {
            URL fxmlUrl = getClass().getResource("/MainView.fxml");
            if (fxmlUrl == null) {
                fxmlUrl = getClass().getResource("/vallegrande/edu/pe/sistemas/MainView.fxml");
            }
            if (fxmlUrl == null) {
                fxmlUrl = getClass().getClassLoader().getResource("MainView.fxml");
            }
            if (fxmlUrl == null) {
                throw new RuntimeException("¡Atención! No se encontró ningún archivo .fxml en resources.");
            }

            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            btnInicio = (Button) root.lookup("#btnInicio");
            btnUsuarios = (Button) root.lookup("#btnUsuarios");
            btnRegistrar = (Button) root.lookup("#btnRegistrar");
            txtNombre = (TextField) root.lookup("#txtNombre");
            txtApellido = (TextField) root.lookup("#txtApellido");
            txtCorreo = (TextField) root.lookup("#txtCorreo");
            txtEstado = (TextField) root.lookup("#txtEstado");
            panelInicio = (VBox) root.lookup("#panelInicio");
            panelUsuarios = (VBox) root.lookup("#panelUsuarios");
            tablaUsuarios = (TableView<Usuario>) root.lookup("#tablaUsuarios");

            crearColumnas();

            Scene scene = new Scene(root);
            stage.setTitle("Sistema de Gestión - Usuarios");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define las columnas de la tabla
    private void crearColumnas() {
        TableColumn<Usuario, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Usuario, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Usuario, String> colApellido = new TableColumn<>("Apellido");
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        TableColumn<Usuario, String> colCorreo = new TableColumn<>("Correo");
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));

        TableColumn<Usuario, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        tablaUsuarios.getColumns().addAll(colId, colNombre, colApellido, colCorreo, colEstado);
    }

    public Button getBtnInicio() {
        return btnInicio;
    }

    public Button getBtnUsuarios() {
        return btnUsuarios;
    }

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getApellido() {
        return txtApellido.getText();
    }

    public String getCorreo() {
        return txtCorreo.getText();
    }

    public String getEstado() {
        return txtEstado.getText();
    }

    public void mostrarInicio() {
        mostrarPanel(panelInicio, panelUsuarios);
    }

    public void mostrarUsuarios() {
        mostrarPanel(panelUsuarios, panelInicio);
    }

    private void mostrarPanel(VBox mostrar, VBox ocultar) {
        mostrar.setVisible(true);
        mostrar.setManaged(true);
        ocultar.setVisible(false);
        ocultar.setManaged(false);
    }

    public void mostrarDatosUsuarios(List<Usuario> usuarios) {
        tablaUsuarios.setItems(FXCollections.observableArrayList(usuarios));
        // Limpia el formulario después de registrar
        txtNombre.clear();
        txtApellido.clear();
        txtCorreo.clear();
        txtEstado.clear();
    }
}