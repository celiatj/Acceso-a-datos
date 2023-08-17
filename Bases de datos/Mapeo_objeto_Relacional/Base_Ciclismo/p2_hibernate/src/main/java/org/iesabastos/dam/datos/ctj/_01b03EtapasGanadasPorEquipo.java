package org.iesabastos.dam.datos.ctj;
//que, dado un nombre de equipo introducido

//por el usuario, muestre el nombre de sus ciclistasjunto con el número de etapas
//que ha ganado cada uno de ellos.

import java.util.Scanner;
import java.util.ArrayList;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Pojos.Equipo;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.iesabastos.dam.datos.ctj.Pojos.Equipo;


public class _01b03EtapasGanadasPorEquipo {
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
    
            int contador = 0;
            if (equipo != null) {
                for(int i = 0; equipo.getCiclistas().size()>i; i++){
                       for(int j = 0; equipo.getCiclistas().get(i).getEtapas().size()>j; j++){
                    equipo.getCiclistas().get(i).getEtapas().get(j);
                    contador++;
                }
                    System.out.println("El ciclista:"+equipo.getCiclistas().get(i).getNombre()+":ha ganado:"+contador+" etapas");
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

