package org.iesabastos.dam.datos.ggm;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @Column(name = "emp_no")
    private short id;
    private String nombre;
    private String oficio;
    @Column(name = "fecha_alta")
    private Date fechaAlta;
    private float salario;
    private float comision;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_no")
    private Departamento departamento;

    public Empleado() {
    }

    public Empleado(short id, String nombre, String oficio, Date fechaAlta, float salario, float comision,
            Departamento departamento) {
        this.id = id;
        this.nombre = nombre;
        this.oficio = oficio;
        this.fechaAlta = fechaAlta;
        this.salario = salario;
        this.comision = comision;
        this.departamento = departamento;
    }

    public short getId() {
        return this.id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOficio() {
        return this.oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Date getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return this.comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Empleado id(short id) {
        setId(id);
        return this;
    }

    public Empleado nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Empleado oficio(String oficio) {
        setOficio(oficio);
        return this;
    }

    public Empleado fechaAlta(Date fechaAlta) {
        setFechaAlta(fechaAlta);
        return this;
    }

    public Empleado salario(float salario) {
        setSalario(salario);
        return this;
    }

    public Empleado comision(float comision) {
        setComision(comision);
        return this;
    }

    public Empleado departamento(Departamento departamento) {
        setDepartamento(departamento);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", oficio='" + getOficio() + "'" +
                ", fechaAlta='" + getFechaAlta() + "'" +
                ", salario='" + getSalario() + "'" +
                ", comision='" + getComision() + "'" +
                ", departamento='" + getDepartamento().getId() + "'" +
                "}";
    }

}
