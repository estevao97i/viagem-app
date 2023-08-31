package org.estevao.reserva;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.estevao.cliente.Cliente;

@Path("/reserva-cli")
public class ReservaResource {

    @Inject
    @RestClient
    ReservaService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String newReserva() {
        Cliente cliente = Cliente.of(1, "");
        String response = service.newReserva(cliente);
        return response;
    }
}
