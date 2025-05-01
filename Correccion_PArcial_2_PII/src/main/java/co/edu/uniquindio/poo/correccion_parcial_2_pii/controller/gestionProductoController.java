package co.edu.uniquindio.poo.correccion_parcial_2_pii.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;


import co.edu.uniquindio.poo.correccion_parcial_2_pii.model.Producto;
import co.edu.uniquindio.poo.correccion_parcial_2_pii.model.RegistroGlobal;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private TableColumn<Producto, String> componenteColumna;

    @FXML
    private Button eliminarProductoBoton;

    @FXML
    private TableColumn<Producto, String> nombreColumna;

    @FXML
    private TableColumn<Producto, Double> precioColumna;

    @FXML
    private TextField productoComponenteCampo;

    @FXML
    private TextField productoNombreCampo;

    @FXML
    private TextField productoPrecioCampo;

    @FXML
    private TableView<Producto> productosTabla;



    RegistroGlobal rg = RegistroGlobal.getInstancia();


    @FXML
    void atrasAccion(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/correccion_parcial_2_pii/Principal.fxml"));
            Parent root = fxmlLoader.load();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Otra ventana");
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.show();

            Stage actual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            actual.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void añadirComponenteAccion(ActionEvent event) {

        String nuevoComponente = productoComponenteCampo.getText();

        if (nuevoComponente == null || nuevoComponente.isBlank()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Componente vacío");
            alerta.setHeaderText("Campo requerido");
            alerta.setContentText("Por favor ingresa un componente.");
            alerta.showAndWait();
            return;
        }

        Producto productoSeleccionado = productosTabla.getSelectionModel().getSelectedItem();

        if (productoSeleccionado == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Sin selección");
            alerta.setHeaderText("No se ha seleccionado un producto");
            alerta.setContentText("Selecciona un producto de la tabla para añadirle el componente.");
            alerta.showAndWait();
            return;
        }

        productoSeleccionado.addComponente(nuevoComponente);
        productosTabla.refresh();
        productoComponenteCampo.clear();
    }

    @FXML
    void añadirProductoAccion(ActionEvent event) {

        String nombre = productoNombreCampo.getText();
        String precioTexto = productoPrecioCampo.getText();

        if (nombre.isBlank() || precioTexto.isBlank()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos incompletos");
            alerta.setHeaderText("Faltan datos");
            alerta.setContentText("Por favor completa todos los campos.");
            alerta.showAndWait();
            return;
        }

        try {
            double precio = Double.parseDouble(precioTexto);


            Producto nuevoProducto = new Producto.Builder().setNombre(nombre).setPrecio(precio).build();
            rg.añadirProducto(nuevoProducto);
            productosTabla.getItems().add(nuevoProducto);

            productoNombreCampo.clear();
            productoComponenteCampo.clear();
            productoPrecioCampo.clear();

        } catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de formato");
            alerta.setHeaderText("Precio inválido");
            alerta.setContentText("El campo de precio debe ser un número válido.");
            alerta.showAndWait();
        }

    }


    @FXML
    void eliminarProductoAccion(ActionEvent event) {
        Producto productoSeleccionado = productosTabla.getSelectionModel().getSelectedItem();

        if (productoSeleccionado == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Sin selección");
            alerta.setHeaderText("No se ha seleccionado un producto");
            alerta.setContentText("Selecciona un producto de la tabla para eliminarlo.");
            alerta.showAndWait();
            return;
        }

        rg.eliminarPersona(productoSeleccionado);
        productosTabla.getItems().remove(productoSeleccionado);
    }



    @FXML
    void initialize() {

        nombreColumna.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));

        componenteColumna.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.join(", ", cellData.getValue().getComponentes())));

        precioColumna.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getPrecio()).asObject());

        productosTabla.setItems(FXCollections.observableArrayList(rg.getProductos()));

        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert añadirComponenteBoton != null : "fx:id=\"añadirComponenteBoton\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert añadirProductoBoton != null : "fx:id=\"añadirProductoBoton\" was not injected: check your FXML file 'gestionProducto.fxml'.";

        assert componenteColumna != null : "fx:id=\"componenteColumna\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert eliminarProductoBoton != null : "fx:id=\"eliminarProductoBoton\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert nombreColumna != null : "fx:id=\"nombreColumna\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert precioColumna != null : "fx:id=\"precioColumna\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert productoComponenteCampo != null : "fx:id=\"productoComponenteCampo\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert productoNombreCampo != null : "fx:id=\"productoNombreCampo\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert productoPrecioCampo != null : "fx:id=\"productoPrecioCampo\" was not injected: check your FXML file 'gestionProducto.fxml'.";
        assert productosTabla != null : "fx:id=\"productosTabla\" was not injected: check your FXML file 'gestionProducto.fxml'.";

    }

}

