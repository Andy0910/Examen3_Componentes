package com.cenfotec.sucondofeliz.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Condomino implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String cedula;

    @OneToOne
    @JoinColumn
    private Condominio condominio;


    @Column(nullable = false)
    private String estado;


    public Condomino(long id, String nombre, String cedula, Condominio condominio, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.condominio = condominio;
        this.estado = estado;
    }

    public Condomino() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
