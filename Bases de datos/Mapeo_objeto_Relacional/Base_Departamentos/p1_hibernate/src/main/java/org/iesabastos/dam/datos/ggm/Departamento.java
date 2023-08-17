package org.iesabastos.dam.datos.ggm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id
    @Column(name = "dept_no")
    private byte id;
    @Column(name = "dnombre")
    private String nombre;
    private String loc;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Empleado> empleados = new ArrayList<Empleado>();

    public Departamento() {
    }

    public Departamento(byte id, String nombre, String loc, List<Empleado> empleados) {
        this.id = id;
        this.nombre = nombre;
        this.loc = loc;
        this.empleados = empleados;
    }

    public byte getId() {
        return this.id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLoc() {
        return this.loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Departamento id(byte id) {
        setId(id);
        return this;
    }

    public Departamento nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Departamento loc(String loc) {
        setLoc(loc);
        return this;
    }

    public Departamento empleados(List<Empleado> empleados) {
        setEmpleados(empleados);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", loc='" + getLoc() + "'" +
                ", empleados='" + getEmpleados() + "'" +
                "}";
    }

}
