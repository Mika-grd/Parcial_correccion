package co.edu.uniquindio.poo.correccion_parcial_2_pii.model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Fachada que centraliza las operaciones de monitoreo de seguridad.
 */
public class CentralMonitoreo {

    private LinkedList<Dispositivo> dispositivos;

    private static CentralMonitoreo instancia;

    public static CentralMonitoreo getInstancia() {
        if (instancia == null)
            instancia = new CentralMonitoreo(new LinkedList<>());
        return instancia;
    }



    private CentralMonitoreo(LinkedList<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    /**
     * Muestra el estado de todos los dispositivos.
     */
    public void mostrarEstados() {
        System.out.println("\n Estados de Dispositivos:");
        for (int i = 0; i < dispositivos.size(); i++) {
            System.out.println(dispositivos.get(i).estado());
        }
    }

    /**
     * Ordena los dispositivos por prioridad descendente.
     */
    public void ordenarPorPrioridad() {
        for (int i = 0; i < dispositivos.size() - 1; i++) {
            for (int j = 0; j < dispositivos.size() - i - 1; j++) {
                if (dispositivos.get(j).prioridad() < dispositivos.get(j + 1).prioridad()) {
                    Dispositivo temp = dispositivos.get(j);
                    dispositivos.set(j, dispositivos.get(j + 1));
                    dispositivos.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Filtra e imprime solo dispositivos decorados.
     */
    public void filtrarConModulos() {
        System.out.println("\n Dispositivos con módulos añadidos:");
        for (int i = 0; i < dispositivos.size(); i++) {
            Dispositivo d = dispositivos.get(i);
            if (d instanceof ModuloDecorator) {
                System.out.println(d.estado());
            }
        }
    }

    /**
     * Cuenta dispositivos por tipo y muestra resultados.
     */
    public void contarPorTipo() {
        List<String> tiposContados = new ArrayList<>();
        System.out.println("\n Conteo por tipo:");
        for (int i = 0; i < dispositivos.size(); i++) {
            String tipo = dispositivos.get(i).tipo();
            boolean yaContado = false;

            for (int j = 0; j < tiposContados.size(); j++) {
                if (tiposContados.get(j).equals(tipo)) {
                    yaContado = true;
                    break;
                }
            }
            if (!yaContado) {
                int contador = 1;
                for (int k = i + 1; k < dispositivos.size(); k++) {
                    if (dispositivos.get(k).tipo().equals(tipo)) {
                        contador++;
                    }
                }
                tiposContados.add(tipo);
                System.out.println(tipo + ": " + contador);
            }
        }
    }

    //añadir Dispositivo
    public String añadirDispositivo(Dispositivo dispositivo) throws IllegalArgumentException {
        String mensaje = "Se añadió correctamente";
        if (dispositivo == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        dispositivos.add(dispositivo);
        return mensaje;
    }

    //eliminar dispositivo
    public String eliminarDispositivo(Dispositivo dispositivo) throws IllegalArgumentException {
        String mensaje = "Se eliminó correctamente";
        if (dispositivo == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        if (!dispositivos.contains(dispositivo)) {
            mensaje = "No se encuentra en la lista";
        }
        dispositivos.remove(dispositivo);
        return mensaje;
    }


    //editar dispositivo
    public String editarDispositivo(Dispositivo dispositivo, Dispositivo nuevoDispositivo) throws IllegalArgumentException {
        String mensaje = "Editado correctamente";

        if (dispositivo == null || nuevoDispositivo == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }

        if (!dispositivos.contains(dispositivo)) {
            mensaje = "No se encuentra en la lista";
        }

        dispositivos.remove(dispositivo);
        dispositivos.add(nuevoDispositivo);
        return mensaje;
    }

    public LinkedList<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(LinkedList<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }
}
