/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import entidades.Producto;
import java.util.List;

/**
 *
 * @author Chris
 */
public class ProductoDAO {

    private Conexion conexion;

    public ProductoDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public List<Producto> buscarProductosPorPrecioMayorA(float precio) {
        return this.conexion.crearConexion().createQuery("SELECT p FROM Producto p WHERE p.precio > :precio", Producto.class)
                .setParameter("precio", precio)
                .getResultList();
    }

}
