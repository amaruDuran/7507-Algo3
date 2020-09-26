package modelo;

public class Precio implements ICriterioBusqueda {
    private double precioDesde;
    private double precioHasta;

    public Precio(double unprecioInicio, double unprecioFin) {
        this.precioDesde = unprecioInicio;
        this.precioHasta = unprecioFin;
    }

    @Override
    public boolean coincideCon(Producto unProducto) {
        return unProducto.getPrecio() >= this.precioDesde && unProducto.getPrecio() <= this.precioHasta;
    }
}
