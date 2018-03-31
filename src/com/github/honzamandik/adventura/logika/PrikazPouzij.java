package com.github.honzamandik.adventura.logika;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň? úpěl ďábelské ódy. */


/*******************************************************************************
 * Instance třídy PrikazPouzij implementují pro hru příkaz Pouzij.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author    Jan Mandík
 * @version   0.1
 */
public class PrikazPouzij implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================

    private static final String NAZEV = "pouzij";
    private HerniPlan hPlan;
    private Batoh batoh;
    
    
    // tento string se vyskytuje vícekrát, uděláme z něj tedy konstantu
    String nelzePouzit = "Používat tohle je nesmysl";
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     *  
     *   @param hra       hra, která řídí celkový průběh 
     */
    public PrikazPouzij(Hra hra)
    {
        
        this.hPlan = hra.getHerniPlan();
        batoh = hPlan.getBatoh();
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    /**
     * Následují čtyři metody určují, zda jsme ve správné místnosti pro použití věci napsaných v metodě pod nimi
     * 
     * @param   parametry   prostor (metoda pod nimi odá aktuální prostor)
     * @return  text       chybová hláška nebo příběhový text
     */
    private String mytiNadobi (Prostor prostor) {
        String text;
        Vec ciste_nadobi = new Vec("Čisté_nádobí", "Hromada čistého nádobí", false,"ciste_nadobi.jpg");
        // mýt nádobí lze pouze v kuchyni"
        if (prostor.getNazev().equals("Kuchyně"))  {
            // změní nádobí čisté a přítelkyni na štastnou
            prostor.odeberVec("Špinavé_nádobí");
            prostor.vlozVec(ciste_nadobi);
            text = "Umyl jsi nádobí";
            batoh.smazVec("Čistící_prostředek");
            
                    
        }
        else {
            // pokud nejsme v prostoru, kde lze čistit
            text = "Tady bys neměl nic čistit";
        }
        return text;
    }
    
    /**
     * Metoda, která požádá přítelkyni o ruku použitím prstenu. Ověřuje, jestli se používá v prostoru, kde se přítelkyně nachází
     * 
     * @param   parametry   prostor (metoda pod nimi odá aktuální prostor)
     * @return  text       příběhový text
     */
    private String zadaniORuku (Prostor prostor) {
        String text;
        // tady není nikdo, na koho bys to mohl použít"
        if (prostor.getNazev().equals("Hala"))  {
            text = "Požádal jsi přítelkyni o ruku. Je moc štastná a na oplátku ti řekla, že tě naposledy viděla s tvým telefonem, když jsi včera večer pospíchal na záchod";
            batoh.smazVec("Snubní_prsten");
                    
        }
        else {
            // pokud nejsme v prostoru, kde lze čistit
            text = "Tady není nikdo, na koho bys to mohl použít";
        }
        return text;
        
        
    }
    
    /**
     * Metoda, která ze záchodu vyndá telefon a vybitý ho dá do baťohu. Ověří, jestli se hráč nachází na záchodě
     * 
     * @param   parametry   prostor (metoda pod nimi odá aktuální prostor)
     * @return  text       příběhový text
     */
    private String gumovaniZachodu (Prostor prostor) {
        String text;
        Vec vybity_telefon = new Vec("Vybitý_telefon", "Tohle je telefon, který hledáš, ale je vybitý", true,"vybity_telefon.jpg");
        // ověříme, zdali jsme na záchodě"
        if (prostor.getNazev().equals("Záchod"))  {
            text = "Pořádně si použil gumový zvon na záchodovou mísu a světe se div, vyplaval tvůj telefon. Naštěstí je voděoodolný. Máš ale problém, telefon nejde zapnout.";
            batoh.smazVec("Gumový_zvon");                    
           batoh.vlozVec(vybity_telefon);
           
                    
        }
        else {
            // pokud nejsme v prostoru, kde lze čistit
            text = "Tady to nemá smysl používat";
        }
        return text;
    }
    
    /**
     * Metoda, která dá nabíjet telefon a rovnou také vypíše hlášku o konci hry. Ověří, zdali je hráč ve správné místnosti
     * 
     * @param   parametry   prostor (metoda pod nimi odá aktuální prostor)
     * @return  text       příběhový text
     */
    private String nabijeniTelefonu (Prostor prostor) {
        String text;
        // ověříme, zdali jsme u nabíječky
        if (prostor.getNazev().equals("Pracovna"))  {
            text = "Dal jsi nabíjet telefon a zákazník ti tedy nyní může zavolet. Vyhrál jsi hru! Klidně se ještě můžeš projít po bytě. Hru ukončíš příkazem konec";
            batoh.smazVec("Vybitý_telefon");
            hPlan.vyhra = true;   
           
                    
        }
        else {
            // pokud nejsme v prostoru, kde lze čistit
            text = "Tady to nemá smysl používat";
        }
        return text;
    }
    
    /**
     * Metoda, jejíž hlavní smyslem je switch z předchozích metod podle použitého předmětu
     * 
     * @param   parametry   použitá věc
     * @return  vypis       přepsání textu z metod výše nebo vypsání chybové hlášky
     */
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            return "Musíš napsat věc, kterou chceš použít";
        }
        
        String vypis;
        String pouzitaVec = parametry[0];
        Prostor aktualniProstor = hPlan.getAktualniProstor();
        Batoh batoh = hPlan.getBatoh();
        
        if (batoh.getVec(pouzitaVec) == null) {           
            // pokud věc není v batohu, tj. hráč ji nesebral
            vypis = "Takovou věc nemáš v baťohu";
        }
        else {
            
            switch (pouzitaVec) {
                case "Čistící_prostředek":
                    // když použiji čistí prostředek na špinavé nádobí, něco to udělá
                    vypis = mytiNadobi(aktualniProstor);
                    break;
                case "Snubní_prsten":
                    //když ukážu snubní prsten přítelkyni v hale, něco to udělá
                    vypis = zadaniORuku(aktualniProstor);
                    break;
                case "Gumový_zvon":
                    // když použiji vybitý telefon v pracovně (kde je nabíjecí dok), něco to udělá
                    aktualniProstor.equals("pracovna");
                    vypis = gumovaniZachodu(aktualniProstor);                 
                    break;
                case "Vybitý_telefon":
                    // když použiji vybitý telefon poblíž nabíječky
                    vypis = nabijeniTelefonu(aktualniProstor);
                                     
                    break;
                default:
                    
                    vypis = "V tuto chvíli nemá smysl tohle používat.";
                    break;
            }
        }
        
        return vypis;
    }
    
    
    
    

    /**
     * Metoda vrací název příkazu
     * 
     * @return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }

   
    
    
    //== Soukromé metody (instancí i třídy) ========================================

}
