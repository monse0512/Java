package mx.edu.inite.util.hibernate;

import java.io.File;
import java.net.URL;
import mx.edu.inite.model.exception.IniteException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author raul
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory1;
    private static SessionFactory sessionFactory2;
    private static HibernateUtil instanceView;
    private static HibernateUtil instanceDB;
    private boolean active;

    private HibernateUtil() {
        super();
        sessionFactory1 = new Configuration().configure().buildSessionFactory();
    }

    private HibernateUtil(String path) {
        super();
        URL url = HibernateUtil.class.getClassLoader().getResource(path);
        File f = new File(url.getPath());
        sessionFactory2 = new Configuration().configure(f).buildSessionFactory();
    }

    public static HibernateUtil getInstance() { //instancia de la sesion
        if (instanceView == null) {
            instanceView = new HibernateUtil();
            instanceView.active = true;
        }
        return instanceView;
    }

    public static HibernateUtil getInstance(String path) {
        if (instanceDB == null) {
            instanceDB = new HibernateUtil(path);
            instanceDB.active = false;
        }
        return instanceDB;
    }

    public SessionFactory getSessionFactory() throws IniteException { //regresa la fabrica de hirbernate
        if (sessionFactory1 != null && active) {
            return sessionFactory1;
        }
        throw new IniteException("Sesion nula, verificar metodo getSessionFactoryWithPath");
    }

    public SessionFactory getSessionFactoryWithPath() throws IniteException {
        if (sessionFactory2 != null && !active) {
            return sessionFactory2;
        }
        throw new IniteException("Sesion nula, verificar metodo getSessionFactory");
    }
}
