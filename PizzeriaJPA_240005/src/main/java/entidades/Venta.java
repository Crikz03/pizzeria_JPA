/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idVenta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaVenta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    @Column(name = "precioTotal")
    private float precioTotal;

    @ManyToMany
    @JoinTable(
            name = "producto_venta",
            joinColumns = @JoinColumn(name = "idVenta"),
            inverseJoinColumns = @JoinColumn(name = "idProducto")
    )
    private List<Producto> productos;

    public Venta() {
        this.productos = new ArrayList<>();
    }

    public Venta(Long id, Date fechaVenta, float precioTotal) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.precioTotal = precioTotal;
        this.productos = new ArrayList<>();
    }

    public Venta(Date fechaVenta, float precioTotal) {
        this.fechaVenta = fechaVenta;
        this.precioTotal = precioTotal;
        this.productos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
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
        sb.append("Venta{");
        sb.append("id=").append(id);
        sb.append(", fechaVenta=").append(fechaVenta);
        sb.append(", precioTotal=").append(precioTotal);
        sb.append(", productos=").append(productos);
        sb.append('}');
        return sb.toString();
    }

}
