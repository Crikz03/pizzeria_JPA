/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.whatever.pizzeriajpa_240005;

import conexion.Conexion;
import dao.IngredienteDAO;
import dao.ProductoDAO;
import dao.VentaDAO;
import entidades.Ingrediente;
import entidades.Producto;
import entidades.Venta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class PruebaConsultas {

    public static void main(String[] args) {

        try {
            Conexion conex = new Conexion();
            ProductoDAO pdao = new ProductoDAO(conex);
            IngredienteDAO ingdao = new IngredienteDAO(conex);
            VentaDAO vdao = new VentaDAO(conex);

            List<Producto> productos = pdao.buscarProductosPorPrecioMayorA(250);

//        System.out.println(productos);
            List<Ingrediente> ingredientes = ingdao.buscarIngredientesPorNombreA();

//            System.out.println(ingredientes);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date inicio = sdf.parse("2024-08-01");
            Date fin = sdf.parse("2024-10-30");

            List<Venta> ventas = vdao.buscarVentasEntreFechas(inicio, fin);

            System.out.println(ventas);
        } catch (ParseException ex) {
            Logger.getLogger(PruebaConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
