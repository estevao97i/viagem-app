package org.estevao.reserva;

import org.estevao.cliente.Cliente;

public class Reserva {

    private long idCliente;

    private Reserva(long id, long idCliente) {
        this.idCliente = idCliente;
    }

    public Reserva() {}

    public static Reserva of(long id, long idCliente) {
        return new Reserva(id, idCliente);
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
}
