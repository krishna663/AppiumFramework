package base.dataprovider;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataProviders {

    @DataProvider(name = "excelDataProvider")
    public static Object[][] getData(Method method) throws Exception {
        String excelPath = "src/test/resources/TestData/testdata.xlsx"; // Path to your Excel file
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        List<Object[]> rows = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell firstCell = row.getCell(0);
            if (firstCell == null) continue;
            firstCell.setCellType(CellType.STRING);
            String testNameInExcel = firstCell.getStringCellValue().trim();
            if (testNameInExcel.equalsIgnoreCase(method.getName())) {
                // Collect data for this row except the first column (test name)
                int totalCells = row.getPhysicalNumberOfCells();
                Object[] data = new Object[totalCells - 1];
                for (int i = 1; i < totalCells; i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    data[i - 1] = cell.getStringCellValue();
                }
                rows.add(data);
            }
        }
        workbook.close();
        fis.close();
        // Convert List<Object[]> to Object[][]
        Object[][] result = new Object[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            result[i] = rows.get(i);
        }
        return result;
    }
}
