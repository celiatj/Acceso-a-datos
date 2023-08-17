package org.iesabastos.dam.datos.ggm;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _03_InsertaEmpleado {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();

            // Cargamos el departamento 10
            Departamento d = (Departamento) sesion.load(Departamento.class, (byte) 10);

            // Creamos un nuevo empleado
            Empleado e = new Empleado();
            e.setId((short) 9);
            e.setNombre("Rafa Perez");
            e.setFechaAlta(new GregorianCalendar(2023, Calendar.JANUARY, 11).getTime());
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
