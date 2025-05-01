package co.edu.uniquindio.poo.correccion_parcial_2_pii.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class gestionDispositivoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> activoComboBox;

    @FXML
    private Button atrasBoton;

    @FXML
    private Button añadirDispositivoBoton;

    @FXML
    private ComboBox<?> compuestoSimpleComboBox;

    @FXML
    private Button eliminarDispositivoBoton;

    @FXML
    private ComboBox<?> hijoComboBox;

    @FXML
    private TextField productoNombreCampo;

    @FXML
    private Button recargarBoton;

    @FXML
    private Button recargarBoton1;

    @FXML
    private TableView<?> tablaCompuesto;

    @FXML
    private TableView<?> tablaSimple;

    @FXML
    void atrasAccion(ActionEvent event) {

    }

    @FXML
    void añadirDispositivoAccion(ActionEvent event) {

    }

    @FXML
    void eliminarDispositivoAccion(ActionEvent event) {

    }

    @FXML
    void recargarAccion(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert activoComboBox != null : "fx:id=\"activoComboBox\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert añadirDispositivoBoton != null : "fx:id=\"añadirDispositivoBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert compuestoSimpleComboBox != null : "fx:id=\"compuestoSimpleComboBox\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert eliminarDispositivoBoton != null : "fx:id=\"eliminarDispositivoBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert hijoComboBox != null : "fx:id=\"hijoComboBox\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert productoNombreCampo != null : "fx:id=\"productoNombreCampo\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert recargarBoton != null : "fx:id=\"recargarBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert recargarBoton1 != null : "fx:id=\"recargarBoton1\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert tablaCompuesto != null : "fx:id=\"tablaCompuesto\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert tablaSimple != null : "fx:id=\"tablaSimple\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";

    }

}
