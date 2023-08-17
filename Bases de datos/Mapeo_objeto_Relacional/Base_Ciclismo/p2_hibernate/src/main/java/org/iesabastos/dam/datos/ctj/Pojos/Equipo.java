package org.iesabastos.dam.datos.ctj.Pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {
    @Id
    private String nomeq;

    private String director;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Ciclista> ciclistas = new ArrayList<Ciclista>();

    public Equipo() {
    }

    public Equipo(String nomeq, String director, List<Ciclista> ciclistas) {
        this.nomeq = nomeq;
        this.director = director;
        this.ciclistas = ciclistas;
    }

    public String getNomeq() {
        return this.nomeq;
    }

    public void setNomeq(String nomeq) {
        this.nomeq = nomeq;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Ciclista> getCiclistas() {
        return this.ciclistas;
    }

    public void setCiclistas(List<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    public Equipo nomeq(String nomeq) {
        setNomeq(nomeq);
        return this;
    }

    public Equipo director(String director) {
        setDirector(director);
        return this;
    }

    public Equipo ciclistas(List<Ciclista> ciclistas) {
        setCiclistas(ciclistas);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " nomeq='" + getNomeq() + "'" +
            ", director='" + getDirector() + "'" +
            ", ciclistas='" + getCiclistas() + "'" +
            "}";
    }

}