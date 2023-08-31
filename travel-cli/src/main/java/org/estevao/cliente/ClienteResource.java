package org.estevao.cliente;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/cliente-cli")
public class ClienteResource {

    @Inject
    @RestClient
    ClienteService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String newCliente() {
        Cliente cliente = Cliente.of(99, "Ana Clara");
        String response = service.newCliente(cliente);
        return response;
    }


}
