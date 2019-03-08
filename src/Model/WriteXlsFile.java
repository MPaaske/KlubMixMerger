/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Paaske
 */
public class WriteXlsFile {
    MergeLists ml = new MergeLists();
    
    public boolean createXlsFile(ArrayList<KidTxt> tabelexList, ArrayList<KidExl>kidXl, String XLSFileName, String variant) throws WriteException{
        try {
            //Set up directory for the file to be created.
            String desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator;
            WritableWorkbook wb = Workbook.createWorkbook(new File(desktopPath + XLSFileName + ".xls"));
            
            WritableSheet sheet = wb.createSheet("Sheet 1", 0);
            
            //Merge lists
            ArrayList<KidFinal> fList = ml.mergeList(tabelexList, kidXl);
            
            if(variant == "Tabelex"){
                //<editor-fold>
                Collections.sort(fList, KidFinal.sortKidName);
                
                Label lbl_ClubNo = new Label(0, 1, "Klub No");
                sheet.addCell(lbl_ClubNo);

                Label lbl_Name = new Label(1, 1, "Navn");
                sheet.addCell(lbl_Name);

                Label lbl_Cpr = new Label(2, 1, "CPR");
                sheet.addCell(lbl_Cpr);

                Label lbl_Friplads = new Label(3, 1, "Friplads");
                sheet.addCell(lbl_Friplads);

                for (int z = 0; z < fList.size(); z++) {
                    Label lbl_CN = new Label(0, z + 2, String.valueOf(fList.get(z).clubNo));
                    sheet.addCell(lbl_CN);
                    Label lbl_N = new Label(1, z + 2, fList.get(z).name);
                    sheet.addCell(lbl_N);
                    String temp = String.valueOf(fList.get(z).kCpr);
                    // Check if the CPR is 10 chars in length, if its only 9 chars we add a 0 in the front of the CPR
                    String tmpCpr = (temp.length() < 10) ? "0" + String.valueOf(fList.get(z).kCpr) : String.valueOf(fList.get(z).kCpr);
                    Label lbl_C = new Label(2, z + 2, tmpCpr);
                    sheet.addCell(lbl_C);
                    //Check if the final Friplads % is 100 or less
                    String formatFPct = (fList.get(z).fPct > 99.0) ? "Hel" : "Halv";
                    Label lbl_FPct = new Label(3, z + 2, formatFPct);
                    sheet.addCell(lbl_FPct);
                }

                wb.write();
                wb.close();
                return true;
                //</editor-fold>
            }else{
                //<editor-fold>
                
                // Prep Map (multi param List) for random code to Parant Cpr
                Map<Long, String> pCprMap = new HashMap<>();
                
                // forEach Kid we got, go through the list, add ParantCpr to Map as key's and add a random string as value to be used later
                fList.forEach((KidFinal kids)->{
                    if(!pCprMap.isEmpty()){ // Check if Map.isEmpty(), if yes go to else, if no step in
                        if(!pCprMap.containsKey(kids.pCpr)){ // Check if the current ParantCpr allready is in the Map
                            // Call random String Generator
                            String rndString = RandomString();
                            if(!pCprMap.containsValue(rndString)){
                                pCprMap.put(kids.pCpr, rndString);
                            }else{
                                while(pCprMap.containsValue(rndString)){
                                    rndString = RandomString();
                                }
                                pCprMap.put(kids.pCpr, rndString);
                            }
                        }
                    }else{
                        String rndString = RandomString();
                        pCprMap.put(kids.pCpr, rndString);
                    }   
                });
                
                
                Label lbl_No_Title = new Label(0, 0, "Tab No");
                sheet.addCell(lbl_No_Title);
                
                Label lbl_N_Title = new Label(1, 0, "Navn");
                sheet.addCell(lbl_N_Title);

                Label lbl_SC_Title = new Label(2, 0, "Klasse");
                sheet.addCell(lbl_SC_Title);

                Label lbl_S_Title = new Label(3, 0, "Skole");
                sheet.addCell(lbl_S_Title);

                Label lbl_P_Title = new Label(4, 0, "Forældre ID");
                sheet.addCell(lbl_P_Title);
                
                Label lbl_C_Title = new Label(5, 0, "Farve");
                sheet.addCell(lbl_C_Title);
                
                // Loop through fList and add values into xls sheet
                for(int i = 0; i < fList.size(); i++){
                    Label lbl_No = new Label(0, i+1, String.valueOf(fList.get(i).clubNo));
                    sheet.addCell(lbl_No);
                    Label lbl_N = new Label(1, i+1, String.valueOf(fList.get(i).name));
                    sheet.addCell(lbl_N);
                    Label lbl_SC = new Label(2, i+1, String.valueOf(fList.get(i).schoolClass));
                    sheet.addCell(lbl_SC);
                    Label lbl_S = new Label(3, i+1, String.valueOf(fList.get(i).school));
                    sheet.addCell(lbl_S);
                    String rndPCpr = pCprMap.get(fList.get(i).pCpr); //Get random generated Paraent CPR from pCprMap
                    Label lbl_P = new Label(4, i+1, rndPCpr);
                    sheet.addCell(lbl_P);
                    Label lbl_C = new Label(5, i+1, "null");
                    sheet.addCell(lbl_C);
                }
                
//                Lambda foreach
//                fList.forEach(kids->{
//                    Label lbl_x = new Label(0, 0, String.valueOf(kids.name));
//                });
                
                wb.write();
                wb.close();
                return true;
                //</editor-fold>
            }
        } catch (IOException ex) {
            return false;
        }
    }

    private String RandomString() {
        String charIntString =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                + "0123456789"
                                + "abcdefghijklmnopqrstuvxyz";
        
        int strLength = 15;
        
        StringBuilder sb = new StringBuilder(strLength);
        
        for(int i = 0; i < strLength; i++){
            // Get a random No. between 0 and var.lenght()
            int index = (int)(charIntString.length()*Math.random());
            
            // Append a char from var at the random index.
            sb.append(charIntString.charAt(index));
        }
        
        return sb.toString();
    }
}
