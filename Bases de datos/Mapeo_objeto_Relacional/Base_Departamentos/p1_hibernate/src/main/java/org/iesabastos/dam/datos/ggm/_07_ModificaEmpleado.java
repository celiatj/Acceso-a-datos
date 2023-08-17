package org.iesabastos.dam.datos.ggm;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _07_ModificaEmpleado {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();

            Empleado e = (Empleado) sesion.get(Empleado.class, (short) 1);
            e.setNombre("Juanito Perez");

            sesion.update(e);

            sesion.getTransaction().commit();

            sesion.close();
            System.out.println("Fin!");
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Excepcion!");
        }
    }
}
