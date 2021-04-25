package co.com.accenture.almacen.model;


import javax.persistence.*;
import java.util.Date;

/**
 * La clase persistente para la tabla de base de datos "ALMACEN".
 */
@Entity
@Table(name = "FACTURA")
public class Factura {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "PRODUCTO_NAME")
    private String nombre_producto;
    @Column(name = "VALOR_COMPRA")
    private Double valor_compra;
    @Column(name = "DATE")
    private Date fecha;

    public Factura() {
    }

    public Factura(String cedula, String direccion, String nombre_producto, Double valor_compra, Date fecha) {
        this.cedula = cedula;
        this.direccion = direccion;
        this.nombre_producto = nombre_producto;
        this.valor_compra = valor_compra;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(Double valor_compra) {
        this.valor_compra = valor_compra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nombre_producto='" + nombre_producto + '\'' +
                ", valor_compra=" + valor_compra +
                ", fecha=" + fecha +
                '}';
    }
}
