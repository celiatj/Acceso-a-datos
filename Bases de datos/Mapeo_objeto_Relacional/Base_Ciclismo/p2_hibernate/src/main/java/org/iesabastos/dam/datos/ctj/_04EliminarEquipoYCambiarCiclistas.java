package org.iesabastos.dam.datos.ctj;
import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ctj.Pojos.Ciclista;
import org.iesabastos.dam.datos.ctj.Pojos.Equipo;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;

import java.util.Scanner;

public class _04EliminarEquipoYCambiarCiclistas {
    public static void main(String[] args) {

         HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();
            Session session = HibernateUtils.getCurrentSession();
            session.beginTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del equipo a eliminar: ");
        String equipoEliminado = sc.nextLine();

        System.out.print("Introduce el nombre del equipo al que quieres transferir a los ciclistas: ");
        String cambiarEquipo = sc.nextLine();

        try {

            Query query = session.createQuery("from Equipo where nomeq=:equipoEliminado");
                     query.setParameter("equipoEliminado", equipoEliminado);
            Equipo equipoEl =(Equipo) query.uniqueResult();

          
           Query query2 = session.createQuery("from Equipo where nomeq=:cambiarEquipo");
                    query2.setParameter("cambiarEquipo", cambiarEquipo);
                    Equipo EquipoCamb =(Equipo) query2.uniqueResult();

            if (equipoEl == null) {
                System.out.println("Equipo no encontrado");
                return;
            }

            if (EquipoCamb == null) {
                System.out.println("Equipo para cambiar no encontrado.");
                return;
            }

            for (Ciclista ciclista: equipoEl.getCiclistas()) {
                ciclista.setEquipo(EquipoCamb);
                session.update(ciclista);
            }

            session.delete(equipoEl);
               session.getTransaction().commit();
        } catch (Exception e) {
        
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}