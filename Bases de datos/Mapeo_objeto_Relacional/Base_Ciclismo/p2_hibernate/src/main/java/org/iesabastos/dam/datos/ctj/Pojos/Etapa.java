package org.iesabastos.dam.datos.ctj.Pojos;


import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
@Table(name = "etapa") 
public class Etapa implements Serializable{
    @Id
    private Short netapa;
    private Short km;
    private String salida;
    private String llegada;
    

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dorsal")
    private Ciclista ciclista ;

    @OneToMany(mappedBy = "etapa", cascade = CascadeType.ALL)
    private List <Puerto> puertos = new ArrayList<Puerto>();

    public Etapa() {
    }

    public Etapa(Short netapa, Short km, String salida, String llegada, Ciclista ciclista, List<Puerto> puertos) {
        this.netapa = netapa;
        this.km = km;
        this.salida = salida;
        this.llegada = llegada;
        this.ciclista = ciclista;
        this.puertos = puertos;
    }

    public Short getNetapa() {
        return this.netapa;
    }

    public void setNetapa(Short netapa) {
        this.netapa = netapa;
    }

    public Short getKm() {
        return this.km;
    }

    public void setKm(Short km) {
        this.km = km;
    }

    public String getSalida() {
        return this.salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getLlegada() {
        return this.llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public Ciclista getCiclista() {
        return this.ciclista;
    }

    public void setCiclista(Ciclista ciclista) {
        this.ciclista = ciclista;
    }

    public List<Puerto> getPuerto() {
        return this.puertos;
    }

    public void setPuerto(List<Puerto> puertos) {
        this.puertos = puertos;
    }

    public Etapa netapa(Short netapa) {
        setNetapa(netapa);
        return this;
    }

    public Etapa km(Short km) {
        setKm(km);
        return this;
    }

    public Etapa salida(String salida) {
        setSalida(salida);
        return this;
    }

    public Etapa llegada(String llegada) {
        setLlegada(llegada);
        return this;
    }

    public Etapa ciclista(Ciclista ciclista) {
        setCiclista(ciclista);
        return this;
    }

    public Etapa puerto(List<Puerto> puertos) {
        setPuerto(puertos);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " netapa='" + getNetapa() + "'" +
            ", km='" + getKm() + "'" +
            ", salida='" + getSalida() + "'" +
            ", llegada='" + getLlegada() + "'" +
            ", ciclista='" + getCiclista() + "'" +
            ", puerto='" + getPuerto() + "'" +
            "}";
    }

}


