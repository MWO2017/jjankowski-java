package JavaTwo.LabTwo;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class MainTest {

	public static void main(String[] args) {
		String excelFilePath = "utils/sudoku.xlsx";
		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			workbook.close();
			SudokuBoardChecker sudokuBoardChecker = new SudokuBoardChecker(workbook);
			for (int i = 0; i < 7; i++) {
				System.out.println("Board " + i);
				System.out.println(sudokuBoardChecker.verifyBoard(i));
			}

		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
			String message = String.format("File: %s does not exist", excelFilePath);
			System.out.println(message);
		} catch (IOException ex2) {
			ex2.printStackTrace();
			System.out.println("There is some problem with XSSFWorkbook object.");
		}

	}

}
