package co.edu.uniquindio.poo.correccion_parcial_2_pii;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import co.edu.uniquindio.poo.correccion_parcial_2_pii.model.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/correccion_parcial_2_pii/Principal.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setTitle("Mi Aplicación JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
            AnalizadorProductos analizador = new AnalizadorProductos();

            // 1. PARTE DE PRODUCCIÓN
            System.out.println("REGISTRO DE PRODUCTOS PERSONALIZADOS");

            Producto p1 = new Producto.Builder().setNombre("Jugo Verde").addComponente("Limón").addComponente("Espinaca").setPrecio(12).build();
            Producto p2 = new Producto.Builder().setNombre("Jugo Rojo").addComponente("Fresa").addComponente("Remolacha").setPrecio(15).build();
            Producto p3 = new Producto.Builder().setNombre("Ensalada Mix").addComponente("Tomate").addComponente("Queso").setPrecio(10).build();

            RegistroGlobal rg = RegistroGlobal.getInstancia();
            rg.agregarProducto(p1);
            rg.agregarProducto(p2);
            rg.agregarProducto(p3);

            rg.mostrar();

            // Filtrar por componente
            System.out.println("\nFiltrado por componente 'Limón':");
            List<Producto> filtrados = analizador.filtrarPorComponente("Limón");
            for (Producto p : filtrados) {
                System.out.println(p);
            }

            // Ordenar por precio
            System.out.println("\nProductos ordenados por precio:");
            List<Producto> ordenados = analizador.ordenarPorPrecio();
            for (Producto p : ordenados) {
                System.out.println(p);
            }

            // Contar por nombre
            System.out.println("\nConteo por nombre de producto:");
            analizador.contarPorNombre();


            // 2. PARTE DE SEGURIDAD
            System.out.println("\nMONITOREO DE DISPOSITIVOS DE SEGURIDAD");

            Dispositivo camara = new DispositivoSimple("Cámara", true, 3);
            Dispositivo sensor = new DispositivoSimple("Sensor", false, 2);

            Dispositivo firewallSensor = new Firewall(sensor);
            Dispositivo intrusosCamara = new DetectorIntrusos(camara);

            DispositivoCompuesto central = new DispositivoCompuesto("Central de Control");
            central.agregar(firewallSensor);
            central.agregar(intrusosCamara);

            LinkedList<Dispositivo> lista = new LinkedList<>(Arrays.asList(central, camara, sensor, firewallSensor));

            CentralMonitoreo cm = CentralMonitoreo.getInstancia();
            for (Dispositivo d : lista) {
                cm.añadirDispositivo(d);
            }

            // Mostrar estados
            cm.mostrarEstados();

            // Ordenar por prioridad
            cm.ordenarPorPrioridad();
            System.out.println("\nDispositivos ordenados por prioridad:");
            cm.mostrarEstados();

            // Filtrar con módulos
            cm.filtrarConModulos();

            // Contar por tipo
            cm.contarPorTipo();


        launch();
    }
}