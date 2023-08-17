package org.iesabastos.dam.datos.ctj.Pojos;


import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "puerto") 
public class Puerto implements Serializable{
    @Id
    private String nompuerto;
    private Short altura;
    private String categoria;
    private Double pendiente;
  
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="dorsal")
private Ciclista ciclista;

    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="netapa")
    private Etapa etapa;



    public Puerto() {
    }

    public Puerto(String nompuerto, Short altura, String categoria, Double pendiente, Ciclista ciclista, Etapa etapa) {
        this.nompuerto = nompuerto;
        this.altura = altura;
        this.categoria = categoria;
        this.pendiente = pendiente;
        this.ciclista = ciclista;
        this.etapa = etapa;
    }

    public String getNompuerto() {
        return this.nompuerto;
    }

    public void setNompuerto(String nompuerto) {
        this.nompuerto = nompuerto;
    }

    public Short getAltura() {
        return this.altura;
    }

    public void setAltura(Short altura) {
        this.altura = altura;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPendiente() {
        return this.pendiente;
    }

    public void setPendiente(Double pendiente) {
        this.pendiente = pendiente;
    }

    public Ciclista getCiclista() {
        return this.ciclista;
    }

    public void setCiclista(Ciclista ciclista) {
        this.ciclista = ciclista;
    }

    public Etapa getEtapa() {
        return this.etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Puerto nompuerto(String nompuerto) {
        setNompuerto(nompuerto);
        return this;
    }

    public Puerto altura(Short altura) {
        setAltura(altura);
        return this;
    }

    public Puerto categoria(String categoria) {
        setCategoria(categoria);
        return this;
    }

    public Puerto pendiente(Double pendiente) {
        setPendiente(pendiente);
        return this;
    }

    public Puerto ciclista(Ciclista ciclista) {
        setCiclista(ciclista);
        return this;
    }

    public Puerto etapa(Etapa etapa) {
        setEtapa(etapa);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " nompuerto='" + getNompuerto() + "'" +
            ", altura='" + getAltura() + "'" +
            ", categoria='" + getCategoria() + "'" +
            ", pendiente='" + getPendiente() + "'" +
            ", ciclista='" + getCiclista() + "'" +
            ", etapa='" + getEtapa() + "'" +
            "}";
    }

}

