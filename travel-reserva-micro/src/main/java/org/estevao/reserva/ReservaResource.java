package org.estevao.reserva;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/reservas")
public class ReservaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll() {
        return Response.ok(Reserva.listAll()).build();
    }

    @GET
    @Path("find-by-id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@QueryParam("id") long id) {
        return Response.ok(Reserva.findById(id)).build();
    }

    @DELETE
    @Transactional
    @Path("delete-by-id")
    public Response deleteById(@QueryParam("id") long id) {
        Reserva.deleteById(id);
        return Response.noContent().build();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewReserva(Reserva reserva) {
        reserva.id = null;
        reserva.persist();

        // fazer requisição pelo terminal:
//                                curl -d '{"id": numero-id}' -H "Content-Type: application/json" http://localhost:8090/reservas

        return Response.status(Response.Status.CREATED).entity(reserva).build();
    }
}
