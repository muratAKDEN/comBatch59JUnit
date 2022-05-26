package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test

    public void readExcelTesti() throws IOException {
        // input olarak verilen satir no sutun no degerlerini parametre4 olarak olarak alip
        // o cell deki data yi bize donduren 1 method olustur

        int satirNo=12;
        int sutunNo=2;
        // donen Stringin Baku old .test edin


        String expectedData="Baku";
       String actualData= banaDataGetir(satirNo-1,sutunNo-1);// cunku excel index ile calisir

        Assert.assertEquals(expectedData,actualData);

    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
       String istenenData="";
       String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
       Workbook wb= WorkbookFactory.create(fis);
        istenenData=wb.getSheet("Sayfa1").
                getRow(satirIndex).
                getCell(sutunIndex).
                toString();


        return istenenData;
    }
}
