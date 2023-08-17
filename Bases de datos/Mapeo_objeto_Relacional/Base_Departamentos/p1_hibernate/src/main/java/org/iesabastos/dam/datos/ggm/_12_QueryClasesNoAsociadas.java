package org.iesabastos.dam.datos.ggm;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _12_QueryClasesNoAsociadas {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();

            Query q = sesion.createQuery("from Departamento d, Empleado e "
                    + "where d.id=e.departamento.id order by e.nombre");
            System.out.println("Utilizando list()");
            List<Object[]> lista = q.list();

            for (Object[] elto : lista) {
                Departamento dep = (Departamento) elto[0];
                Empleado emp = (Empleado) elto[1];
                System.out.println(dep.getId() + " * " + dep.getNombre() + " * ");
            }

            q = sesion.createQuery("from Departamento d, Empleado e "
                    + "where d.id=e.departamento.id order by e.nombre");

            System.out.println("Utilizando iterate()");

            Iterator iter = q.iterate();
            while (iter.hasNext()) {
                try {
                    Object[] elto = (Object[]) iter.next();

                    Departamento dep = (Departamento) elto[0];
                    Empleado emp = (Empleado) elto[1];
                    if (dep != null & emp != null) {
                        System.out.println(dep.getId() + " * " + dep.getNombre()
                                + " * " + emp.getNombre());
                    }
                } catch (Exception e) {
                    System.out.println("Ha terminado de recorrer");
                    e.printStackTrace();
                }
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
