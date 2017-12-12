package JavaTwo.LabTwo;

import org.apache.poi.ss.usermodel.*;

import java.io.IOException;

public class SudokuBoardChecker {
    //Prywatna instancja klasy Workbook
    private Workbook workbook;

    //Getter
    public Workbook getWorkbook() {
        return workbook;
    }

    //Setter
    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    //Publiczny konstruktor, ustawia nam od razu workbook nad ktorym bedziemy pracowac
    public SudokuBoardChecker(Workbook workbook) {
        this.setWorkbook(workbook);
    }

    //Prywatna metoda, ktora sprawdza czy struktura wprowadzanego pliku jest poprawna
    private boolean verifyBoardStructure(int sheetIndex) {
        //wartosc logiczna na poczatku, w przypadku spotkania wartosci null zmieniana jest na false i metoda
        // zostaje przerwana
        boolean verify = true;
        Sheet firstSheet = workbook.getSheetAt(sheetIndex);
        //sprawdzamy, czy jakas komorka nie ma wartosci null lub czy komorka jest rozna od wartosci numeric lub blank,
        // jezeli tak jest program zostaje przerwany i zwracamy false
        for (int i = 0; i < 9; i++) {
            Row row = firstSheet.getRow(i);
            for (int j = 0; j < 9; j++) {
                Cell cell = row.getCell(j);
                CellType cellType = cell.getCellTypeEnum();
                if (cell == null) {
                    verify = false;
                    break;
                }
                if (!(cellType.equals(CellType.NUMERIC) || cellType.equals(CellType.BLANK))) {
                    verify = false;
                    break;
                }
            }
        }
        return verify;
    }


    //metoda przygotowuje nam dane w postaci tablicy intow a nastepnie wywoluje metode isValidSudoku ktora nam zwraca
    // wartosc logiczna, czy dana tablica nie lamie regul tablic sudoku
    public boolean verifyBoard(int sheetIndex) throws IOException {
        if (verifyBoardStructure(sheetIndex)) {
            int[][] arrayOfSudoku = new int[9][9];
            Sheet firstSheet = workbook.getSheetAt(sheetIndex);

            for (int i = 0; i < 9; i++) {
                Row row = firstSheet.getRow(i);
                for (int j = 0; j < 9; j++) {
                    if (row == null) {
                        arrayOfSudoku[i][j] = 0;
                    } else {
                        arrayOfSudoku[i][j] = (int) row.getCell(j).getNumericCellValue();
                    }

                }
            }
            workbook.close();

            return isValidSudoku(arrayOfSudoku);
        }
        System.out.println("Wrong data provided!");
        return false;
    }

    //Metoda sprawdzajaca, czy przekazana w parametrze tablica int nadaje sie jako plansza sudoku
    public static boolean isValidSudoku(int[][] arrayOfInts) {
        for (int row = 0; row < 9; row++)
            for (int col = 0; col < 8; col++)
                for (int col2 = col + 1; col2 < 9; col2++)
                    if (arrayOfInts[row][col] == arrayOfInts[row][col2])
                        return false;

        for (int col = 0; col < 9; col++)
            for (int row = 0; row < 8; row++)
                for (int row2 = row + 1; row2 < 9; row2++)
                    if (arrayOfInts[row][col] == arrayOfInts[row2][col])
                        return false;


        for (int row = 0; row < 9; row += 3)
            for (int col = 0; col < 9; col += 3)
                for (int pos = 0; pos < 8; pos++)
                    for (int pos2 = pos + 1; pos2 < 9; pos2++)
                        if (arrayOfInts[row + pos % 3][col + pos / 3] == arrayOfInts[row + pos2 % 3][col + pos2 / 3])
                            return false;
        return true;
    }

}

