package org.iesabastos.dam.datos.ggm;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _08_ConsultasHQL {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();

            Query q;
            // 8.1. La información de cada departamento
            q = sesion.createQuery("from Departamento");

            Iterator iter = q.iterate();

            System.out.println("La información de cada departamento");
            while (iter.hasNext()) {
                Departamento d = (Departamento) iter.next();
                System.out.println(d);
            }

            // 8.2. El nombre de los departamentos
            q = sesion.createQuery("Select nombre from Departamento");

            iter = q.iterate();

            System.out.println("El nombre de los departamentos");
            while (iter.hasNext()) {
                String nombre = (String) iter.next();
                System.out.println(nombre);
            }

            // 8.3. El nombre y localización de los departamentos.
            q = sesion.createQuery("Select nombre, loc from Departamento");

            List<Object[]> lista = q.list();

            System.out.println("Nombre\t\tLocalizacion");
            System.out.println("******\t\t************");
            for (Object[] resultado : lista) {
                String nombre = (String) resultado[0];
                String localizacion = (String) resultado[1];
                System.out.println(nombre + "\t\t" + localizacion);
            }

            // 8.4. Los empleados dados de alta en 2016.
            q = sesion.createQuery("from Empleado where fechaAlta like '2016%'");

            iter = q.iterate();

            System.out.println("Los empleados dados de alta en 2016");
            while (iter.hasNext()) {
                Empleado e = (Empleado) iter.next();
                System.out.println(e);
            }

            // 8.5. El nombre de los empleados del departamento de Informática.
            q = sesion.createQuery(
                    "select e.nombre from Empleado as e, Departamento as d where d.id=e.departamento and d.nombre = 'INFORMATICA'");

            iter = q.iterate();

            System.out.println("El nombre de los empleados del departamento de Informática");
            while (iter.hasNext()) {
                String nombre = (String) iter.next();
                System.out.println(nombre);
            }

            // 8.6. ¿Cuántos departamentos hay en el instituto?
            q = sesion.createQuery(
                    "select count(*) from Departamento");

            Long num = (Long) q.uniqueResult();

            System.out.println("¿Cuántos departamentos hay en el instituto?");

            System.out.println(num);

            // 8.7. Cuántos empleados tenemos en cada departamento (de aquellos
            // departamentos que tienen empleados)
            q = sesion.createQuery(
                    "Select d.nombre, count(*) from Departamento as d, Empleado as e where d.id = e.departamento group by e.departamento");

            lista = q.list();

            System.out.println("Nombre\t\tNumero Empleados");
            System.out.println("******\t\t****************");
            for (Object[] resultado : lista) {
                String nombre = (String) resultado[0];
                Long numero = (Long) resultado[1];
                System.out.println(nombre + "\t\t" + numero);
            }

            // 8.8. Los departamentos que no tienen empleados.
            q = sesion.createQuery(
                    "select d.nombre from Departamento as d where d.id not in (select e.departamento from Empleado as e)");

            iter = q.iterate();

            System.out.println("Los departamentos que no tienen empleados");
            while (iter.hasNext()) {
                String nombre = (String) iter.next();
                System.out.println(nombre);
            }

            // 8.9. Los departamentos que no tienen ningún empleado que se llame Cristina.

            q = sesion.createQuery(
                    "select d.nombre from Departamento as d where d.id not in (select e.departamento from Empleado as e where e.nombre like '%Cristina%'')");

            iter = q.iterate();

            System.out.println("Los departamentos que no tienen ningún empleado que se llame Cristina");
            while (iter.hasNext()) {
                String nombre = (String) iter.next();
                System.out.println(nombre);
            }

            sesion.close();
            System.out.println("Fin!");
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Excepcion!");
        }
    }
}
