package org.estevao.cliente;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8090/clientes")
public interface ClienteService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String newCliente(Cliente cliente);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findById")
    public Cliente findById(@QueryParam("id") long id);
}
