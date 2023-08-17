package org.iesabastos.dam.datos.ctj;
  import java.util.Scanner;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Pojos.Equipo;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;


public class _02bModificarEquipo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();

        System.out.print("Ingrese el nombre del nuevo director: ");
        String nuevoDirector = scanner.nextLine();
        HibernateUtils.buildSessionFactory();
        HibernateUtils.openSession();
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();

        // Obtener el equipo existente de la base de datos
        Equipo equipo = (Equipo) session.get(Equipo.class, nombreEquipo);

        if (equipo != null) {
            // Modificar los datos del equipo
            equipo.setDirector(nuevoDirector);

            // Actualizar el equipo en la base de datos
            session.update(equipo);

            // Commitea la transacción
            session.getTransaction().commit();

            System.out.println("Equipo modificado: " + equipo);

            session.close();
        }
    }
}

