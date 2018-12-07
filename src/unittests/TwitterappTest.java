package unittests;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import twitterpack.Twitterapp;
import utlity.Lista;

public class TwitterappTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

/*	@Test
	public void testTwitterapp() {
		fail("Not yet implemented");
	}
*/
	@Test
	public void testGetList() {
		Twitterapp ta = new Twitterapp();
		List<Lista> list = new ArrayList<>();
		list = ta.getLx();
		Assert.assertNotNull(list);
	}

}
