/**
 * 
 */
package syspanel;

import static org.junit.Assert.*;

import org.hsqldb.jdbc.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Permission;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;




/**
 * @author zeta
 *
 */
public class DatabaseTest {

    DataSource dataSource;
    
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
        /*datasource.setDriverClassName("org.hsqldb.jdbcDriver");
        datasource.setUrl("jdbc:hsqldb:res:/data/test/testdatabase");
        datasource.setUsername("sa");
 
        Class.forName("org.hsqldb.jdbcDriver");
        */
		try {
			Connection connection = this.getDataSource().getConnection();
			try {
				Statement stmt = connection.createStatement();
				try { stmt.execute(""+
						"CREATE TABLE genero\n" + 
						"(\n" + 
						"	id INT NOT NULL,\n" + 
						"	nombre VARCHAR(30) NOT NULL,\n" + 
						"	PRIMARY KEY(id)\n" + 
						");\n" + 
						"\n" + 
						"CREATE TABLE actor\n" + 
						"(\n" + 
						"	id INT NOT NULL,\n" + 
						"	nombre VARCHAR(70),\n" + 
						"	PRIMARY KEY(id)\n" + 
						");\n" + 
						"\n" + 
						"CREATE TABLE pelicula\n" + 
						"(\n" + 
						"	id INT NOT NULL,\n" + 
						"	titulo VARCHAR(100) NOT NULL,\n" + 
						"	duracion INT NOT NULL,\n" + 
						"	director VARCHAR(400) NOT NULL,\n" + 
						"	anio INT NOT NULL,\n" + 
						"	fecha_lanzamiento DATE NOT NULL,\n" + 
						"	puntuacion INT,\n" + 
						"	poster VARCHAR(300),\n" + 
						"	trama VARCHAR(700),\n" + 
						"	genero_id INT, \n" + 
						"	PRIMARY KEY(id),\n" + 
						"	FOREIGN KEY(genero_id) REFERENCES genero(id)\n" + 
						");\n" + 
						"\n" + 
						"CREATE TABLE actor_pelicula\n" + 
						"(\n" + 
						"	id INT NOT NULL,\n" + 
						"	actor_id INT,\n" + 
						"	pelicula_id INT,\n" + 
						"	PRIMARY KEY(id),\n" + 
						"	FOREIGN KEY (actor_id) REFERENCES actor(id),\n" + 
						"	FOREIGN KEY (pelicula_id) REFERENCES pelicula(id)\n" + 
						");\n" + 
						"\n" + 
						""); connection.commit(); 
				} finally { stmt.close(); }
			} finally {
				if (connection != null) { connection.close(); }
			}
		} catch (Exception e) { 
			
			try {tearDown();} catch (Exception e2) {
				throw e2;
			} 
		throw e;/*e.printStackTrace();*/ }

	}
	
	private DataSource getDataSource() throws Exception {
	    if (dataSource == null) {
//	    	javax.naming.Reference ref = new javax.naming.Reference()
//	    	new jdbcDataSourceFactory().getObjectInstance(new Reference("org.hsqldb.jdbc.jdbcDataSource"), null, null, null);
//	    	dataSource = createMemoryDataSource();
	    	jdbcDataSource dataSource = new jdbcDataSource();

	        String db_file_name_prefix="db_hsql";
			dataSource.setDatabase("jdbc:hsqldb:" + db_file_name_prefix);
	        dataSource.setUser("sa");
	        dataSource.setPassword("");
	        //conn = dataSource.getConnection("sa", "");
	        this.dataSource=dataSource;
	    }
	    assertNotNull("No se pudo obtener el datasource", dataSource);
	    return dataSource;
	}
	
	/**
	 * @author zeta
     * The Reference object should support the properties, database, user,
     * password.
	 */
	private class Reference extends javax.naming.Reference {
		public Reference(String className) {super(className);}
		public String getDatabase() {return "hsql";}
		public String getUser() {return "sa";}
		public String getPassword() {return "";}
	}
	
	private DataSource createMemoryDataSource() {
		return  new jdbcDataSource();
        /*BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        basicDataSource.setUrl("jdbc:hsqldb:mem:junit");
        basicDataSource.setUsername("sa");
        basicDataSource.setPassword("");
        dataSource = basicDataSource;*/
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		try {
			Connection connection = this.getDataSource().getConnection();
			try {
				Statement stmt = connection.createStatement();
				try { stmt.execute("DROP SCHEMA PUBLIC CASCADE;"
						+ "SHUTDOWN"); connection.commit(); } finally { stmt.close(); }
			} finally {
				if (connection != null) { connection.close(); }
			}
		} catch (Exception e) { throw e;/*e.printStackTrace();*/ }
		
	}

	@Test
	public void test() throws Exception {
		try {
			Connection connection = this.getDataSource().getConnection();
			try {
				Statement stmt = connection.createStatement();
				try { stmt.execute("SELECT 1 FROM pelicula"); connection.commit(); } finally { stmt.close(); }
			} finally {
				if (connection != null) { connection.close(); }
			}
		} catch (Exception e) { throw e;/*e.printStackTrace();*/ }	
	}

}
