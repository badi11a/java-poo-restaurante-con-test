package cl.td.restaurante;

public class Plato extends ProductoMenu {

    private String categoria;

    public Plato(int id, String nombre, double precio, boolean disponible, String categoria) {
        super(id, nombre, precio, disponible);
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString() + ", categoría: " + categoria;
    }
}