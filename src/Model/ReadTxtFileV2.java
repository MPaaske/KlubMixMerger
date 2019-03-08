/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Paaske
 */
public class ReadTxtFileV2 {

    public ArrayList<KidTxt> readTxtFile(String path) throws FileNotFoundException {
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));

            //Prep Var's
            String st;
            ArrayList<KidTxt> myList;
            myList = new ArrayList<>();

            int i = 0;
            String name = "";
            String temp = "";
            long cpr = 0;
            int clubNo = 0;

            //Go through every line
            while ((st = br.readLine()) != null) {
                //Discard empty lines
                if (!st.isEmpty()) {
                    //Every kid is 7 lines
                    //First line with text is the name
                    if (i == 0)
                        name = st;
                    
                    //Second line with text is CPR
                    if (i == 1) {
                        if(st.matches("\\d+") && st.length() == 10)
                            cpr = Long.valueOf(st);
                        else
                            temp = name + "," + st;
                    }

                    //Last line with text is ClubNo
                    if (i == 6) {
                        if(st.matches("\\d+") && st.length() < 5)
                            clubNo = Integer.valueOf(st);
                        else {
                            temp += (temp.isEmpty()) ? name + ","  + cpr + "," + st : temp + "," + st ;
                        }
                    }

                    if(name != "" && cpr != 0 && clubNo != 0){
                        //Create Object from Values & enter it into a list to be used later
                            KidTxt kidT = new KidTxt(name, null, null, cpr, clubNo);
                            myList.add(kidT);
                            
                            //Reset var's
                            name = "";
                            cpr = 0;
                            clubNo = 0;
                    } else if(temp != "") {
                        System.out.println(temp);
                        temp = "";
                    }
                    
                    //Reset counter to track new kids
                    i = (i != 6) ? i + 1 : 0;
                }
            }

            return myList;
        } catch (IOException | NumberFormatException e) {
            return null;
        }
    }
}
