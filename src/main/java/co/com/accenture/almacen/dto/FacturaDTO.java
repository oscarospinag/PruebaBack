package co.com.accenture.almacen.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class FacturaDTO implements Serializable {

    private Long id;
    private String cedula;
    private String direccion;
    private Date fecha;
    List<ProductosDTO> productos;
    private Double valorCompra;
    private String nombreProducto;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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

    public List<ProductosDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductosDTO> productos) {
        this.productos = productos;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FacturaDTO{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fecha=" + fecha +
                ", productos=" + productos +
                ", valorCompra=" + valorCompra +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}