package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import database.DataBase;

public class DataBaseConTest {
	private DataBase BD;
	@Before
    public void setUp() {
		BD = new DataBase();
    }
	@Test
	public void test() throws NamingException {
		BD.connect();
		assertNotNull(BD.getConnection());
	}
	@After
	public void tearDown() throws SQLException {
		BD.getConnection().close();
	}
}
