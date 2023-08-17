package org.iesabastos.dam.datos.ggm;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _04_ListadoDep {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();

            // Cargamos el departamento 10
            Departamento d = (Departamento) sesion.get(Departamento.class, (byte) 10);

            if (d != null) {
                for (Empleado e : d.getEmpleados()) {
                    System.out.println(e);
                }
            } else {
                System.out.println("El departamento no existe");
            }

            sesion.close();
            System.out.println("Fin!");
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Excepcion!");
        }
    }
}
