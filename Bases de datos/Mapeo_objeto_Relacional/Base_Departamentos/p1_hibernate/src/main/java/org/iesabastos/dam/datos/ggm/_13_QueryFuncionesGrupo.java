package org.iesabastos.dam.datos.ggm;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ggm.Utils.HibernateUtil;

public class _13_QueryFuncionesGrupo {
    public static void main(String[] args) {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();

            Session sesion = HibernateUtil.getCurrentSession();
            sesion.beginTransaction();

            double salario;

            salario = (Double) sesion.createQuery("select avg(salario) from Empleado").uniqueResult();

            System.out.println("Salario medio de los profesores " + salario);

            Query q = sesion.createQuery("from Empleado");

            List<Object> lista = q.list();
            Departamento dep;

            int cont = 0;
            salario = 0;

            System.out.println("Salario medio y número de profesores");
            for (Object elto : lista) {
                Empleado emp = (Empleado) elto;
                salario += emp.getSalario();
                cont++;
            }
            System.out.println("Salario medio: " + salario / cont);
            System.out.println("Número de profesores: " + cont);

            sesion.getTransaction().commit();
            sesion.close();
            System.out.println("Fin!");
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Excepcion!");
        }
    }
}
