package org.estevao.reserva;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.estevao.cliente.Cliente;
import org.estevao.cliente.ClienteService;

@Path("/reserva-cli")
public class ReservaResource {

    @Inject
    @RestClient
    ReservaService service;

    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String newReserva() {
        Cliente cliente = clienteService.findById(1L);
        Reserva reserva = Reserva.of(0, cliente);
        String response = service.newReserva(reserva);
        return response;
    }
}
