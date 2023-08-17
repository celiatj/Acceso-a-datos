package org.iesabastos.dam.datos.ggm;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _09_QueryDep {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();
            // Obtengo la lista de departamentos mediante HQL y me la guardo en un objeto
            // Query
            Query q = sesion.createQuery("from Departamento");

            q.setFetchSize(20);

            // Declaro objeto Iterator para poder recorrer toda la lista de departamentos
            // (lista de registros)
            Iterator iter = q.iterate();
            Departamento dep;
            int i = 1;

            System.out.println("Conseguir los datos y recorrerlos con iterate()");
            while (iter.hasNext()) {
                // Convierto el registro a un objeto Departamento
                dep = (Departamento) iter.next();
                System.out.println("\n" + i + ": " + dep.getId() + " " + dep.getNombre());
                i++;
            }

            // Obtengo la lista de departamentos mediante HQL y me la guardo en un objeto
            // Query
            q = sesion.createQuery("from Departamento");

            q.setFetchSize(1);

            // Guardo todos los registros en una lista de Departamentos
            List<Departamento> consulta = q.list();
            System.out.println("Conseguir los datos de todos los departamentos y recorrerlos con list()");
            i = 1;

            // Recorro la lista de departamentos mediante un bucle foreach
            for (Departamento dept : consulta) {
                System.out.println("\n" + i + ": " + dept.getId() + " " + dept.getNombre());
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
