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
public class _01b02EtapasGanadasPorCiclista {
    public static void main(String[] args) {

        //muestre la ciudad de salida y de llegada de las
//etapas ganadas por dicho ciclista.
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Dime un dorsal");
            short buscarDorsal = scanner.nextShort();

            HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();

            Session session = HibernateUtils.getCurrentSession();
            session.beginTransaction();

            Query query = session.createQuery("from Ciclista where dorsal=:buscarDorsal");
            query.setParameter("buscarDorsal", buscarDorsal);
            Ciclista ciclista = (Ciclista) query.uniqueResult();
            int contador = 0;
            if (ciclista != null) {
                
                for (int i = 0; ciclista.getEtapas().size() > i; i++) {
                    System.out.println("el dorsal ha ganado en la salida: " + ciclista.getEtapas().get(i).getSalida());
                    contador++;
                }
                System.out.println("Un toral de: "+contador+" etapas ganadas");
            } else {
                System.out.println("No encontré un ciclista con ese dorsal");
            }

            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            HibernateUtils.closeSession();
        }
    }

}

