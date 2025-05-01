package co.edu.uniquindio.poo.correccion_parcial_2_pii.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button gestionarDispositivosBoton;

    @FXML
    private Button gestionarProductosBoton;

    @FXML
    void gestionarDispositivosAccion(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/correccion_parcial_2_pii/gestionDispositivo.fxml"));
            Parent root = fxmlLoader.load();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Gestion Dispositivos");
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.show();

            Stage actual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            actual.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gestionarProductosAccion(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/correccion_parcial_2_pii/gestionProducto.fxml"));
            Parent root = fxmlLoader.load();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Gestion Productos");
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.show();

            Stage actual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            actual.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert gestionarDispositivosBoton != null : "fx:id=\"gestionarDispositivosBoton\" was not injected: check your FXML file 'Principal.fxml'.";
        assert gestionarProductosBoton != null : "fx:id=\"gestionarProductosBoton\" was not injected: check your FXML file 'Principal.fxml'.";

    }

}
