package org.estevao.cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
public class Cliente extends PanacheEntity {

    public String nome;

}
