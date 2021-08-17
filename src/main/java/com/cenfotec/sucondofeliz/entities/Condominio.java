package com.cenfotec.sucondofeliz.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Condominio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String cedulaJuridica;

    @Column(nullable = false)
    private String representante;

    @Column(nullable = false)
    private int cantidadUnidades;

    @Column(nullable = false)
    private double cuota;

    @Column(nullable = false)
    private boolean estado;

    public Condominio() {
    }

    public Condominio(long id, String nombre, String direccion, String cedulaJuridica, String representante, int cantidadUnidades, double cuota, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedulaJuridica = cedulaJuridica;
        this.representante = representante;
        this.cantidadUnidades = cantidadUnidades;
        this.cuota = cuota;
        this.estado = estado;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}



