package modelo;

public class NombreExacto implements ICriterioBusqueda {
    private String nombre;

    public NombreExacto(String unNombre) {
        this.nombre = unNombre;
    }


    @Override
    public boolean coincideCon(Producto unProducto) {
        return unProducto.getNombre().equals(nombre);
    }
}
