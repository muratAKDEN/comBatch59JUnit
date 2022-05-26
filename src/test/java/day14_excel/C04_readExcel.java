package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_readExcel {
    @Test
    public void readExcel() throws IOException {
        // ingilizce baskentler sutunu nu yazdir
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatir);
        String satirdakiData = "";
        for (int i = 0; i <= sonSatir; i++) {
            satirdakiData = C03_ReadExcel.banaDataGetir(i, 1);
            System.out.println(satirdakiData);
        }


    }
}
