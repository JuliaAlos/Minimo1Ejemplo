package edu.upc.dsa.services;

import edu.upc.dsa.models.Cliente;
import edu.upc.dsa.models.Pedido;
import edu.upc.dsa.models.PedidoCRUD;
import edu.upc.dsa.models.Producto;
import edu.upc.dsa.util.ProductManager;
import edu.upc.dsa.util.ProductManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/product", description = "Endpoint to Product Service")
@Path("/product")
public class ProductService {

    private ProductManager manager;

    public ProductService() {
        this.manager =ProductManagerImpl.getInstance();
                //Factory.getProductManager();//
        if (true){//manager.listarProductosOrdenados().size()==0&&manager.numPedidos()==0) {
            //Productos
            this.manager.añadirProductos("Bocadillo", 2.50);
            this.manager.añadirProductos("Pastel", 1.50);
            this.manager.añadirProductos("Ensalada", 2.0);
            //Clientes
            this.manager.addCliente("Julia");
            this.manager.addCliente("Paco");
            this.manager.addCliente("Lorena");
            //Pedido
            Pedido p = new Pedido(this.manager.buscarCliente("Julia"));
            p.addLP(3, "Bocadillo");
            p.addLP(1, "Ensalada");
            this.manager.realizarPedido(p);
            Pedido p2 = new Pedido(this.manager.buscarCliente("Julia"));
            p2.addLP(2, "Bocadillo");
            this.manager.realizarPedido(p2);
            //Servir pedido
            this.manager.servirPedido();
        }

    }
    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @ApiOperation(value = "get all Productos ordenados precio", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "Lista de productos no encontrada (está vacía)")
    })
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductosOrdenados(){

        List<Producto> productoList = this.manager.listarProductosOrdenados();
        GenericEntity<List<Producto>> entity = new GenericEntity<List<Producto>>(productoList) {};

        if(productoList.size() > 0)
            return Response.status(201).entity(entity).build();
        return Response.status(404).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get all Productos ordenados vendas", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "Lista de productos no encontrada (está vacía)")
    })
    @Path("/getVendas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductosVendas(){

        List<Producto> productoList = this.manager.listarProductosVendas();
        GenericEntity<List<Producto>> entity = new GenericEntity<List<Producto>>(productoList) {};

        if(productoList.size() > 0)
            return Response.status(201).entity(entity).build();
        else
            return Response.status(404).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get listar pedidos cliente", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Pedido.class,responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listadoPedidosCliente(@PathParam("id") String id) {
        List<Pedido> pedidoList = this.manager.listadoPedidosCliente(id);
        GenericEntity<List<Pedido>> entity = new GenericEntity<List<Pedido>>(pedidoList) {};
        if (pedidoList.size()==0) return Response.status(404).build();
        else  return Response.status(201).entity(entity).build();
    }
    @POST
    @ApiOperation(value = "realizar Pedido", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response realizarPedido(PedidoCRUD pedidoCRUD) {
        Pedido pedido =new Pedido(this.manager.buscarCliente(pedidoCRUD.getCliente()));
        if (pedido.getCliente()==null)  return Response.status(500).build();
        this.manager.realizarPedido(pedido);
        return Response.status(201).build();
    }


}