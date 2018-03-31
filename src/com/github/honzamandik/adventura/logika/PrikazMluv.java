/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.honzamandik.adventura.logika;





/*******************************************************************************
 * Instance třídy {@code PrikazMluv} představují ...
 *
 * @author    Jan Mandík
 * @version   0.00.000
 */
public class PrikazMluv implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================

    private static final String NAZEV = "mluv";
    private HerniPlan hPlan;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třídy PrikazMluv
     *  
     *  @param  plan  -herní plán, kde dojde k interakci
     */
    public PrikazMluv(Hra hra)
    {
         this.hPlan = hra.getHerniPlan();
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    /**
     *  Metoda vyhodí text reakce postavy, je-li tato postava přítomna
     *  
     *  @param parametry jméno postavy
     *  @return text pro hráče
     */
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            return "Je potřeba napsat s kým mluvit";
        }
        
        String jmeno = parametry[0];
        Prostor aktualniProstor = hPlan.getAktualniProstor();
        Postava postava = aktualniProstor.jeTuPostava(jmeno);
        //ověření přítomnosti postavy
        if (postava == null) {
            return jmeno + " tu není.";
        }
        else {
            
           
            return postava.getMluveni();
        }
    }
    
    /**
     *  Tato metoda vrátí název příkazu
     *  
     *  @return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
    
    //== Soukromé metody (instancí i třídy) ========================================

}
