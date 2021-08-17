package com.cenfotec.sucondofeliz.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessorOrder;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Amenidades implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String descripcion;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Condominio condominio;

    public Amenidades() {
    }

    public Amenidades(long id, String descripcion, Condominio condominio) {
        this.id = id;
        this.descripcion = descripcion;
        this.condominio = condominio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
