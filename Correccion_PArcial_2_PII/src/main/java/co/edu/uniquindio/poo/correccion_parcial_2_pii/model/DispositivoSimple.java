package co.edu.uniquindio.poo.correccion_parcial_2_pii.model;
/**
 * Implementación básica de dispositivo de seguridad.
 */
public class DispositivoSimple implements Dispositivo {

    private String nombre;
    private boolean activo;
    private int prioridad;

    public DispositivoSimple(String nombre, boolean activo, int prioridad) {
        this.nombre = nombre;
        this.activo = activo;
        this.prioridad = prioridad;
    }

    @Override
    public String estado() {
        return "[" + nombre + "] Estado: " + (activo ? "Activo" : "Inactivo");
    }

    @Override
    public int prioridad() {
        return prioridad;
    }

    @Override
    public String tipo() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "DispositivoSimple{" +
                "nombre='" + nombre + '\'' +
                ", activo=" + activo +
                ", prioridad=" + prioridad +
                '}';
    }
}
