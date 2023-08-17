package org.iesabastos.dam.datos.ggm;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _11_MasAntiguo {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();

            System.out.println("Conseguir los datos con parametros numéricos");
            Query empleadosAntiguos = sesion.createQuery("from Empleado order by fechaAlta asc");
            empleadosAntiguos.setFetchSize(5);

            Iterator iter = empleadosAntiguos.iterate();
            Empleado emp;
            int i = 1, dept_No;

            if (iter.hasNext()) {
                emp = (Empleado) iter.next();
                System.out.println("\n" + i + ": " + emp.getId() + " " + emp.getNombre());
                i++;
                dept_No = emp.getDepartamento().getId();

                Iterator iter2 = empleadosAntiguos.iterate();
                if (iter2.hasNext()) {
                    System.out.println("Compañeros del departamento " + dept_No);

                    List<Empleado> listaCompis = emp.getDepartamento().getEmpleados();

                    try {
                        for (Empleado aux : listaCompis) {
                            System.out.println(aux);
                        }
                    } catch (Exception e) {
                        System.out.println("Se ha terminado de recorrer");
                    }

                } else {
                    System.out.println("No tiene compañeros de departamento");
                }
            } else {
                System.out.println("no existe ningun empleado");
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
