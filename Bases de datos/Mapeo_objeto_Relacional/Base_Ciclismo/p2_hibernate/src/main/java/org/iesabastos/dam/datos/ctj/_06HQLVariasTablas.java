package org.iesabastos.dam.datos.ctj;

import java.util.List;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;
import org.hibernate.Query;

public class _06HQLVariasTablas {

    public static void main(String[] args) {
        // Crear sesión factory
        
         HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();
            Session session = HibernateUtils.getCurrentSession();
            session.beginTransaction();

        // Consulta a)
        Query queryA = session.createQuery("SELECT e.nombre, e.ciudadSalida, e.ciudadLlegada, c.nombre "
                                          + "FROM Etapa e JOIN e.ciclistaGanador c");
        List<Object[]> resultadosA = queryA.list();

        // Mostrar resultados de la consulta a)
        for (Object[] resultado : resultadosA) {
            System.out.println("Nombre de la etapa: " + resultado[0]);
            System.out.println("Ciudad de salida: " + resultado[1]);
            System.out.println("Ciudad de llegada: " + resultado[2]);
            System.out.println("Nombre del ciclista ganador: " + resultado[3]);
            System.out.println("---");
        }

        // Consulta b)
        Query queryB = session.createQuery("SELECT e.nomeq, e.director, size(e.ciclistas) "
                                          + "FROM Equipo e");
        List<Object[]> resultadosB = queryB.list();

        // Mostrar resultados de la consulta b)
        for (Object[] resultado : resultadosB) {
            System.out.println("Nombre del equipo: " + resultado[0]);
            System.out.println("Director: " + resultado[1]);
            System.out.println("Número de ciclistas: " + resultado[2]);
            System.out.println("---");
        }

        // Cerrar la sesión de Hibernate
        session.getTransaction().commit();
        session.close();
        
    }
}

// dicen en algunos foros que añadiendo esta  linea a hibernate.cfg --> https://stackoverflow.com/questions/57880036/javassist-enhancement-failed-unable-to-make-protected-final-java-lang-clas
// se soluciona un fallo pero me da mas fallos.