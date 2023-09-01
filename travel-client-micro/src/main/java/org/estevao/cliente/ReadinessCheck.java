package org.estevao.cliente;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        if (Cliente.listAll() == null) {
            return HealthCheckResponse.down("Not ready yet");
        } else {
            return HealthCheckResponse.up("Ready Call Cliente");
        }
    }
}
