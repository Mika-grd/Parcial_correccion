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
    private TextField dispositivoNombreCampo;

    @FXML
    private Button eliminarDispositivoBoton;

    @FXML
    private ComboBox<?> hijoComboBox;

    @FXML
    private Button recargarCompuestoBoton;

    @FXML
    private Button recargarSimpleBoton;

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
    void recargarCompuestoAccion(ActionEvent event) {

    }

    @FXML
    void recargarSimpleAccion(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert activoComboBox != null : "fx:id=\"activoComboBox\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert añadirDispositivoBoton != null : "fx:id=\"añadirDispositivoBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert compuestoSimpleComboBox != null : "fx:id=\"compuestoSimpleComboBox\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert dispositivoNombreCampo != null : "fx:id=\"dispositivoNombreCampo\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert eliminarDispositivoBoton != null : "fx:id=\"eliminarDispositivoBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert hijoComboBox != null : "fx:id=\"hijoComboBox\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert recargarCompuestoBoton != null : "fx:id=\"recargarCompuestoBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert recargarSimpleBoton != null : "fx:id=\"recargarSimpleBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert tablaCompuesto != null : "fx:id=\"tablaCompuesto\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert tablaSimple != null : "fx:id=\"tablaSimple\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";

    }

}

