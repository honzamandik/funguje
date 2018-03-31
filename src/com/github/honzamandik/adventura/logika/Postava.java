package com.github.honzamandik.adventura.logika;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký ků�? úpěl ďábelské ódy. 
package logika;
*/




/*******************************************************************************
 * Instance třídy {@code Postava} představují ...
 *
 * @author    Jan Mandík
 * @version   0.00.000
 */
public class Postava
{//== Datové atributy (statické i instancí)======================================
    
    private String jmeno;
    private String popis;
    private String mluveni;
    private String spcmluveni;
    private String obrazek;
    private HerniPlan hPlan;
    
        
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     * 
     * @param   jmeno       Jméno postavy
     * @param   mluveni     Co postava řekne poprvé, co je na ní promluveno
     * @param   spcmluveni  Co postava řekne v případě, že byla provedena specifická činnost
     
     */
    public Postava (HerniPlan hPlan, String jmeno, String popis, String mluveni, String spcmluveni, String obrazek) {
        this.jmeno = jmeno;
        this.popis = popis;
        this.mluveni = mluveni;
        this.spcmluveni = spcmluveni;
        this.hPlan = hPlan;
        this.obrazek = obrazek;
        
        
    }

    /**
     * Metoda vrátí jméno postavy.
     * 
     * @return  jmeno   Jméno postavy
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Metoda vrací dialog s postavou. Také ověří podmínku pro vedení speciálního dialogu.
     * 
     * @return  mluveni      dialog s postavou
     * @return  mluveni      dialog s postavou, jejíž požadavek byl splněn
     */
    public String getMluveni() {
        // když umejeme nádobí, řekne nám psotava něco jiného
        
        Prostor kuchyne = hPlan.mapaMistnosti.get("Kuchyně");
        if(kuchyne != null && kuchyne.getJeTamVec("Čisté_nádobí") != null) {
            return spcmluveni;
        } else {
            return mluveni;
        }
        
        
    }
    
    
    
     /**
     * Metoda vrací popis postavy
     *
     * 
     */
    public String getPopis() {
        return popis;
    }
    
    public String getObrazek() {
        return obrazek;
    }
    
        
    
    
    

    //== Soukromé metody (instancí i třídy) ========================================

}
