/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import mailpack.ReadEmail;
import utlity.Lista;

/**
 * @author tiago
 *
 */
public class ReadEmailTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link mailpack.ReadEmail#fetch(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testFetch() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link mailpack.ReadEmail#writeContent(javax.mail.Message)}.
	 */
	@Test
	public void testWriteContent() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link mailpack.ReadEmail#writeHeader(javax.mail.Message)}.
	 */
	@Test
	public void testWriteHeader() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link mailpack.ReadEmail#writeDate(javax.mail.Message)}.
	 */
	@Test
	public void testWriteDate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link mailpack.ReadEmail#getLx()}.
	 */
	@Test
	public void testGetLx() {
		List<Lista> lx = new ArrayList<>();
		ReadEmail re = new ReadEmail();
		String host = "imap.gmail.com";
		String username = "es1.2018.ic1.25@gmail.com";
		String password = "ES1_g25_det";
		re.fetch(host, username, password);
		lx.addAll(re.getLx());
		Assert.assertNotNull(lx);
	}

}
