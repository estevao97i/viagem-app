package org.estevao.reserva;

import org.estevao.cliente.Cliente;

public class Reserva {

    private Cliente cliente;

    private Reserva(long id, Cliente cliente) {
        this.cliente = cliente;
    }

    public static Reserva of(long id, Cliente cliente) {
        return new Reserva(id, cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
