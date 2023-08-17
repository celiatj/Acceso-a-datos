package org.iesabastos.dam.datos.ggm;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _06_BorraEmpleado {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();

            Empleado emp = (Empleado) sesion.get(Empleado.class, (short) 1);

            sesion.delete(emp);

            sesion.getTransaction().rollback();

            sesion.close();
            System.out.println("Se ha hecho un rollback, por lo que los cambios no se han guardado");
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Excepcion!");
        }
    }
}
