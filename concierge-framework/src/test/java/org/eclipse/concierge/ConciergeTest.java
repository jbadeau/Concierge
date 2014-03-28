package org.eclipse.concierge;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.launch.Framework;

public class ConciergeTest {

	private Factory factory;
	private Framework framework;

	@Before
	public void setup() {
		factory = new Factory();
		framework = factory.newFramework(null);
	}

	@Test
	public void init_checkStateIsSTARTING() {
		assertEquals(framework.getState(), Bundle.STARTING);
	}

	@Test
	public void init_checkBundleContextIsValid() {
		Factory factory = new Factory();
		Framework framwork = factory.newFramework(null);
		assertNotNull(framework.getBundleContext());
	}

	@Test
	public void init_checkStartLevelIs0() {
		Factory factory = new Factory();
		Framework framwork = factory.newFramework(null);
		// assertEquals(framework.getState(), Bundle.STARTING);
	}

	@Test
	public void init_checkEventHandlingIsEnabled() {
		Factory factory = new Factory();
		Framework framwork = factory.newFramework(null);
		// assertEquals(framework.getState(), Bundle.STARTING);
	}

}
