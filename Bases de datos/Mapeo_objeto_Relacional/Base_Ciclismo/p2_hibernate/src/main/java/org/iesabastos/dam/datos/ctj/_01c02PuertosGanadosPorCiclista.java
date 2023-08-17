package org.iesabastos.dam.datos.ctj;

import java.util.Scanner;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.iesabastos.dam.datos.ctj.Pojos.Ciclista;
//que, dado el dorsal de un ciclista
//introducido por el usuario, muestre el nombre, la altura y la categoría de los
//puertos ganados por dicho ciclista.
public class _01c02PuertosGanadosPorCiclista {
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
             for (int i = 0; ciclista.getPuertos().size()> i; i++) {
                    System.out.println("LLevando ese dorsal el ciclista: "+ ciclista.getNombre()+" ha ganado el puero: " + ciclista.getPuertos().get(i).getNompuerto()+
                    " con una altura de : "+ciclista.getPuertos().get(i).getAltura()+
                    " en la categoria: "+ ciclista.getPuertos().get(i).getCategoria()
                    );
                }
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
