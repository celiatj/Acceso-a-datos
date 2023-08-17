package org.iesabastos.dam.datos.ctj;

import java.util.Scanner;
import java.util.ArrayList;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Pojos.Equipo;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.iesabastos.dam.datos.ctj.Pojos.Ciclista;
import org.iesabastos.dam.datos.ctj.Pojos.Etapa;
public class _01b01GanadorDeEtapa {
     public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Dime un numero de etapa");
            short buscarEtapa = scanner.nextShort();
            HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();

            Session session = HibernateUtils.getCurrentSession();
            session.beginTransaction();

            Query query = session.createQuery("from Etapa where netapa=:buscarEtapa");
            query.setParameter("buscarEtapa", buscarEtapa);
            Etapa etapa = (Etapa)query.uniqueResult();
 

            if (etapa != null) {
                System.out.println(etapa.getCiclista().getNombre());
            } else {
                System.out.println("No encontré un etapa con ese numero");
            }

            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            HibernateUtils.closeSession();
        }
    }
}

        
