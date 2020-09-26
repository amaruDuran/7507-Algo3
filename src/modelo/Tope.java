package modelo;

import java.util.List;

public class Tope implements ICriterioBusqueda {
    private List<Producto> resultadosParciales;
    private int tope;

    public Tope(int topeDeBusqueda, List<Producto> resultados) {
        this.resultadosParciales = resultados;
        this.tope = topeDeBusqueda;
    }

    @Override
    public boolean coincideCon(Producto unProducto) {
        return resultadosParciales.size() < tope;
    }
}
