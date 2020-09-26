package modelo;

import java.util.List;

public class CriterioCompuesto implements ICriterioBusqueda {
    List<ICriterioBusqueda> criteriosDeBusqueda;

    public CriterioCompuesto(List<ICriterioBusqueda> criterios) {
        this.criteriosDeBusqueda = criterios;
    }

    @Override
    public boolean coincideCon(Producto unProducto) {
        for (ICriterioBusqueda unCriterio: this.criteriosDeBusqueda) {
            if(!unCriterio.coincideCon(unProducto)){
                return false;
            }
        }
        return true;
    }
}
