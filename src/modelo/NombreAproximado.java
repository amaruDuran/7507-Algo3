package modelo;

public class NombreAproximado implements ICriterioBusqueda {
    private String nombreAproximado;

    public NombreAproximado(String unNombre) {
        this.nombreAproximado = unNombre;
    }

    @Override
    public boolean coincideCon(Producto unProducto) {
        return unProducto.getNombre().startsWith(nombreAproximado);
    }

}
