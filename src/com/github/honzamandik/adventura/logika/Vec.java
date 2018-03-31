/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.honzamandik.adventura.logika;



/*******************************************************************************
 * Instance třídy Vec představují ...
 *
 * @author    Jan Mandík
 * @version   0.00.000
 */
public class Vec
{
    //== Datové atributy (statické i instancí)======================================
    private String nazev;
    private String popis;
    private boolean prenositelna;
    private String obrazek;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     */
    public Vec(String nazev, String popis, boolean prenositelna,String obrazek)
    {
        this.nazev = nazev;
        this.popis = popis;
        this.prenositelna = prenositelna;
        this.obrazek = obrazek;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    /**
     * Metoda vypíše název věci
     *
     
     * @return název věci
     */
    public String getNazev() {
        return nazev;
    }
    
    /**
     * Metoda vypíše popis věci
     *
     
     * @return popis věci
     */
    public String getPopis() {
        return popis;
    }

    public String getObrazek() {
        return obrazek;
    }
    
    
    
   
    
    /**
     * Metoda zjistí jestli je věc přenositelná
     *
     
     * @return boolean přenositelnosti věci
     */
    public boolean isPrenositelna() {
        return prenositelna;
    }
    
    //== Soukromé metody (instancí i třídy) ========================================

}
