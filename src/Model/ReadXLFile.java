/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.*;
import jxl.read.biff.BiffException;

/**
 *
 * @author Paaske
 */
public class ReadXLFile {
    public ArrayList<KidExl> readXlsbFile(String path) {
        try {
            Workbook wb = Workbook.getWorkbook(new File(path)); //"C:\\Users\\Paaske\\Desktop\\FileName.xls"));
            Sheet sheet = wb.getSheet(0);

            int xlRows = sheet.getRows();
            System.out.println("rows in Excel " + xlRows);
            
            
            ArrayList<KidExl> kidXl;
            kidXl = new ArrayList<>();

            for (int wbRows = 0; wbRows < xlRows; wbRows++) {
                int currRow = wbRows;

                if(currRow != 0){
                    if (!sheet.getCell(0, currRow).getContents().isEmpty()) {
                        Long cprP = Long.parseLong(sheet.getCell(2, currRow).getContents().replaceAll("[-]", ""));
                        Long cprK = Long.parseLong(sheet.getCell(3, currRow).getContents().replaceAll("[-]", ""));
                        double tempTakst = Math.abs(Double.parseDouble(sheet.getCell(6, currRow).getContents().replaceAll("[,]", ".")));
                        int takst = (int) tempTakst;
                        double friTS = Math.abs(Double.parseDouble(sheet.getCell(7, currRow).getContents().replaceAll("[,]", "."))); // had to replace , with . for it to work
                        int tPct = Integer.parseInt(sheet.getCell(8, currRow).getContents());
                        double extraPct = Math.abs(Double.parseDouble(sheet.getCell(10, currRow).getContents().replaceAll("[,]", "."))); // had to replace , with . for it to work
                        
                        KidExl exlKid = new KidExl(cprP, cprK, takst, friTS, tPct, extraPct);
                        kidXl.add(exlKid);
                    }
                    else
                        break;
                }
            }
            
            wb.close();
            return kidXl;
            
        } catch (IOException | BiffException ex) {
            Logger.getLogger(ReadXLFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
