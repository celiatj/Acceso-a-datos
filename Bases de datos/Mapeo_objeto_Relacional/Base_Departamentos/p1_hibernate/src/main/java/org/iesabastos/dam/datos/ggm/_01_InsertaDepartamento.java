package org.iesabastos.dam.datos.ggm;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _01_InsertaDepartamento {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();

            Departamento d = new Departamento();
            d.setId((byte) 50);
            d.setNombre("LENGUA");
            d.setLoc("DESPA3");

            sesion.save(d);

            sesion.getTransaction().commit();
            sesion.close();
            System.out.println("Fin!");
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Excepcion!");
        }
    }
}
