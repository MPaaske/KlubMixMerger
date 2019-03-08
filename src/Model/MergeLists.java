/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Paaske
 */
public class MergeLists {

    public ArrayList<KidFinal> mergeList(ArrayList<KidTxt> tabList, ArrayList<KidExl> excelList) {
        try {
            ArrayList<KidFinal> kidTemp = new ArrayList<>();
            ArrayList<KidFinal> finKidList = new ArrayList<>();

            // Iterate over the text file
            for (KidTxt kidT : tabList) {
                // Iterate over the Excel file
                for (KidExl kidX : excelList) {
                    // Foreach CPR in the excel that matches curret from the text file add into list.
                    if (kidX.cprK == kidT.cpr) {
                        double fPct = kidX.fpPct + kidX.extraPct; // add % values in order to get a final %

                        KidFinal kidF = new KidFinal(kidT.name, kidT.schoolClass, kidT.school, kidT.cpr, kidX.cprP, kidT.clubNo, fPct);
                        kidTemp.add(kidF); // Insert into temp list for sorting

                        System.out.println("Kids in both lists - " + kidT.name + ", " + kidT.cpr + ", " + fPct);
                    }
                }

                // if temp only contains 1 Obj, add it to final list and clear temp list.
                if (kidTemp.size() == 1) {
                    finKidList.add(kidTemp.get(0));
                    kidTemp.clear();
                } else if (kidTemp.size() > 1) { // if the list contains more then 1 Obj, 
                    //select the Obj with Collections.max value (it seems to work, I'm not entirely sure how), 
                    //and add it to final list, then clear the temp list
                    KidFinal kf = Collections.max(kidTemp);
                    finKidList.add(kf);
                    kidTemp.clear();
                }
            }

            System.out.println(finKidList.size());

            //finKidList.forEach((fKid) -> {System.out.println(fKid.name + ", " + fKid.cpr + ", " + fKid.fPct);});
            for (KidFinal fKid : finKidList) {
                System.out.println(fKid.name + ", " + fKid.kCpr + ", " + fKid.fPct);
            }

            return finKidList;
        } catch (Exception e) {
            return null;
        }
    }
}
