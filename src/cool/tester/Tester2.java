package cool.tester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;

import cool.compiler.Compiler;

public class Tester2 {
	// java -cp "bin;lib/antlr-4.8-complete.jar;%CLASSPATH%" cool.tester.Tester2
	public static void main(final String[] args) throws IOException {
		final String TEST_DIR_NAME = "tests/tema2";
		final var testDir = new File(TEST_DIR_NAME);

		final var filenameFilter = new FilenameFilter() {
			@Override
			public boolean accept(final File dir, final String name) {
				return name.endsWith(".cl") && !name.endsWith("main.cl");
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
			Compiler.main(new String[] { inPath, TEST_DIR_NAME + "/main.cl" });

			oldOut.printf("%-30s -> ", file.getName());
			final var result = compare(outPath, inPath.replace(".cl", ".ref"), oldOut);
			if (result)
				total += 5;

			oldOut.println("-----");
		}

		oldOut.println("Total: " + total);

		System.setOut(oldOut);
		System.setErr(oldErr);
	}

	public static boolean compare(final String outName, final String refName, final PrintStream oldOut)
			throws IOException {
		try (var outReader = new BufferedReader(new FileReader(outName));
				var refReader = new BufferedReader(new FileReader(refName));) {
			String line = null;

			final var outSet = new HashSet<String>();
			final var refSet = new HashSet<String>();

			while ((line = outReader.readLine()) != null)
				outSet.add(line);

			while ((line = refReader.readLine()) != null)
				refSet.add(line);

			if (outSet.equals(refSet)) {
				oldOut.println("OK");
				return true;
			}

			oldOut.println("Failed");

			// Copy set since removeAll would mutate it.
			final var missingSet = new HashSet<String>(refSet);
			missingSet.removeAll(outSet);

			final var extraneousSet = new HashSet<String>(outSet);
			extraneousSet.removeAll(refSet);

			if (!missingSet.isEmpty()) {
				oldOut.println("* Missing errors:");
				missingSet.stream().forEach(oldOut::println);
			}

			if (!extraneousSet.isEmpty()) {
				oldOut.println("* Extraneous errors:");
				extraneousSet.stream().forEach(oldOut::println);
			}

			return false;
		}
	}

}
