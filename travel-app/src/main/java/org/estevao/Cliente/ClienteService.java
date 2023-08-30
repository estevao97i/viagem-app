package org.estevao.Cliente;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

public class ClienteService {

    public List<Cliente> listAll() {
        return Cliente.listAll();
    }


}
