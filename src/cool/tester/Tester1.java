package cool.tester;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.util.Arrays;

import cool.compiler.Compiler;

public class Tester1 {
	// java -cp "bin;antlr-4.8-complete.jar;%CLASSPATH%" cool.tester.Tester1
	public static void main(final String[] args) throws IOException {
		final String TEST_DIR_NAME = "tests/tema1";
		final var testDir = new File(TEST_DIR_NAME);

		final var filenameFilter = new FilenameFilter() {
			@Override
			public boolean accept(final File dir, final String name) {
				return name.endsWith(".cl");
			}
		};

		final var oldOut = System.out;
		final var oldErr = System.err;

		var total = 0;

		final var files = testDir.listFiles(filenameFilter);
		Arrays.sort(files);
		for (final var file : files) {
			final var inPath = file.getPath();
			final var outPath = inPath.replace(".cl", ".out");
			final var newOut = new PrintStream(outPath, "UTF-8");
			System.setOut(newOut);
			System.setErr(newOut);
			Compiler.main(new String[] { inPath });

			oldOut.printf("%-30s -> ", file.getName());
			final var result = compare(outPath, inPath.replace(".cl", ".ref"));
			if (result == 0) {
				oldOut.println("OK");
				total += 5;
			} else
				oldOut.println("Failed at line " + result);
		}

		oldOut.println("Total: " + total);

		System.setOut(oldOut);
		System.setErr(oldErr);
	}

	public static int compare(final String fileName1, final String fileName2)
			throws IOException {
		try (LineNumberReader reader1 = new LineNumberReader(new FileReader(fileName1));
				LineNumberReader reader2 = new LineNumberReader(new FileReader(fileName2));) {
			String line1 = null, line2 = null;

			while ((line1 = reader1.readLine()) != null
					& (line2 = reader2.readLine()) != null) {

				if (!line1.equals(line2))
					return reader1.getLineNumber();
			}

			if (line1 != null || line2 != null)
				return reader1.getLineNumber() + 1;

			return 0;
		}
	}

}
