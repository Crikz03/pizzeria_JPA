/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idIngrediente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "idTipo", nullable = false)
    private TipoIngrediente tipo;

    @ManyToMany(mappedBy = "ingredientes")
    private List<Producto> productos;

    public Ingrediente() {
        this.productos = new ArrayList();
    }

    public Ingrediente(String nombre, Integer cantidad, TipoIngrediente tipo) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.productos = new ArrayList();
    }

    public Ingrediente(Long id, String nombre, Integer cantidad, TipoIngrediente tipo) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.productos = new ArrayList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public TipoIngrediente getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngrediente tipo) {
        this.tipo = tipo;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ingrediente{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", tipo=").append(tipo);
        sb.append(", productos=").append(productos);
        sb.append('}');
        return sb.toString();
    }
    
    

}
