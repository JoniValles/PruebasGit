package uo.asw.citizensLoader.parser.emailWriter;

import java.io.IOException;

public interface EmailWriter {
	
	void write(String email) throws IOException;
}
