package org.estevao.cliente;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientes")
public class ClienteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll() {
        return Response.ok(Cliente.listAll()).build();
    }

    @GET
    @Path("find-by-id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@QueryParam("id") long id) {
        return Response.ok(Cliente.findById(id)).build();
    }

    @DELETE
    @Transactional
    @Path("delete-by-id")
    public Response deleteById(@QueryParam("id") long id) {
        Cliente.deleteById(id);

        return Response.noContent().build();
    }

    @POST
    @Transactional
    @Path("create-cliente")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewCliente(Cliente cliente) {
        cliente.id = null;
        cliente.persist();

        // fazer requisição pelo terminal:
//                                curl -d '{"nome": "agata"}' -H "Content-Type: application/json" http://localhost:8090/clientes

        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }
}
