package org.eclipse.concierge;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import org.osgi.framework.launch.Framework;

public class ConciergeTest {

	@Test
	/*
	 * If framework properties are not provided by the configuration argument,
	 * the created framework instance must use some reasonable default
	 * configuration appropriate for the current VM.
	 */
	public void ConciergeInstanceWithNullConfiguration() {
		Factory factory = new Factory();
		Framework framwork = factory.newFramework(null);
		assertNotNull(framwork);
	}

	@Test
	/*
	 * The created framework instance must copy any information needed from the
	 * specified configuration argument since the configuration argument can be
	 * changed after the framework instance has been created.
	 */
	public void ConciergeInstanceWithEmptyConfiguration() {
		Factory factory = new Factory();
		Framework framwork = factory
				.newFramework(new HashMap<String, String>());
		assertNotNull(framwork);
	}

}
