package uo.asw.citizensLoader.parser.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import uo.asw.dbmanagement.model.Citizen;

public class ExcelCitizensReader implements CitizensReader {

	@Override
	public List<Citizen> readCitizens(String filePath) throws IOException {
		List<Citizen> citizens = new ArrayList<Citizen>();
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		String name = "";
		String surname = "";
		String email = "";
		String postAdress = "";
		String nationality = "";
		String dni = "";
		Date bornDate = new Date();
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		iterator.next(); // Para saltar la primera fila de titulos

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
					name = nextCell.getStringCellValue();
					break;
				case 1:
					surname = nextCell.getStringCellValue();
					break;
				case 2:
					email = nextCell.getStringCellValue();
					break;
				case 3:
					bornDate = nextCell.getDateCellValue();
					break;
				case 4:
					postAdress = nextCell.getStringCellValue();
					break;
				case 5:
					nationality = nextCell.getStringCellValue();
					break;
				case 6:
					dni = nextCell.getStringCellValue();
					break;
				default:
					break;
				}
			}

			citizens.add(
					new Citizen(name, surname, email, bornDate, postAdress, nationality, dni, email, name + "123"));
		}
		workbook.close();
		inputStream.close();

		return citizens;
	}

}
