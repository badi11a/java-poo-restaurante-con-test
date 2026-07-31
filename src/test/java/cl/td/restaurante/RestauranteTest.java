package cl.td.restaurante;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RestauranteTest {

    @Test
    void debeRegistrarUnProducto() {
        Restaurante restaurante = new Restaurante();
        Plato plato = new Plato(1, "Hamburguesa", 8500, true, "Principal");

        boolean resultado = restaurante.registrarProducto(plato);

        assertTrue(resultado);
    }

    @Test
    void noDebeRegistrarProductosConElMismoId() {
        Restaurante restaurante = new Restaurante();
        Plato plato = new Plato(1, "Hamburguesa", 8500, true, "Principal");
        Bebida bebida = new Bebida(1, "Bebida", 2000, true, 350);

        restaurante.registrarProducto(plato);
        boolean resultado = restaurante.registrarProducto(bebida);

        assertFalse(resultado);
    }

    @Test
    void debeEliminarProducto() {
        Restaurante restaurante = new Restaurante();
        Plato plato = new Plato(1, "Hamburguesa", 8500, true, "Principal");

        restaurante.registrarProducto(plato);
        boolean resultado = restaurante.eliminarProducto(1);

        assertTrue(resultado);
        assertNull(restaurante.buscarProductoPorId(1));
    }

    @Test
    void noDebePermitirPrecioNegativoAlModificar() {
        Restaurante restaurante = new Restaurante();
        Plato plato = new Plato(1, "Hamburguesa", 8500, true, "Principal");

        restaurante.registrarProducto(plato);
        boolean resultado = restaurante.modificarProducto(plato, "Hamburguesa", -1000, true);

        assertFalse(resultado);
    }

}