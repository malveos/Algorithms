package com.osm.OmkarSM.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.osm.OmkarSM.model.Person;
import com.osm.OmkarSM.testing.repos.SampleRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, 
	DbUnitTestExecutionListener.class })
@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value="insert.xml")
//@DbUnitConfiguration(databaseConnection={"dataSource"})
public class TestSampleRepository {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	SampleRepository repos;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() {
		Person person = new Person(45, "SKd");
		Person person2 = new Person(62, "kancha");
		testEntityManager.persist(person);
		testEntityManager.persist(person2);

		//IDataSet partDS =new FlatXmlDataSetBuilder().build(new File("insert.xml"));
//		/FlatXmlDataSet.write(partDS, new FileOutputStream("insert.xml"));
	}

	@Test
	public void testGetCallCrud() {
		Person value = repos.findById(45).orElse(null);
		assertNotNull(value);
		assertEquals("SKd", value.getName());
	}

	@Test
	public void testGetCallCrudNegativeTest() {
		Person value = repos.findById(45).orElse(null);
		assertNotNull(value);
		assertNotEquals("SKs", value.getName());
	}

	@Test(expected = NullPointerException.class)
	public void testExceptionCall() {
		Person value = repos.findById(5).orElse(null);
		assertNotEquals("SKs", value.getName());
	}

	@Test
	public void testJPAQuery() {
		Person value = repos.getNameById(45);
		assertNotNull(value);
		assertEquals("SKd", value.getName());
	}

	@Test
	public void testNativeQuery() {
		String value = repos.getNameByIdNative(45);
		assertNotNull(value);
		assertEquals("SKd", value);
	}

	@Test
	@DatabaseSetup("insert.xml")
	public void testJDBCQuery() {
		String value = repos.getNameByIdJDBC(62);
		assertNotNull(value);
		assertEquals("kancha", value);
	}
}
