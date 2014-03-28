package org.eclipse.concierge;

import java.io.File;
import java.net.URL;

public class AbstractConciergeTests {

	public static final String TEST_DATA = "test-data";

	public static File computeTestDataRoot(Class anyTestClass) {
		final String clsUri = anyTestClass.getName().replace('.', '/')
				+ ".class";
		final URL url = anyTestClass.getClassLoader().getResource(clsUri);
		final String clsPath = url.getPath();
		final File root = new File(clsPath.substring(0, clsPath.length()
				- clsUri.length()));
		final File clsFile = new File(root, clsUri);
		return new File(root.getParentFile(), TEST_DATA);
	}

}
