package co.edu.uniquindio.poo.correccion_parcial_2_pii.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import co.edu.uniquindio.poo.correccion_parcial_2_pii.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class gestionDispositivoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> activoComboBox;

    @FXML
    private TableColumn<DispositivoSimple, String> activoColumn;

    @FXML
    private TableColumn<DispositivoCompuesto, String> hijosColumn;

    @FXML
    private TableColumn<DispositivoCompuesto, String> nombreCompuestoColumn;

    @FXML
    private TableColumn<DispositivoSimple, String> nombreSimpleColumn;


    @FXML
    private Button atrasBoton;

    @FXML
    private Button añadirDispositivoBoton;

    @FXML
    private ComboBox<String> compuestoSimpleComboBox;

    @FXML
    private TextField dispositivoNombreCampo;

    @FXML
    private Button eliminarDispositivoBoton;

    @FXML
    private ComboBox<DispositivoCompuesto> hijoComboBox;

    @FXML
    private Button recargarCompuestoBoton;

    @FXML
    private Button recargarSimpleBoton;

    @FXML
    private TableView<DispositivoCompuesto> tablaCompuesto;

    @FXML
    private TableView<DispositivoSimple> tablaSimple;

    CentralMonitoreo cm = CentralMonitoreo.getInstancia();


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
    void añadirDispositivoAccion(ActionEvent event) {

        if (dispositivoNombreCampo.getText() == null || dispositivoNombreCampo.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Nombre del dispositivo requerido");
            alert.setContentText("El nombre del dispositivo es obligatorio.");
            alert.showAndWait();
            return;
        }

        if (activoComboBox.getValue() == null || compuestoSimpleComboBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Selección de opciones requerida");
            alert.setContentText("Las opciones de ComboBox deben ser seleccionadas.");
            alert.showAndWait();
            return;
        }

        String activo = activoComboBox.getValue();
        boolean valorActivo = false;
        if (activo.equals("Yes")) {
            valorActivo = true;
        }
        String compuestoSimple = compuestoSimpleComboBox.getValue();
        String nombreDispositivo = dispositivoNombreCampo.getText();

        if ("Yes".equals(compuestoSimple)) {


            DispositivoCompuesto dispositivoCompuesto = new DispositivoCompuesto(nombreDispositivo);
            cm.añadirDispositivo(dispositivoCompuesto);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText("Dispositivo compuesto añadido");
            alert.setContentText("Dispositivo compuesto añadido: " + nombreDispositivo);
            alert.showAndWait();
        } else if ("No".equals(compuestoSimple)) {
            DispositivoSimple dispositivoSimple = new DispositivoSimple(nombreDispositivo, valorActivo, 0);
            cm.añadirDispositivo(dispositivoSimple);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText("Dispositivo simple añadido");
            alert.setContentText("Dispositivo simple añadido: " + nombreDispositivo);
            alert.showAndWait();

            if (hijoComboBox.getValue() != null) {

                DispositivoCompuesto padre = hijoComboBox.getValue();
                padre.agregar(dispositivoSimple);

                alert.setTitle("Éxito");
                alert.setHeaderText("Dispositivo hijo de: " + hijoComboBox.getValue());
                alert.setContentText("");
                alert.showAndWait();
            }



        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Opción no válida");
            alert.setContentText("Debe seleccionar una opción válida para 'compuestoSimple'.");
            alert.showAndWait();
        }
    }

    @FXML
    void eliminarDispositivoAccion(ActionEvent event) {
        Dispositivo dispositivoSeleccionado = tablaSimple.getSelectionModel().getSelectedItem();

        if (dispositivoSeleccionado == null) {
            dispositivoSeleccionado = tablaCompuesto.getSelectionModel().getSelectedItem();
        }

        if (dispositivoSeleccionado != null) {
            cm.eliminarDispositivo(dispositivoSeleccionado);
            tablaSimple.getItems().remove(dispositivoSeleccionado);
            tablaCompuesto.getItems().remove(dispositivoSeleccionado);
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Advertencia");
            alerta.setHeaderText("No se seleccionó ningún dispositivo");
            alerta.setContentText("Por favor selecciona un dispositivo para eliminar.");
            alerta.showAndWait();
        }
    }

    @FXML
    void recargarCompuestoAccion(ActionEvent event) {
        actualizarTablas();

    }

    @FXML
    void recargarSimpleAccion(ActionEvent event) {
        actualizarTablas();
    }

    @FXML
    void initialize() {
        hijoComboBox.setCellFactory(param -> new ListCell<DispositivoCompuesto>() {
            @Override
            protected void updateItem(DispositivoCompuesto item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    // Aquí aseguramos que se muestre el nombre del dispositivo compuesto
                    setText(item.getNombre());  // Asumiendo que `getNombre()` es el método para obtener el nombre
                }
            }
        });

        hijoComboBox.setButtonCell(new ListCell<DispositivoCompuesto>() {
            @Override
            protected void updateItem(DispositivoCompuesto item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    // Aquí también se asegura que se muestre el nombre en el botón
                    setText(item.getNombre());
                }
            }
        });

        List<String> opciones = List.of("Yes", "No");

        // Asignarlas a ambas ComboBox
        activoComboBox.getItems().addAll(opciones);
        compuestoSimpleComboBox.getItems().addAll(opciones);

        actualizarHijoComboBox();
        actualizarTablas();

        // Configurar columna de nombre para DispositivoCompuesto
        nombreCompuestoColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));

        List<Dispositivo> dispositivos = cm.getDispositivos();


        hijosColumn.setCellValueFactory(cellData -> {
            // Verificamos si hay hijos en el dispositivo
            if (cellData.getValue().getHijos() == null || cellData.getValue().getHijos().isEmpty()) {
                return new SimpleStringProperty("No tiene hijos");
            }

            // Filtramos los dispositivos hijos y obtenemos el nombre si es de tipo DispositivoSimple
            String hijosNombres = cellData.getValue().getHijos().stream()
                    .map(d -> {
                        if (d instanceof DispositivoSimple) {
                            return ((DispositivoSimple) d).getNombre();  // Si es DispositivoSimple, obtenemos el nombre
                        } else if (d instanceof DispositivoCompuesto) {
                            return ((DispositivoCompuesto) d).getNombre();  // Si es DispositivoCompuesto, obtenemos el nombre
                        }
                        else if (d instanceof Firewall) {
                            return "Firewall";
                        } else if (d instanceof DetectorIntrusos) {
                            return "Detector de Intrusos";
                        }
                        return "Desconocido";  // Si no es ninguno de los dos, podemos devolver "Desconocido"
                    })
                    .collect(Collectors.joining(", "));  // Unimos los nombres con coma

            return new SimpleStringProperty(hijosNombres);  // Devolvemos la lista de nombres de los hijos
        });



        nombreSimpleColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));


        activoColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().isActivo() ? "Sí" : "No"));

        assert activoColumn != null : "fx:id=\"activoColumn\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert activoComboBox != null : "fx:id=\"activoComboBox\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert añadirDispositivoBoton != null : "fx:id=\"añadirDispositivoBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert compuestoSimpleComboBox != null : "fx:id=\"compuestoSimpleComboBox\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert dispositivoNombreCampo != null : "fx:id=\"dispositivoNombreCampo\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert eliminarDispositivoBoton != null : "fx:id=\"eliminarDispositivoBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert hijoComboBox != null : "fx:id=\"hijoComboBox\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert hijosColumn != null : "fx:id=\"hijosColumn\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert nombreCompuestoColumn != null : "fx:id=\"nombreCompuestoColumn\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert nombreSimpleColumn != null : "fx:id=\"nombreSimpleColumn\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert recargarCompuestoBoton != null : "fx:id=\"recargarCompuestoBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert recargarSimpleBoton != null : "fx:id=\"recargarSimpleBoton\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert tablaCompuesto != null : "fx:id=\"tablaCompuesto\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";
        assert tablaSimple != null : "fx:id=\"tablaSimple\" was not injected: check your FXML file 'gestionDispositivo.fxml'.";

    }

    private void actualizarTablas() {
        tablaCompuesto.getItems().clear();
        tablaSimple.getItems().clear();

        // Filtrar y agregar los dispositivos a las tablas correspondientes
        for (Dispositivo dispositivo : cm.getDispositivos()) {
            if (dispositivo instanceof DispositivoCompuesto) {
                tablaCompuesto.getItems().add((DispositivoCompuesto) dispositivo);
            } else if (dispositivo instanceof DispositivoSimple) {
                tablaSimple.getItems().add((DispositivoSimple) dispositivo);
            }
        }
    }

    private void actualizarHijoComboBox() {
        hijoComboBox.getItems().clear();

        // Agregar los dispositivos compuestos de la lista de dispositivos (cm.dispositivos)
        for (Dispositivo dispositivo : cm.getDispositivos()) {
            if (dispositivo instanceof DispositivoCompuesto) {
                hijoComboBox.getItems().add((DispositivoCompuesto) dispositivo);
            }
        }
    }

}

