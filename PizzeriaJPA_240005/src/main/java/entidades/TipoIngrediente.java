/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "tiposIngredientes")

public class TipoIngrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idTipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "tipo")
    private List<Ingrediente> ingredientes;

    public TipoIngrediente() {
        this.ingredientes = new ArrayList();
    }

    public TipoIngrediente(String descripcion) {
        this.descripcion = descripcion;
        this.ingredientes = new ArrayList();
    }

    public TipoIngrediente(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.ingredientes = new ArrayList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TipoIngrediente{");
        sb.append("id=").append(id);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", ingredientes=").append(ingredientes);
        sb.append('}');
        return sb.toString();
    }

}
