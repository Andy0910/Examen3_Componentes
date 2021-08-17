package com.cenfotec.sucondofeliz.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Historial implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Date fecha;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Condominio condominio;

    @Column(nullable = false)
    private double cuota;

    public Historial() {
    }

    public Historial(long id, Date fecha, Condominio condominio, double cuota) {
        this.id = id;
        this.fecha = fecha;
        this.condominio = condominio;
        this.cuota = cuota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }
}
