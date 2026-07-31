package cl.td.restaurante;

public abstract class ProductoMenu {

    private int id;
    private String nombre;
    private double precio;
    private boolean disponible;

    public ProductoMenu(int id, String nombre, double precio, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", nombre: " + nombre + ", precio: " + precio + ", disponible: " + disponible;
    }
}