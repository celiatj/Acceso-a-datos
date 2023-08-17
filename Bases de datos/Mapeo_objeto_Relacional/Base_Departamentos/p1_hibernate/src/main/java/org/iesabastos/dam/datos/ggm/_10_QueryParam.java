package org.iesabastos.dam.datos.ggm;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _10_QueryParam {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();
            System.out.println("Conseguir los datos con parametros nombrados");
            Query q = sesion.createQuery("from Empleado where salario >= :sal");

            q.setInteger("sal", 800);
            q.setFetchSize(5);

            Iterator iter = q.iterate();
            int i = 1;

            while (iter.hasNext()) {
                Empleado emp = (Empleado) iter.next();
                System.out.println("\n" + i + ": " + emp.getId() + " " + emp.getNombre());
                i++;
            }

            sesion.getTransaction().commit();
            sesion.close();
            System.out.println("Fin!");
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Excepcion!");
        }
    }
}
