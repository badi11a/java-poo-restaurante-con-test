package cl.td.restaurante;

public class Bebida extends ProductoMenu {

    private int capacidadEnMililitros;

    public Bebida(int id, String nombre, double precio, boolean disponible, int capacidadEnMililitros) {
        super(id, nombre, precio, disponible);
        this.capacidadEnMililitros = capacidadEnMililitros;
    }

    @Override
    public String toString() {
        return super.toString() + ", capacidad: " + capacidadEnMililitros + " mililitros";
    }
}