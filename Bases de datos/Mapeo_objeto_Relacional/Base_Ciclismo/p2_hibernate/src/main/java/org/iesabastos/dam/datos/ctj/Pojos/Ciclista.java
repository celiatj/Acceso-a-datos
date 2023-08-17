package org.iesabastos.dam.datos.ctj.Pojos;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
@Table(name = "ciclista")
public class Ciclista implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short dorsal;
    private String nombre;
    private Date nacimiento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nomeq")
    private Equipo equipo;

    @OneToMany(mappedBy = "ciclista", cascade = CascadeType.ALL)
    private List<Etapa> etapas = new ArrayList<Etapa>();

    @OneToMany(mappedBy = "ciclista", cascade = CascadeType.ALL)
    private List<Puerto> puertos = new ArrayList<Puerto>();

    public Ciclista() {
    }

    public Ciclista(short dorsal, String nombre, Date nacimiento, Equipo equipo, List<Etapa> etapas, List<Puerto> puertos) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.equipo = equipo;
        this.etapas = etapas;
        this.puertos = puertos;
    }

    public short getDorsal() {
        return this.dorsal;
    }

    public void setDorsal(short dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getNacimiento() {
        return this.nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Etapa> getEtapas() {
        return this.etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    public List<Puerto> getPuertos() {
        return this.puertos;
    }

    public void setPuertos(List<Puerto> puertos) {
        this.puertos = puertos;
    }

    public Ciclista dorsal(short dorsal) {
        setDorsal(dorsal);
        return this;
    }

    public Ciclista nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Ciclista nacimiento(Date nacimiento) {
        setNacimiento(nacimiento);
        return this;
    }

    public Ciclista equipo(Equipo equipo) {
        setEquipo(equipo);
        return this;
    }

    public Ciclista etapas(List<Etapa> etapas) {
        setEtapas(etapas);
        return this;
    }

    public Ciclista puertos(List<Puerto> puertos) {
        setPuertos(puertos);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " dorsal='" + getDorsal() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", nacimiento='" + getNacimiento() + "'" +
            ", equipo='" + getEquipo() + "'" +
            ", etapas='" + getEtapas() + "'" +
            ", puertos='" + getPuertos() + "'" +
            "}";
    }

}