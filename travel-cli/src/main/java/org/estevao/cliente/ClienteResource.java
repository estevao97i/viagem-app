package org.estevao.cliente;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.temporal.ChronoUnit;

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

    @GET
    @Path("findById") // caminho da requisição
    @Produces(MediaType.APPLICATION_JSON) // requisição Produz um JSON
    @Timeout(unit = ChronoUnit.SECONDS, value = 3) // caso não responder em 3 segundos ele crasha
    @Fallback(fallbackMethod = "fallback") // metodo que retorna uma função standard definida no escopo dessa classe - fallback() -tem que ter a mesma assinatura do metodo abaixo
    @CircuitBreaker(
            requestVolumeThreshold = 4, // faz 4 requisições
            failureRatio = 0.5, // porcentagem do quanto ele vai tolerar de requisições quebrando
            delay = 6000, // depois do circuito aberto ele vai esperar 6 segundos e vai tentar fechar novamente
            successThreshold = 1 // se uma requisição voltar corretamente no tempo certo ele fechar o circuito novamente
    )
    public Cliente findById(@QueryParam("id") long id) {
        return service.findById(id);
    }

    private Cliente fallback(long id) {
        return Cliente.of(0, "");
    }


}
