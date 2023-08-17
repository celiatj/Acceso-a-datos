package org.iesabastos.dam.datos.ggm;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _02_InsertaProfesorNuevoDep {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();

            Departamento d = new Departamento();
            d.setId((byte) 60);
            d.setNombre("INGLÉS");
            d.setLoc("DESPA13");

            Empleado e = new Empleado();
            e.setId((short) 8);
            e.setNombre("Juan Garcia");
            e.setFechaAlta(new Date());
            e.setOficio("Profesor");
            e.setComision((float) 500);
            e.setSalario((float) 1000);
            e.setDepartamento(d);

            sesion.save(d);
            sesion.save(e);

            sesion.getTransaction().commit();
            sesion.close();
            System.out.println("Fin!");
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Excepcion!");
        }
    }
}
