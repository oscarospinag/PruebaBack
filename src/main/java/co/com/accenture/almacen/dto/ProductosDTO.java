package co.com.accenture.almacen.dto;

import java.io.Serializable;

public class ProductosDTO implements Serializable {

    private String nombre_producto;
    private Double valorProducto;

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Double getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(Double valorProducto) {
        this.valorProducto = valorProducto;
    }
}
