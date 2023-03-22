import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public static ArrayList<StudentsInfo> readExcel(String filePath) throws IOException {
        ArrayList<StudentsInfo> objects = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // assuming the data is on the first sheet

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // get the values from the row and create a new object
            StudentsInfo object = new StudentsInfo();
            object.setName(row.getCell(0).getStringCellValue());
            object.setID(row.getCell(1).getNumericCellValue());
            object.setActivities(row.getCell(2).getNumericCellValue());
            object.setPractical(row.getCell(3).getNumericCellValue());
            object.setMidterm(row.getCell(4).getNumericCellValue());
            object.setFinal(row.getCell(5).getNumericCellValue());

            // add the object to the list of objects
            objects.add(object);
        }

        workbook.close();
        inputStream.close();

        return objects;
    }
}