package org.iesabastos.dam.datos.ctj;

import java.util.Scanner;
import java.util.ArrayList;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Pojos.Equipo;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
public class _01b02CiclistasDeEquipo {
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Dime un nombre de equipo");
            String buscaEquipo = scanner.nextLine();

            HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();

            Session session = HibernateUtils.getCurrentSession();

            session.beginTransaction();

            Query query = session.createQuery("from Equipo where nomeq=:buscaEquipo");
            query.setParameter("buscaEquipo", buscaEquipo);

            Equipo equipo = (Equipo) query.uniqueResult();

            if (equipo != null) {
                for(int i = 0; equipo.getCiclistas().size()>i; i++){
                    System.out.println(equipo.getCiclistas().get(i).getNombre() );
                }
            } else {
                System.out.println("No se encontró el equipo");
            }

            session.getTransaction().commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Excepción!");
        }
    }
}
/*
 

public class _01b02CiclistasDeEquipo {
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Dime un nombre de equipo");
            String buscaEquipo = scanner.nextLine();

            HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();

            Session session = HibernateUtils.getCurrentSession();

            session.beginTransaction();

            Query query = session.createQuery("from Equipo where nomeq=:buscaEquipo");
            query.setParameter("buscaEquipo", buscaEquipo);

            Equipo equipo = (Equipo) query.uniqueResult();

            if (equipo != null) {
                System.out.println(equipo.getCiclistas());
            } else {
                System.out.println("No se encontró el equipo");
            }

            session.getTransaction().commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Excepción!");
        }
    }
}
 */

