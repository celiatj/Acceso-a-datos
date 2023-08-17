package org.iesabastos.dam.datos.ctj;
 import java.util.Scanner;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Pojos.Ciclista;
import org.iesabastos.dam.datos.ctj.Pojos.Equipo;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;


public class _02cCambiarDeEquipo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
Scanner sca = new Scanner(System.in);
         HibernateUtils.buildSessionFactory();
        HibernateUtils.openSession();
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();

        System.out.println("Introduce el dorsal del ciclista:");
        Short dorsal = sca.nextShort();
        System.out.println("Introduce el nombre del equipo:");
        String nombreEquipo = sc.nextLine();

        Ciclista ciclista = (Ciclista) session.get(Ciclista.class, dorsal);
        if (ciclista == null) {
            System.out.println("El ciclista con dorsal " + dorsal + " no existe.");
            return;
        }

        Equipo equipo = (Equipo) session.createQuery("FROM Equipo WHERE nomeq = '" + nombreEquipo + "'").uniqueResult();
        if (equipo == null) {
            System.out.println("El equipo con nombre " + nombreEquipo + " no existe.");
            return;
        }

        if (ciclista.getEquipo().getNomeq().equals(nombreEquipo)) {
            System.out.println("El ciclista ya pertenece al equipo " + nombreEquipo + ".");
            return;
        }

        session.getTransaction().commit();
        ciclista.setEquipo(equipo);
        session.update(ciclista);
         session.close();
        System.out.println("El ciclista con dorsal " + dorsal + " ha sido transferido al equipo " + nombreEquipo + ".");
    }
}
   