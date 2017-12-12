package JavaTwo.LabTwo;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class MainTest {


    public static void main(String[] args) throws IOException {
        String excelFilePath = "utils/sudoku.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        workbook.close();
        SudokuBoardChecker sudokuBoardChecker = new SudokuBoardChecker(workbook);


        for (int i =0; i<7; i++){
            System.out.println("Board" + i);
            System.out.println(sudokuBoardChecker.verifyBoard(i));
        }




    }

}
