package domination.mvc.model.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Charly Cimino 
 */
public class ConnectionPool {

    private static BasicDataSource dataSource;
    private static ConnectionPool pool;
    private Properties props;

    private ConnectionPool() {
        this.props = new Properties();
        cargarPropiedades();
        crearDataSource();
    }

    public static ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            System.out.println("Error al liberar conexión");
            ex.printStackTrace(System.out);
        }
    }

    private void crearDataSource() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(this.props.getProperty("driverClassName")); // https://dev.mysql.com/doc/connector-j/8.1/en/connector-j-reference-driver-name.html
        dataSource.setUrl(this.props.getProperty("url"));
        dataSource.setUsername(this.props.getProperty("username"));
        dataSource.setPassword(this.props.getProperty("password"));
        dataSource.setInitialSize(Integer.parseInt(this.props.getProperty("tamInicial"))); // Número inicial de conexiones en el pool
        dataSource.setMaxTotal(Integer.parseInt(this.props.getProperty("tamMaximo"))); // Número máximo de conexiones en el pool
    }

    private void cargarPropiedades() {        
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("META-INF/DBConnection.properties")) {
            this.props.load(in);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}