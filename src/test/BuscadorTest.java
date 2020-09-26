package test;

import modelo.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BuscadorTest {
    private Buscador buscador;
    private Producto lapiz;
    private Producto pelota;
    private Producto pelopincho;

    @Before
    public void setup(){
        this.pelota = new Producto("pelota", 500, "deportes y aire libre");
        this.lapiz = new Producto("lapiz", 30, "articulos de libreria");
        this.pelopincho = new Producto("pelopincho", 7000, "deportes y aire libre");
        this.buscador = new Buscador();
        this.buscador.agregarProducto(this.pelota);
        this.buscador.agregarProducto(this.lapiz);
        this.buscador.agregarProducto(this.pelopincho);
    }

    @Test
    public void test01BusquedaPorNombreExacto() {

        List<Producto> resultados = this.buscador.buscarPor(new NombreExacto("lapiz"), 4);

        Assert.assertEquals(Arrays.asList(this.lapiz), resultados);
    }

    @Test
    public void test02BusquedaPorNombreAproximado() {

        List<Producto> resultados = buscador.buscarPor(new NombreAproximado("pelo"), 4);

        Assert.assertEquals(Arrays.asList(this.pelota, this.pelopincho), resultados);
    }

    @Test
    public void test03BusquedaPorCategoriaAproximada() {

        List<Producto> resultados = this.buscador.buscarPor(new CategoriaAproximada("aire"), 4);

        Assert.assertEquals(Arrays.asList(this.pelota, this.pelopincho), resultados);
    }

    @Test
    public void test04BusquedaPorPrecio() {

        List<Producto> resultados = this.buscador.buscarPor(new Precio(30, 600), 4);

        Assert.assertEquals(Arrays.asList(this.pelota, this.lapiz), resultados);
    }

    @Test
    public void test05BusquedaCompuestaPorNombreAproximadoYPrecioDevuelveLaListaFiltrada() {

        List<Producto> resultados = this.buscador.buscarPor(
                new CriterioCompuesto(
                List.of( new NombreAproximado("pelo"),
                        new Precio(400,700) )
                        ),
                2);
        Assert.assertEquals(Arrays.asList(this.pelota), resultados);
    }

    @Test
    public void test06BusquedaCompuestaPorNombreExactoYPrecioDevuelveLaListaFiltrada() {

        List<Producto> resultados = this.buscador.buscarPor(
                new CriterioCompuesto(
                        List.of( new NombreExacto("pelo"),
                                new Precio(400,700) )
                        ),
                2);
        Assert.assertEquals(Arrays.asList(), resultados);
    }

    @Test
    public void test07BusquedabuscarPorPermiteElegirUnTopeDeBusquedaSegunCriterioDevuelveLaListaFiltrada() {

        List<Producto> resultados = this.buscador.buscarPor(
                new CriterioCompuesto(
                        List.of( new CategoriaAproximada("libre"),
                                new Precio(0,7100) )
                )
                ,2
        );
        Assert.assertEquals(Arrays.asList(this.pelota, this.lapiz), resultados);
    }


}
