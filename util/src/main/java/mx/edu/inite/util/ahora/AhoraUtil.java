package mx.edu.inite.util.ahora;

import java.util.Calendar;
import mx.edu.inite.beans.Ahora;

/**
 *
 * @author raul
 */
public class AhoraUtil {

    private static AhoraUtil instance;
    private Calendar cal;
    private Ahora ahora;

    public AhoraUtil() {
        this.cal = Calendar.getInstance();
        this.ahora = new Ahora();
    }

    public AhoraUtil(Calendar cal) {
        this.cal = cal;
    }

    public AhoraUtil(Ahora ahora) {
        this.ahora = ahora;
    }
    
    public static AhoraUtil getInstance(){
        if (instance == null) {
            instance = new AhoraUtil();
        }
        return instance;
    }

    public Ahora getAhora() {
        ahora.setDiaMes(cal.get(Calendar.DAY_OF_MONTH));
        ahora.setDiaSemana(cal.get(Calendar.DAY_OF_WEEK));
        ahora.setHoraDia(cal.get(Calendar.HOUR_OF_DAY));
        ahora.setMinuto(cal.get(Calendar.MINUTE));
        ahora.setMes(cal.get(Calendar.MONTH));
        ahora.setSegundo(cal.get(Calendar.SECOND));
        ahora.setTimeOffset((cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / (60 * 1000));
        ahora.setAno(cal.get(Calendar.YEAR));
        return ahora;
    }

    public void setAhora(Ahora ahora) {
        this.ahora = ahora;
    }
}
