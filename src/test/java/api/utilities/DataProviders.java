package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    String sheetname = "Sheet1";

    @DataProvider(name = "Data")
    public Object[][] getAllData() throws IOException {
        String path = "RestAssuredDD.xlsx";
        XLutility xl = new XLutility(path);

        int rowcount = xl.getRowCount(sheetname);
        int colcount = xl.getCellCount(sheetname, 1);

        Object[][] apidata = new Object[rowcount][colcount];
        for(int i = 1; i<=rowcount; i++){
            for(int j = 0; j<colcount; j++){
                apidata[i-1][j] = xl.getCellData(sheetname,i, j);
            }
        }
        return apidata;
    }

    @DataProvider(name = "Username")
    public Iterator<Object[]> getUserNames() throws IOException {
        String path = "RestAssuredDD.xlsx";
        XLutility xl = new XLutility(path);

        int rowcount = xl.getRowCount(sheetname);
        List<Object[]> userData = new ArrayList<>();

        for (int i = 1; i <= rowcount; i++) {
            Object[] data = {xl.getCellData(sheetname, i, 1)};
            userData.add(data);
        }

        return userData.iterator();
    }

}
