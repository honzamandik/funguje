/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.honzamandik.adventura.logika;





/*******************************************************************************
 * Instance třídy {@code PrikazZahod} představují ...
 *
 * @author    Jan Mandík
 * @version   0.00.000
 */
public class PrikazZahod implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================

    private static final String NAZEV = "zahod";
    private HerniPlan hPlan;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     *  
     *   @param herniPlan herní plán této hry
     */
    public PrikazZahod(HerniPlan hPlan) {
        this.hPlan = hPlan;
    }
    
    //== Nesoukromé metody (instancí i třídy) ======================================

    /**
     *  Zahodí věc, max jednu najednou. Když nebude věc k zahození, vrátí hlášku
     *
     *  @param  parametry   -jako  parametr se zadává jméno odhazované věci
     *  @return             zpráva, kterou vypíše hra hráči
     */ 
    
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            return "Nezvolil jsi správně věc k zahození";
        }

        String nazevVeci = parametry[0];
        Prostor aktualniProstor = hPlan.getAktualniProstor();
        Batoh batoh = hPlan.getBatoh();
        Vec mazana = batoh.getVec(nazevVeci);

        if (mazana == null) {
            // pokud mazana věc není v batohu.
            return "Takovou věc nemáš v inventáři";            
        }
        else {
            // pokud je věc smazána z batohu, přesune se do aktualního prostoru
            mazana = batoh.smazVec(nazevVeci);
            aktualniProstor.vlozVec(mazana);
            return "Úspěšně jsi zahodil " + nazevVeci + ".";
        }
    }

    /**
     *  Metoda rátí názec příkazu
     *  
     *  @ return nazev prikazu
     */
    
    public String getNazev() {
        return NAZEV;
    }
    
    //== Soukromé metody (instancí i třídy) ========================================

}