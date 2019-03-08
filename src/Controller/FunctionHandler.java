/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import Model.KidExl;
import Model.KidFinal;
import Model.KidTxt;
import Model.MergeLists;
import Model.ReadTxtFileV1;
import Model.ReadXLFile;
import Model.WriteXlsFile;
import jxl.write.WriteException;

/**
 *
 * @author Paaske
 */
public class FunctionHandler {
    private final ReadTxtFileV1 readTxtFile;
    private final ReadXLFile readXlsFile;
    private final MergeLists mergeList;
    private final WriteXlsFile writeXlList;
    
    public FunctionHandler(){
        readTxtFile = new ReadTxtFileV1();
        readXlsFile = new ReadXLFile();
        mergeList   = new MergeLists();
        writeXlList = new WriteXlsFile();
    }
    
    public ArrayList<KidTxt> readTxt(String path) throws FileNotFoundException{
        return readTxtFile.readTxtFile(path);
    }
    
    public ArrayList<KidExl> readXls(String path) throws FileNotFoundException{
        return readXlsFile.readXlsbFile(path);
    }
        
    public ArrayList<KidFinal> mergeToList(ArrayList<KidTxt> tabList, ArrayList<KidExl> excelList){      
        return mergeList.mergeList(tabList, excelList);
    }
    
    public boolean createExcelFile(ArrayList<KidTxt> tabelexList, ArrayList<KidExl>kidXl, String XlFileName, String variant) throws WriteException{
        return writeXlList.createXlsFile(tabelexList, kidXl, XlFileName, variant);
    }
}
