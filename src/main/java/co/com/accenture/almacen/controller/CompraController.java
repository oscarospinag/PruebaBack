package co.com.accenture.almacen.controller;


import co.com.accenture.almacen.dto.FacturaDTO;
import co.com.accenture.almacen.dto.ProductosDTO;
import co.com.accenture.almacen.model.Factura;
import co.com.accenture.almacen.service.client.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CompraController {

    @Autowired
    private CompraService compraService;


    /**
     * Controlador para la compra de productos
     *
     * @param factura
     * @return
     * @Autor Oscar Ivan Ospina
     */
    @PostMapping("/factura")
    public ResponseEntity facturaVenta(@RequestBody FacturaDTO factura) {
        Double valor = 0D;
        for (ProductosDTO producto : factura.getProductos()) {
            valor += producto.getValorProducto();
        }
        factura.setValorCompra(valor);
        Factura response = compraService.facturaVenta(factura);

        if (response == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro al generar la Factura");
        }
        return ResponseEntity.ok(response);
    }

    /**
     * Controlador para editar productos
     *
     * @param id
     * @param factura
     * @return
     * @Autor Oscar Ivan Ospina
     */
    @PutMapping("/editfactura/{id}")
    public ResponseEntity edit(@PathVariable long id, @RequestBody FacturaDTO factura) {

        Factura response = compraService.updateCompra(factura);
        if (response == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error al editar la Factura constulte terminos y condiciones");
        }
        return ResponseEntity.ok(response);
    }

    /**
     * Controlador para eliminar productos
     *
     * @param id
     * @param factura
     * @return
     * @Autor Oscar Ivan Ospina
     */
    @DeleteMapping("/eliminarfactura/{id}")
    public ResponseEntity delete(@PathVariable long id, @RequestBody FacturaDTO factura) {

        Factura response = compraService.deleteCompra(factura);
        if (response == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error al editar la Factura constulte terminos y condiciones");
        }
        return ResponseEntity.ok(response);
    }
}
