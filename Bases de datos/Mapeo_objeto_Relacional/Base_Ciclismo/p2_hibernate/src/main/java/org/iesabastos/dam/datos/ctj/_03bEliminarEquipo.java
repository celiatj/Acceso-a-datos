package org.iesabastos.dam.datos.ctj;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;
import org.iesabastos.dam.datos.ctj.Pojos.Equipo;
import java.util.Scanner;

public class _03bEliminarEquipo {
    public static void main(String[] args) {

         HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();
            Session session = HibernateUtils.getCurrentSession();
            session.beginTransaction();

        Scanner sc = new Scanner(System.in);
       
        try {
            System.out.print("Introduce el nombre del equipo a eliminar: ");
            String nomeq = sc.nextLine();

            Equipo equipo = (Equipo) session.get(Equipo.class, nomeq);
            if (equipo != null) {
                session.delete(equipo);
            
            session.getTransaction().commit();
                System.out.println("Equipo y ciclistas eliminados correctamente.");
            } else {
                System.out.println("El equipo no existe.");
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
