
package rest;

import excepciones.NoExisteProductoException;
import excepciones.NoExisteProveedorException;
import excepciones.TamanoPaginaExcepcion;
import modelos.Producto;
import servicios.ProductoDuplicadoServicioMapperImpl;
import servicios.ProductoServicioMapperImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//import modelos.ProductoDuplicado;
//import servicios.ProductoDuplicadoServicios;
//import servicios.ProductoServicios;


/*
 * Created by andrea on 29/02/16.
 */


@Path("/productos")
public class ProductoRest {

    @Inject
    private ProductoServicioMapperImpl productoServicioMapper;

    @Inject
    private ProductoDuplicadoServicioMapperImpl productoDuplicadoServicioMapper;

    //@POST
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/paginado")
    public List<Producto> listarProductos() throws TamanoPaginaExcepcion{
        return productoServicioMapper.getProductos();
    }

   /* @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/duplicados")
    public List<ProductoDuplicado> listarProductosDuplicados(){
        return productoDuplicadoServicios.getProductosDuplicados();

    }*/


    @POST
    @Consumes("application/json")
    public void crearProducto(Producto producto) throws Exception {
        productoServicioMapper.agregarProducto(producto);

    }

    @POST
    @Consumes("application/json")
    @Path("/insertalista")
    public Response insertarListaDeProductos(List<Producto> producto)throws Exception{

        productoDuplicadoServicioMapper.agregarListaDeProductos(producto);
        return Response.status(200).build();
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Producto buscarProducto(@PathParam("id") Integer id) throws NoExisteProductoException {
        return productoServicioMapper.buscarProducto(id);
    }



    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void modificarProducto(Producto productoModificado) throws NoExisteProveedorException {
        productoServicioMapper.modificarProducto(productoModificado);
    }


    @DELETE
    @Path("{id}")
    public Object eliminarProducto(@PathParam("id") Integer id) {
        try {
            return productoServicioMapper.eliminarProducto(id);
        }catch (Exception e)
        {
            return Response.status(500).entity("No se pudo eliminar el producto"+e.getMessage().toString()).build();
        }
    }
}

