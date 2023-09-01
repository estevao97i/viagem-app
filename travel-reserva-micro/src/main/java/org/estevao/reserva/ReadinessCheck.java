package org.estevao.reserva;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        if (Reserva.listAll() == null) {
            return HealthCheckResponse.down("NOT READY YET RESERVA");
        }
        return HealthCheckResponse.up("Ready Reserva");
    }
}
