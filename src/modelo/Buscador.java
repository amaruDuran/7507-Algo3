package modelo;

import java.util.ArrayList;
import java.util.List;

public class Buscador {
    private List<Producto> productos;

    public Buscador() {
        productos = new ArrayList<Producto>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> buscarPor(ICriterioBusqueda criterioDeBusqueda, int topeDeBusqueda) {
        List<Producto> resultados = new ArrayList<Producto>();
        ICriterioBusqueda criterio = new CriterioCompuesto(
                List.of(criterioDeBusqueda,
                        new Tope(topeDeBusqueda, resultados)
                )
        );
        for (Producto producto: this.productos) {
            if (criterio.coincideCon(producto)) {
                resultados.add(producto);
            }
        }
        return resultados;
    }
}
