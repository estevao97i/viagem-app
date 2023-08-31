package org.estevao.reserva;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import org.estevao.cliente.Cliente;

@Entity
public class Reserva extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    public Cliente cliente;
}
