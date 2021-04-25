package co.com.accenture.almacen.dto;

import java.io.Serializable;

public class CompraResponse implements Serializable {

    private  Double valor_compra;

    public CompraResponse() {
    }

    public CompraResponse(Double valor_compra) {
        this.valor_compra = valor_compra;
    }

    public Double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(Double valor_compra) {
        this.valor_compra = valor_compra;
    }

    @Override
    public String toString() {
        return "CompraResponse{" +
                "valor_compra=" + valor_compra +
                '}';
    }
}
