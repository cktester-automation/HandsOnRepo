package com.api.restServices.helpers;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PayloadReader {
	
	public static String getPayload(final String fileNm) throws Exception {

		final File file = new File("src/test/resources/payload/" + fileNm);

		final Path path = file.toPath();

		final StringBuilder sb = new StringBuilder();
		final List<String> content = Files.readAllLines(path, Charset.defaultCharset());

		for (final String string : content) {

			sb.append(string);
		}

		String jsonstring = sb.toString();


		return jsonstring;
	}

}
