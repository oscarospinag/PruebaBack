package co.com.accenture.almacen.dto;

import java.io.Serializable;

public class CompraRequest implements Serializable {


    private Long id;
    private String cedula;
    private String direccion;
    private String name_producto;
    private Double valor_producto;

    public CompraRequest() {
    }

    public CompraRequest(String cedula, String direccion, String name_producto, Double valor_producto) {
        this.cedula = cedula;
        this.direccion = direccion;
        this.name_producto = name_producto;
        this.valor_producto = valor_producto;
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

    public String getName_producto() {
        return name_producto;
    }

    public void setName_producto(String name_producto) {
        this.name_producto = name_producto;
    }

    public Double getValor_producto() {
        return valor_producto;
    }

    public void setValor_producto(Double valor_producto) {
        this.valor_producto = valor_producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CompraRequest{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", name_producto='" + name_producto + '\'' +
                ", valor_producto=" + valor_producto +
                '}';
    }
}
