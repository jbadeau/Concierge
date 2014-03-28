package org.eclipse.concierge;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.launch.Framework;

public class ConciergeTest extends AbstractConciergeTests {

	@Test
	public void testConstruction() {
		// simple test to create an embedded framework
		File config = computeTestDataRoot(this.getClass());
		Map<String, String> configuration = new HashMap<String, String>();
		configuration
				.put(Constants.FRAMEWORK_STORAGE, config.getAbsolutePath());
		Framework framework = new Factory().newFramework(configuration);
		try {
			framework.init();
			framework.start();
		} catch (BundleException e) {
			fail("Failed to start the framework");
		}
		assertEquals("Wrong state for SystemBundle", Bundle.ACTIVE,
				framework.getState());
		BundleContext systemContext = framework.getBundleContext();
		assertNotNull("SystemBundle context is null", systemContext);

		try {
			framework.stop();
		} catch (BundleException e) {
			fail("Unexpected erorr stopping framework");
		}
		try {
			framework.waitForStop(10000);
		} catch (InterruptedException e) {
			fail("Unexpected interrupted exception");
		}
		assertEquals("Wrong state for SystemBundle", Bundle.RESOLVED,
				framework.getState());
	}

	@Test
	public void testStartAndStop() {
		// create/start/stop/start/stop test
		File config = computeTestDataRoot(this.getClass());
		Map<String, String> configuration = new HashMap<String, String>();
		configuration
				.put(Constants.FRAMEWORK_STORAGE, config.getAbsolutePath());
		configuration
				.put(Constants.FRAMEWORK_STORAGE, config.getAbsolutePath());
		Framework framework = new Factory().newFramework(configuration);

		try {
			framework.init();
			framework.start();
		} catch (BundleException e) {
			fail("Failed to start the framework");
		}
		assertEquals("Wrong state for SystemBundle", Bundle.ACTIVE,
				framework.getState());
		try {
			framework.stop();
		} catch (BundleException e) {
			fail("Unexpected erorr stopping framework");
		}
		try {
			framework.waitForStop(10000);
		} catch (InterruptedException e) {
			fail("Unexpected interrupted exception");
		}
		assertEquals("Wrong state for SystemBundle", Bundle.RESOLVED,
				framework.getState());

		try {
			framework.start();
		} catch (BundleException e) {
			fail("Failed to start the framework");
		}
		assertEquals("Wrong state for SystemBundle", Bundle.ACTIVE,
				framework.getState());
		try {
			framework.stop();
		} catch (BundleException e) {
			fail("Unexpected erorr stopping framework");
		}
		try {
			framework.waitForStop(10000);
		} catch (InterruptedException e) {
			fail("Unexpected interrupted exception");
		}
		assertEquals("Wrong state for SystemBundle", Bundle.RESOLVED,
				framework.getState());
	}

}
