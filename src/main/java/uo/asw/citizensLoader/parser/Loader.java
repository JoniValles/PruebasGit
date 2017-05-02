package uo.asw.citizensLoader.parser;

import java.io.IOException;
import java.util.List;

import uo.asw.citizensLoader.business.CitizenService;
import uo.asw.citizensLoader.conf.ServicesFactory;
import uo.asw.citizensLoader.model.exception.BusinessException;
import uo.asw.citizensLoader.parser.emailWriter.EmailWriter;
import uo.asw.citizensLoader.parser.emailWriter.TxtEmailWriter;
import uo.asw.citizensLoader.parser.reader.CitizensReader;
import uo.asw.citizensLoader.parser.reader.ExcelCitizensReader;
import uo.asw.citizensLoader.parser.reader.TextCitizensReader;
import uo.asw.citizensLoader.reportWriter.LogWriter;
import uo.asw.dbmanagement.model.Citizen;



public class Loader {

	private String formato;
	private String filePath;

	public Loader(String formato, String filePath) {
		this.formato = formato;
		this.filePath = filePath;
	}

	public void readList() throws IOException, BusinessException {
		
		List<Citizen> citizens = readCitizens(formato, filePath);

		CitizenService citizenService = ServicesFactory.getCitizenService();

		printCitizens(citizens, filePath);

		for (Citizen citizen : citizens) {
			if (!citizenService.isCitizenInDatabase(citizen)) {
				sendEmail(citizen, new TxtEmailWriter());
				citizenService.insertCitizen(citizen);
			} else {
				String mensaje = "El usuario " + citizen.getUserName()						+ " ya está registrado.";
				LogWriter.write(mensaje);
			}
		}
	}

	public List<Citizen> readCitizens(String formato, String filePath) throws IOException {
		return getReader(formato).readCitizens(filePath);
	}

	private void sendEmail(Citizen citizen, EmailWriter... writers)
			throws IOException {
		String email = "To "
				+ citizen.getEmail()
				+ ":\nSaludos "
				+ citizen.getName()
				+ ", le informamos de que ha sido registrado correctamente en el sistema de participación ciudadana.\nSu nombre de usuario es: "
				+ citizen.getUserName();
		for (EmailWriter writer : writers) {
			writer.write(email);
		}

	}

	/**
	 * Crea y devuelve el reader adecuado
	 */
	private CitizensReader getReader(String formato) {
		if ("excel".equals(formato)) {
			return new ExcelCitizensReader();
		} else if ("texto".equals(formato)) {
			return new TextCitizensReader();
		}
		return null;
	}

	public String getFormato() {
		return formato;
	}

	public String getFilePath() {
		return filePath;
	}
	
	
	
	private void printCitizens(List<Citizen> citizens, String filePath) {
		System.out.println("Estos son los usuarios presentes en el fichero "
				+ filePath + ":");
		for (Citizen citizen : citizens) {
			System.out.println(citizen);
		}
	}
	

}
