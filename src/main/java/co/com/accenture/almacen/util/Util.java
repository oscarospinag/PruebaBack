package co.com.accenture.almacen.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Util {

    public static Date stringToDate(String fechaS) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Date fecha = null;
        try {
            fecha = sdf.parse(fechaS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }

    /**
     * Metodo que me pertmite calcular las fechas por horas para la logica
     *
     * @param oldDate
     * @param newDate
     * @return
     * @Autor Oscar Ivan Ospina
     */
    public static long difHorasFechas(Date oldDate, Date newDate) {
        long diff = newDate.getTime() - oldDate.getTime();
        long diffHours = diff / (60 * 60 * 1000);
        return diffHours;
    }
}

