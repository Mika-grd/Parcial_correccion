package co.edu.uniquindio.poo.correccion_parcial_2_pii.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class gestionProductoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button atrasBoton;

    @FXML
    private Button añadirComponenteBoton;

    @FXML
    private Button añadirProductoBoton;

    @FXML
    private Button buscarBoton;

    @FXML
    private TextField busquedaCampo;

    @FXML
    private TableColumn<?, ?> componenteColumna;

    @FXML
    private Button eliminarProductoBoton;

    @FXML
    private TableColumn<?, ?> nombreColumna;

    @FXML
    private TableColumn<?, ?> precioColumna;

    @FXML
    private TextField productoComponenteCampo;

    @FXML
    private TextField productoNombreCampo;

    @FXML
    private TextField productoPrecioCampo;

    @FXML
    private TableView<?> productosTabla;

    @FXML
    private Button recargarBoton;

    @FXML
    void atrasAccion(ActionEvent event) {

    }

    @FXML
    void añadirComponenteAccion(ActionEvent event) {

    }

    @FXML
    void añadirProductoAccion(ActionEvent event) {

    }

    @FXML
    void buscarAccion(ActionEvent event) {

    }

    @FXML
    void eliminarProductoAccion(ActionEvent event) {

    }

    @FXML
    void recargarAccion(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert añadirComponenteBoton != null : "fx:id=\"añadirComponenteBoton\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert añadirProductoBoton != null : "fx:id=\"añadirProductoBoton\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert buscarBoton != null : "fx:id=\"buscarBoton\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert busquedaCampo != null : "fx:id=\"busquedaCampo\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert componenteColumna != null : "fx:id=\"componenteColumna\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert eliminarProductoBoton != null : "fx:id=\"eliminarProductoBoton\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert nombreColumna != null : "fx:id=\"nombreColumna\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert precioColumna != null : "fx:id=\"precioColumna\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert productoComponenteCampo != null : "fx:id=\"productoComponenteCampo\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert productoNombreCampo != null : "fx:id=\"productoNombreCampo\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert productoPrecioCampo != null : "fx:id=\"productoPrecioCampo\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert productosTabla != null : "fx:id=\"productosTabla\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert recargarBoton != null : "fx:id=\"recargarBoton\" was not injected: check your FXML file 'gestionProducto.fxml'.";

    }

}

