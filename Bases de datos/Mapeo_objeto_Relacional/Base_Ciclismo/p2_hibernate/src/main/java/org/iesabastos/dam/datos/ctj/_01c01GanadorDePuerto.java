package org.iesabastos.dam.datos.ctj;

import java.util.Scanner;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.iesabastos.dam.datos.ctj.Pojos.Puerto;
public class _01c01GanadorDePuerto {
    //un nombre de puerto introducido por el usuario, muestre el nombre del
//ciclista ganador de dicho puerto.
     public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Dime un nombre de puerto");
            String buscarPuerto = scanner.nextLine();

            HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();

            Session session = HibernateUtils.getCurrentSession();
            session.beginTransaction();

            Query query = session.createQuery("from Puerto where nompuerto=:buscarPuerto");
            query.setParameter("buscarPuerto", buscarPuerto);
            Puerto puerto = (Puerto) query.uniqueResult();
            
            if (puerto!= null) {
                System.out.println(puerto.getCiclista().getNombre()+ " ha ganado el puerto");
            } else {
                System.out.println("No encontré un puerto con ese nombre");
            }

            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            HibernateUtils.closeSession();
        }
    }

}

