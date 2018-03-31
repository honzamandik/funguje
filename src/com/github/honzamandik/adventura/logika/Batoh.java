package com.github.honzamandik.adventura.logika;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň? úpěl ďábelské ódy. */

 import java.util.*;

/*******************************************************************************
 * Smyslem batuhu je sloužit jako skladiště věcí.
 * 
 *
 * @author    Jan Mandík
 * @version   0.1
 */
public class Batoh
{
    //== Datové atributy (statické i instancí)======================================
    
    private List<Vec> inventar;            // Inventář
    private static final int MAXIMALNINOSNOST = 2;    // Kolik věcí uneseme
    
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor
     */
    public Batoh() {
        inventar = new ArrayList<Vec>();
    }
    
    //== Nesoukromé metody (instancí i třídy) ======================================
    
    /**
     * Touto metodou vkládáme věci
     * 
     * @param   vec    vkládaná věc
     * @return  vec    vrátí tu samou věc, pokud se ji podaří přidat do batohu.
     *                 Null, pokud ne.
     */
    public Vec vlozVec(Vec prid_vec) {
        if (nepreplneno()) {          
            inventar.add(prid_vec);
            return prid_vec;
        }
        return null;
    }
    
    /**
     * Smyslem metody je ověřit, zda.li je v batohu ještě místo
     * 
     * pokud místo je vrátí true, ale to batohu věc přidá metoda vlozVec
     */
     public boolean nepreplneno() {
        if (inventar.size() < MAXIMALNINOSNOST) {
            return true;   
        }        
        return false;
    }
    
    /**
     * Metoda zjistí, zda-li je věc v batohu
     *  
     * @param   hledana    věc, kterou hledám
     * @return  true       pokud je v batuhu, jinak false
     */
    public boolean obsahujeVec(String hledana_Vec) {
        for (Vec probihajici: inventar) {
            if (probihajici.getNazev().equals(hledana_Vec)) {
                 return true;
            }
        }
        return false;
    }
    
    /**
     * Vrátí seznam věcí v batohu
     * 
     * @return   seznam     vypíše seznam věcí v batohu
     */
    public String getObsahBatohu() {
        String seznam = "";
        for (Vec probihajici: inventar) {
            if (!seznam.equals("")) {
               
                seznam += " a ";
            }
            seznam += " " + probihajici.getNazev();
        }
        return seznam;
    }
    
    /**
     * Metoda hledá věc v batohu
     * 
     * @param nazev      -název hledané věci
     * @return hledana   -Null pokud věc nebyla nalzena, jinak hledané věc
     */
    public Vec getVec(String nazev) {
        Vec hledana = null;
        for (Vec probihajici: inventar) {
            if(probihajici.getNazev().equals(nazev)) {
                hledana = probihajici;
                break;
            }
        }
        return hledana;
    }
    
    /**
     * Metoda odstraňující věci z inventáře
     * 
     * @param   mazana      věc, kterou je třeba odstranit
     * @return  smazana     v případě případného odstranění odstraněná věc, jinak null
     */
    public Vec smazVec (String odstranovana) {
        Vec odstranena = null;
        for(Vec probihajici: inventar) {
            if(probihajici.getNazev().equals(odstranovana)) {
                odstranena = probihajici;
                inventar.remove(probihajici);
                break;
            }
        }
        return odstranena;
    }

    public List<Vec> getInventar() {
        return inventar;
    }
    
    
    
    
    
    /**
     * Metoda vrátí maximální nosnost
     * 
     * @return  -počet věcí, které se vejdou do batohu
     */
    public int getMaxVeci() {
        return MAXIMALNINOSNOST;
    }
    
    //== Soukromé metody (instancí i třídy) ========================================

}
