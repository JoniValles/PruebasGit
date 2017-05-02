package uo.asw.citizensLoader.parser.emailWriter;

import java.io.IOException;

import uo.asw.citizensLoader.model.util.Writer;


public class TxtEmailWriter implements EmailWriter {
	
	private static final String fileName = "src/test/resources/emails.txt";
	
	@Override
	public void write(String email) throws IOException {
		Writer.write(fileName, email);
	}

}
