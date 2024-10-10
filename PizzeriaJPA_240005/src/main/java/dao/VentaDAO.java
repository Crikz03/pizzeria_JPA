/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import entidades.Venta;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Chris
 */
public class VentaDAO {

    private Conexion conexion;

    public VentaDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public List<Venta> buscarVentasEntreFechas(Date inicio, Date fin) {
        return this.conexion.crearConexion().createQuery("SELECT v FROM Venta v WHERE v.fechaVenta BETWEEN :inicio AND :fin", Venta.class)
                .setParameter("inicio", inicio)
                .setParameter("fin", fin)
                .getResultList();
    }

}
