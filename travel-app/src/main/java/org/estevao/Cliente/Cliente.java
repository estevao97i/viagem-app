package org.estevao.Cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.ws.rs.Path;

@Entity
public class Cliente extends PanacheEntity {

    public String nome;
}
