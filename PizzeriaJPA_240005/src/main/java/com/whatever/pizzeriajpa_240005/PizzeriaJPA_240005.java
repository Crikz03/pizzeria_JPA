/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.whatever.pizzeriajpa_240005;

import entidades.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Laboratorios
 */
public class PizzeriaJPA_240005 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        Producto p1 = new Producto(6L, "Pizza de elotes", 99.9f, "Pizza con mucho elote we");
//
//        em.persist(p1);
//
//        em.getTransaction().commit();
//        
//        System.out.println("Pizza guardada en la base de datos");
//        em.close();
        Producto pizza = em.find(Producto.class, 2L);
        if (pizza != null) {
            em.getTransaction().begin();
            em.remove(pizza);
            em.getTransaction().commit();
        } else {
            System.out.println("Nopapu");
        }

    }
}
