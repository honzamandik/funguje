/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.honzamandik.adventura.logika;



/*******************************************************************************
 * Instance třídy PrikazVezmi představují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class PrikazVezmi implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
    private static final String NAZEV = "vezmi";
    private Batoh batoh;
    private HerniPlan herniPlan;

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     */
    public PrikazVezmi(HerniPlan hPlan)
    {
        this.herniPlan = hPlan;
        this.batoh = herniPlan.getBatoh();
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    /**
     * Metoda sbírá věci, při tom i kontroluje, jestli batoh není plný
     * 
     * @param   parametry   sbíraná věc
     * @return              zápis o tom, zda byla věc sebrána
     */    
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            return "Napiš, co by jsi chtěl sebrat";
        }

        String nazevVeci = parametry[0];
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        Vec vec = herniPlan.getAktualniProstor().odeberVec(nazevVeci);

        if (vec == null) {
            // zkontroluji jestli to tam je
            return "Nic takového tu není";
        }
        else {
                        if (!vec.isPrenositelna()) {
                // pokud věc není přenositelná
                herniPlan.getAktualniProstor().vlozVec(vec);
            return "věc '" + nazevVeci + "' fakt neuneseš";
            }
            else {
                if (batoh.vlozVec(vec) == null) {
                    // vrátí věc do prostoru, pokud je batoh plný
                    aktualniProstor.vlozVec(vec);
                    return "Baťoh je plný, nejdřív něco zahoď";
                }
                else {
                    // pokud se podaží věc vložit do batohu
                    return "Věc " + nazevVeci + " přidána do baťohu";
                }
            }
        }
    }
    
    
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
	public String getNazev() {
	    return NAZEV;
	}

    //== Soukromé metody (instancí i třídy) ========================================

}
