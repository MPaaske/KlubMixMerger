
import Model.KidExl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Paaske
 */
public class ReadXLFileConcept{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        try {
//            // TODO code application logic here
//            String path = "C:\\Users\\Paaske\\Desktop\\KlubMix\\Ark1 - Copy.xls"; //C:\\Users\\Paaske\\Desktop\\KlubMix\\Ark1.xlsb";
//
//            Workbook wb = Workbook.getWorkbook(new File(path)); //"C:\\Users\\Paaske\\Desktop\\FileName.xls"));
//            Sheet sheet = wb.getSheet(0);
//
//            int xlRows = sheet.getRows();
//            System.out.println(xlRows);
//            
//            
//            ArrayList<KidExl> kidXl;
//            kidXl = new ArrayList<>();
//
//            for (int wbRows = 0; wbRows < xlRows; wbRows++) {//replace 17 with xlRows
//                int currRow = wbRows + 1; // change 2 to 1 for final product
//
//                if (!sheet.getCell(0, currRow).getContents().isEmpty()) {
//                    Long cprT = Long.parseLong(sheet.getCell(3, currRow).getContents().replaceAll("[-]", ""));
//                    int tPct = Integer.parseInt(sheet.getCell(8, currRow).getContents());
//                    double tfPct = Math.abs(Double.parseDouble(sheet.getCell(10, currRow).getContents().replaceAll("[,]", "."))); // had to replace , with . for it to work
//                    //double finalPct = tPct + tfPct;
//
//                    KidExl exlKid = new KidExl(cprT, tPct, tfPct);
//                    kidXl.add(exlKid);
//                }
//                else
//                    break;
//            }
//        } catch (IOException | BiffException ex) {
//            Logger.getLogger(ReadXLFileConcept.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

}
