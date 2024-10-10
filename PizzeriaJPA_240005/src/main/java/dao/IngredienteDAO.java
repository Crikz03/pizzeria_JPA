/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import entidades.Ingrediente;
import java.util.List;

/**
 *
 * @author Chris
 */
public class IngredienteDAO {

    private Conexion conexion;

    public IngredienteDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public List<Ingrediente> buscarIngredientesPorNombreA() {
        return this.conexion.crearConexion().createQuery("SELECT i FROM Ingrediente i WHERE i.nombre LIKE 'A%' OR i.nombre LIKE '%A'", Ingrediente.class)
                .getResultList();
    }
}
