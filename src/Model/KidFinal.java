/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Comparator;

/**
 *
 * @author Paaske
 */
public class KidFinal implements Comparable<KidFinal>{
    String  name;
    String  schoolClass;
    String  school;
    long    kCpr;
    long    pCpr;
    Integer clubNo;
    Double  fPct;
    
    public KidFinal(String name, String schoolClass, String school, long kcpr, long pcpr, Integer clubNo, Double fPct){
        this.name   = name;
        this.schoolClass = schoolClass;
        this.school = school;
        this.kCpr   = kcpr;
        this.pCpr   = pcpr;
        this.clubNo = clubNo;
        this.fPct   = fPct;
    }
    
    public Double getFPct(){
        return fPct;
    }
    
    public void setFPct(Double fPct){
        this.fPct = fPct;
    }
    
    public String getName(){
        return name;
    }
    
//    public void setName(String name){
//        this.name = name;
//    }
    
    @Override
    public int compareTo(KidFinal o) {
        return this.fPct.compareTo(o.getFPct());
    }
    
    public static Comparator<KidFinal> sortKidName = new Comparator<KidFinal>(){
        @Override
        public int compare(KidFinal o1, KidFinal o2) {
            String kidName01 = o1.getName().toUpperCase();
            String kidName02 = o2.getName().toUpperCase();
            
            return kidName01.compareTo(kidName02);
        }
    };
}
