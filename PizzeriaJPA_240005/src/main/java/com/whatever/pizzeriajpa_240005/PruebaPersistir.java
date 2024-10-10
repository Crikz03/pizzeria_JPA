/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.whatever.pizzeriajpa_240005;

import entidades.Ingrediente;
import entidades.Producto;
import entidades.TipoIngrediente;
import entidades.Venta;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Laboratorios
 */
public class PruebaPersistir {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        TipoIngrediente tipoCarne = new TipoIngrediente();
        tipoCarne.setDescripcion("Carne");

        TipoIngrediente tipoVegetal = new TipoIngrediente();
        tipoVegetal.setDescripcion("Vegetal");

        em.persist(tipoCarne);
        em.persist(tipoVegetal);

        Ingrediente queso = new Ingrediente();
        queso.setNombre("Queso");
        queso.setCantidad(50);
        queso.setTipo(tipoCarne);

        Ingrediente jamon = new Ingrediente();
        jamon.setNombre("Jamón");
        jamon.setCantidad(30);
        jamon.setTipo(tipoCarne);

        Ingrediente tomate = new Ingrediente();
        tomate.setNombre("Tomate");
        tomate.setCantidad(20);
        tomate.setTipo(tipoVegetal);

        Ingrediente aceituna = new Ingrediente();
        aceituna.setNombre("Aceituna");
        aceituna.setCantidad(10);
        aceituna.setTipo(tipoVegetal);

        Ingrediente champinon = new Ingrediente();
        champinon.setNombre("Champiñón");
        champinon.setCantidad(25);
        champinon.setTipo(tipoVegetal);

        em.persist(queso);
        em.persist(jamon);
        em.persist(tomate);
        em.persist(aceituna);
        em.persist(champinon);

        Producto pizza1 = new Producto();
        pizza1.setNombre("Pizza Margarita");
        pizza1.setPrecio(300);
        pizza1.setDescripcion("Pizza con tomate y queso");
        pizza1.getIngredientes().add(tomate);
        pizza1.getIngredientes().add(queso);

        Producto pizza2 = new Producto();
        pizza2.setNombre("Pizza Jamón");
        pizza2.setPrecio(350);
        pizza2.setDescripcion("Pizza con jamón y queso");
        pizza2.getIngredientes().add(jamon);
        pizza2.getIngredientes().add(queso);

        Producto pizza3 = new Producto();
        pizza3.setNombre("Pizza Vegetariana");
        pizza3.setPrecio(280);
        pizza3.setDescripcion("Pizza con aceituna, champiñón y tomate");
        pizza3.getIngredientes().add(aceituna);
        pizza3.getIngredientes().add(champinon);
        pizza3.getIngredientes().add(tomate);

        em.persist(pizza1);
        em.persist(pizza2);
        em.persist(pizza3);

        Venta venta1 = new Venta();
        venta1.setFechaVenta(new Date());
        venta1.setPrecioTotal(650);
        venta1.getProductos().add(pizza1);
        venta1.getProductos().add(pizza2);

        Venta venta2 = new Venta();
        venta2.setFechaVenta(new Date());
        venta2.setPrecioTotal(280);
        venta2.getProductos().add(pizza3);

        em.persist(venta1);
        em.persist(venta2);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
