package co.com.accenture.almacen.service.client;


import co.com.accenture.almacen.dto.FacturaDTO;
import co.com.accenture.almacen.model.Factura;
import co.com.accenture.almacen.repository.FacturaRepository;
import co.com.accenture.almacen.util.Util;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompraServiceImpl implements CompraService {

    //Constantes para los calculos de la compra
    static final double IVA = 0.19;
    static final Integer DOMICILIO = 2000;

    //Constante  para la multa por cancelacion de compra
    static final double MULTA = 0.10;

    @Autowired
    private FacturaRepository facturaRepository;


    /**
     * Metodo para la compra de productos
     *
     * @param factura
     * @return
     * @throws ServiceException
     * @Autor Oscar Ivan Ospina
     */
    @Override
    public Factura facturaVenta(FacturaDTO factura) throws ServiceException {

        double total = 0d;

        Factura response = new Factura();

        try {
            if (factura != null) {
                if (factura.getValorCompra() != null) {

                    total = factura.getValorCompra() * IVA + (factura.getValorCompra() + DOMICILIO);
                }
                if (factura.getValorCompra() > 70000) {

                    total = factura.getValorCompra() * IVA + (factura.getValorCompra() + DOMICILIO);
                }
                if (factura.getValorCompra() > 100000) {
                    total = (factura.getValorCompra() * IVA) + factura.getValorCompra();

                }
                response.setDireccion(factura.getDireccion());
                response.setCedula(factura.getCedula());
                response.setId(factura.getId());
                response.setValor_compra(total);
                response.setFecha(factura.getFecha());
                response.setNombre_producto(factura.getNombreProducto());

            }
            response = facturaRepository.save(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * Metodo para editar la compra con la condidion
     *
     * @param factura
     * @return
     * @throws ServiceException
     * @Autor Oscar Ivan Ospina
     */
    @Override
    public Factura updateCompra(FacturaDTO factura) throws ServiceException {

        Factura entity = new Factura();

        Factura entitydb = facturaRepository.findById(factura.getId()).orElse(null);

        //Obtengo las horas
        long fecha = Util.difHorasFechas(entitydb.getFecha(), factura.getFecha());
        double total = 0d;

        try {
            if (fecha < 5) {

                return null;
            }
            if (entitydb.getValor_compra() > factura.getValorCompra()) {

                return null;
            }

            if (factura.getValorCompra() > 70000) {

                total = factura.getValorCompra() * IVA + (factura.getValorCompra() + DOMICILIO);
            }

            if (factura.getValorCompra() > 100000) {
                total = (factura.getValorCompra() * IVA) + factura.getValorCompra();

            }
            entity.setId(factura.getId());
            entity.setCedula(factura.getCedula());
            entity.setDireccion(factura.getDireccion());
            entity.setFecha(factura.getFecha());
            entity.setNombre_producto(factura.getNombreProducto());
            entity.setValor_compra(total);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Factura response = facturaRepository.save(entity);

        return response;

    }


    /**
     * Metodo para eliminar la compra con la condidion
     *
     * @param factura
     * @return
     * @throws ServiceException
     */
    @Override
    public Factura deleteCompra(FacturaDTO factura) throws ServiceException {

        Factura response = new Factura();

        Factura facturadb = facturaRepository.findById(factura.getId()).orElse(null);

        //Obtengo las horas
        long fecha = Util.difHorasFechas(facturadb.getFecha(), factura.getFecha());

        double total = 0d;
        if (fecha > 12) {

            facturaRepository.delete(facturadb);

        } else if (fecha < 12) {

            double multa = factura.getValorCompra() * MULTA;

            response.setValor_compra(multa);

        }

        return response;
    }
}

