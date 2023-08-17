package org.iesabastos.dam.datos.ctj;
/*dado un nombre de equipo introducido por el usuario, muestre el nombre los
*/
import java.util.Scanner;
import java.util.ArrayList;
import org.iesabastos.dam.datos.ctj.*;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Pojos.Equipo;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.iesabastos.dam.datos.ctj.Pojos.Ciclista;


public class _01b01DirectorDelCiclista {

    public static void main(String[] args) {

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

            if (ciclista != null) {
                System.out.println(ciclista.getEquipo().getDirector());
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


           /*  Scanner scanner = new Scanner(System.in);
            System.out.println("Dime un nombre de equipo");
            String buscaEquipo = scanner.nextLine();

            HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();

            Session sesion = HibernateUtils.getCurrentSession();
            sesion.beginTransaction();

            List<Equipo> equipos = sesion.createQuery("from Equipo").list();

            for (int i = 0; i < equipos.size(); i++) {
                if (equipos.get(i).getNomeq().equals(buscaEquipo)) {
                    System.out.println(equipos.get(i).getCiclistas().toString());
                }
            }

            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }*/
