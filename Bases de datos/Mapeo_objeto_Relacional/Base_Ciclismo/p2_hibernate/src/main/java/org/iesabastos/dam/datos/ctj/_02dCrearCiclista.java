package org.iesabastos.dam.datos.ctj;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iesabastos.dam.datos.ctj.Pojos.Ciclista;
import org.iesabastos.dam.datos.ctj.Pojos.Equipo;
import org.iesabastos.dam.datos.ctj.Utils.HibernateUtils;

import java.util.Date;
import org.iesabastos.dam.datos.ctj.Pojos.Ciclista;
import org.iesabastos.dam.datos.ctj.Pojos.Equipo;

public class _02dCrearCiclista {
    public static void main(String[] args) {

          HibernateUtils.buildSessionFactory();
            HibernateUtils.openSession();
            Session session = HibernateUtils.getCurrentSession();
            session.beginTransaction();

        Scanner sc = new Scanner(System.in);
        Scanner sca = new Scanner(System.in);

        System.out.println("Introduce el dorsal del ciclista: ");
        Short dorsal = sca.nextShort();
        System.out.println("Introduce el nombre del ciclista: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce la fecha de nacimiento del ciclista (yyyy-mm-dd): ");
        Date fechaNacimiento = java.sql.Date.valueOf(sc.nextLine());
        System.out.println("Introduce el nombre del equipo: ");
        String nombreEquipo = sc.nextLine();

        Ciclista c = (Ciclista) session.get(Ciclista.class, dorsal);

        Equipo e = (Equipo) session.get(Equipo.class, nombreEquipo);
        if (e == null) {
            System.out.println("Error: el equipo no existe");
            
            session.close();
           
            return;
        }
        c = new Ciclista();
        c.setDorsal(dorsal);
        c.setNombre(nombre);
        c.setNacimiento(fechaNacimiento);
        c.setEquipo(e);
        
        session.save(c);
        session.getTransaction().commit();
        System.out.println("Ciclista creado correctamente");


        session.close();
   
    }
}

