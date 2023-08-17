package org.iesabastos.dam.datos.ctj;
    import org.hibernate.Session;

import org.iesabastos.dam.datos.ctj.Pojos.Equipo;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;

public class _02aCrearEquipo {
    public static void main(String[] args) {
        
          HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();
            Session session = HibernateUtils.getCurrentSession();
            session.beginTransaction();

        // Crear un nuevo equipo
        Equipo equipo = new Equipo();
        equipo.setNomeq("Equipo A");
        equipo.setDirector("Juan Pérez");

        // Guardar el equipo en la base de datos
        session.save(equipo);

        // Commitea la transacción
        session.getTransaction().commit();

        System.out.println("Equipo creado: " + equipo);

    
            session.close();
    }
}
    

