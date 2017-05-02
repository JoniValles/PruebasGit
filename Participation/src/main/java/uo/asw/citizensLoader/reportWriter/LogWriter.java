package uo.asw.citizensLoader.reportWriter;

import java.io.IOException;

import uo.asw.citizensLoader.model.util.Writer;




public class LogWriter {
	
	private static final String fileName = "src/test/resources/log.txt";
	
	public static void write(String alert) throws IOException {
		Writer.write(fileName, alert);
	}
}
