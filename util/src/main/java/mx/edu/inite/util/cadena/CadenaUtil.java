package mx.edu.inite.util.cadena;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 *
 * @author raul
 */
public class CadenaUtil {

    private static CadenaUtil instance;

    public static CadenaUtil getInstance() {
        if (instance == null) {
            instance = new CadenaUtil();
        }
        return instance;
    }

    public Boolean esNumerica(String Cadena) {
        if (Cadena.matches("(?=[^A-Za-z]+$).*[0-9].*")) {
            return true;
        } else {
            return false;
        }
    }

    public String limpiarGuionesBajos(String Cadena) {
        String respuesta = "";
        StringTokenizer st = new StringTokenizer(Cadena, "_");
        while (st.hasMoreTokens()) {
            respuesta = respuesta + st.nextToken() + " ";
        }
        return respuesta;
    }

    public String floatAsString(Float flotante, Integer precision) {
        DecimalFormat dec = new DecimalFormat();
        dec.setMinimumFractionDigits(precision);
        dec.setMaximumFractionDigits(precision);
        String respuesta = dec.format(flotante);
        return respuesta;
    }
}
