package co.edu.uniquindio.poo.correccion_parcial_2_pii.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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

    }

    @FXML
    void gestionarProductosAccion(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert gestionarDispositivosBoton != null : "fx:id=\"gestionarDispositivosBoton\" was not injected: check your FXML file 'Principal.fxml'.";
        assert gestionarProductosBoton != null : "fx:id=\"gestionarProductosBoton\" was not injected: check your FXML file 'Principal.fxml'.";

    }

}
