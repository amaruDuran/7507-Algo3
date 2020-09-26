package modelo;

public class CategoriaAproximada implements ICriterioBusqueda {
    private String nombre;

    public CategoriaAproximada(String nombreCategoriaAproximada) {
        this.nombre = nombreCategoriaAproximada;
    }


    @Override
    public boolean coincideCon(Producto unProducto) {
        return unProducto.getCategoria().contains(this.nombre);
    }
}
