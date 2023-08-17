
package org.iesabastos.dam.datos.ctj;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Pojos.Ciclista;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;

public class _05HQLBasicas {
    public static void main(String[] args) {
        // Creación de la sesión
         HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();
            Session session = HibernateUtils.getCurrentSession();
            session.beginTransaction();
        
        // Consulta a) Ciclistas nacidos entre el 1/1/1979 y 31/12/1980.
        Query queryA = session.createQuery("FROM Ciclista "
                + "WHERE nacimiento BETWEEN '1979-01-01' AND '1980-12-31'");
        List<Ciclista> ciclistasA = queryA.list();
        System.out.println("Ciclistas nacidos entre 1979 y 1980:");
        for (Ciclista c : ciclistasA) {
            System.out.println(c);
        }
        
        // Consulta b) Número total de ciclistas
        Query queryB = session.createQuery("SELECT COUNT(*) FROM Ciclista");
        int numCiclistas = (int) queryB.uniqueResult();
        System.out.println("Número total de ciclistas: " + numCiclistas);
        
        // Consulta c) Número total de ciclistas del equipo Banesto
        Query queryC = session.createQuery("SELECT COUNT(*) "
                + "FROM Ciclista c "
                + "WHERE c.nomeq = 'Banesto'");
        Long numCiclistasBanesto = (Long) queryC.uniqueResult();
        System.out.println("Número total de ciclistas de Banesto: " + numCiclistasBanesto);
        
        // Finalización de la transacción y cierre de la sesión
         session.getTransaction().commit();
        session.close();
    }
}