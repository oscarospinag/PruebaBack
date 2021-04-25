package co.com.accenture.almacen.service.client;


import co.com.accenture.almacen.dto.FacturaDTO;
import co.com.accenture.almacen.model.Factura;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

@Service
public interface CompraService {

    /**
     * Metodo para la compra de productos
     *
     * @param factura
     * @return
     * @throws ServiceException
     * @Autor Oscar Ivan Ospina
     */
    Factura facturaVenta(FacturaDTO factura) throws ServiceException;

    /**
     * Metodo para editar la compra con la condidion
     *
     * @param factura
     * @return
     * @throws ServiceException
     * @Autor Oscar Ivan Ospina
     */
    Factura updateCompra(FacturaDTO factura) throws ServiceException;

    /**
     * Metodo para eliminar la compra con la condidion
     *
     * @param factura
     * @return
     * @throws ServiceException
     * @Autor Oscar Ivan Ospina
     */
    Factura deleteCompra(FacturaDTO factura) throws ServiceException;

}
