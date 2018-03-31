/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.honzamandik.adventura.logika;





/*******************************************************************************
 * Instance třídy {@code PrikazBatoh} představují vytvoření příkazu Baťoh, který ukáže hráči obsah jeho baťohu.
 *
 * @author    Jan Mandík
 * @version   0.00.000
 */
public class PrikazBatoh implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================

    private static final String NAZEV = "batoh";
    private HerniPlan hPlan;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     *  
     * @param herniPlan aktuální herní plán na kterém hra běží
     */
    public PrikazBatoh(HerniPlan hPlan) {
        this.hPlan = hPlan;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    
    /**
     *  Základní metoda vypisující věci v baťohu
     *
     *  @return     obsah baťohu
     */ 
    @Override
    public String proved(String... parametry) {
        if (hPlan.getBatoh().getObsahBatohu().isEmpty()) {
            // prádzná baťoh
            return "Tvůj baťoh je zatím prázdný";
        }
        else {
            // věci v baťohu
            return "V baťohu máš" + hPlan.getBatoh().getObsahBatohu() + " a ";
        }
    }

    /**
     *  Vrátí název příkazu
     *  
     *  @ return název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

    //== Soukromé metody (instancí i třídy) ========================================

}
