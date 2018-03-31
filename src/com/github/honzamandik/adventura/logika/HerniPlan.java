package com.github.honzamandik.adventura.logika;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Class HerniPlan - třída představující mapu a stav adventury.
 * 
 * Tato třída inicializuje prvky ze kterých se hra skládá:
 * vytváří všechny prostory, propojuje je vzájemně pomocí východů
 * a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 * Kromě těhto věcí, který uměla v zadí také složí pro účely batohu
 * @author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Jan Riha, Jan Mandík
 * @version    ZS 2016/2017
 */
public class HerniPlan extends Observable {

    /*private static final String CILOVY_PROSTOR = "chaloupka";*/

    private Prostor aktualniProstor;
    private Batoh batoh;
    public boolean vyhra;
    public Map<String, Prostor> mapaMistnosti;
    public Hra hra;

    // private Batoh batoh;

    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan(Hra hra) {
        mapaMistnosti = new HashMap<String, Prostor>();
        zalozProstoryHry();
        batoh = new Batoh();
        vyhra = false;
        this.hra = hra;

        // this.batoh = new Batoh();
    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví ložnici.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor loznice = new Prostor("Ložnice","Tvoje ložnice, kde většinou spíš. Není moc dobře vybavená");
        mapaMistnosti.put(loznice.nazev, loznice);
        Prostor hala = new Prostor("Hala", "Strohá hala tvého bytu");
        mapaMistnosti.put(hala.nazev, hala);
        Prostor zachod = new Prostor("Záchod","Sem se chodí na záchod");
        mapaMistnosti.put(zachod.nazev, zachod);
        Prostor pracovna = new Prostor("Pracovna","Sem občas zalezeš a předstíráš, že pracuješ");
        mapaMistnosti.put(pracovna.nazev, pracovna);
        Prostor koupelna = new Prostor("Koupelna","Zde se lze umýt");
        mapaMistnosti.put(koupelna.nazev, koupelna);
        Prostor kuchyne = new Prostor("Kuchyně","Zde se vaří a jí.");
        mapaMistnosti.put(kuchyne.nazev, kuchyne);
        
        //vytváříme postavy
        Postava pritelkyne = new Postava (this, "Přítelkyně", "Toto je tvoje krásná přítelkyně", "Chceš vedět, kde jsi včera nechal mobil co? Myslím, že to vím, ale neřeknu ti to, dokud nemeješ nádobí!", "Super. Naposled jsem tě s tím telefonem viděla jít na záchod. Možná ti tam spadl, můžeš ho vytáhnout tím gumovým zvonem co je v koupelně","pritelkyne.jpg");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        loznice.setVychod(hala);
        zachod.setVychod(hala);
        pracovna.setVychod(hala);
        koupelna.setVychod(hala);
        kuchyne.setVychod(hala);
        hala.setVychod(loznice);
        hala.setVychod(zachod);
        hala.setVychod(pracovna);
        hala.setVychod(koupelna);
        hala.setVychod(kuchyne);
        
        // vytvoříme několik věcí
        
        Vec toaletniPapir = new Vec("Toaletní_papír", "Luxusni role toaletniho papiru", true,"toaletni_papir.jpg");
        Vec toaleta = new Vec("Záchodová_mísa", "Uplne normalni zachod", false,"toaleta.jpg");
        Vec gumovy_zvon = new Vec ("Gumový_zvon", "Věc, kterou lze použít pro uvolnění ucpaného záchoda", true,"gumovy_zvon.jpg");
        Vec postel = new Vec("Postel", "Postel, na které spáváš", false,"postel.jpg");
        Vec nocni_stolek = new Vec("Noční_stolek", "Noční stolek s malým šuplíčkem", false,"nocni_stolek.jpg");
        Vec polstar = new Vec("Polštář", "Polštář pro dva lidi", true,"polstar.jpg");
        Vec perina = new Vec("Peřina", "Peřina pro dva lidi", true,"perina.jpg");
        Vec kytka = new Vec("Kytka", "Kytka v hodně velkém květináči", false,"kytka.jpg");
        Vec dok = new Vec("Nabíjecí_dok", "Když do doku dáš telefon, začne se nabíjet", false,"dok.jpg");
        Vec stul = new Vec("Stůl", "Multifunkční stůl", false,"stul.jpg");
        Vec zidle = new Vec("Židle", "Židle, na které se dá sedět", false,"zidle.jpg");
       /* Vec zidle2 = new Vec("Židle", "Jedna ze dvou židlí, co jsou u stolu", false);*/
        Vec linka = new Vec("Kuchyňská_linka", "Kuchyňská link se dřezem. varnou deskou a dalšíma věcma, co patří na kuchyňskou linku", false,"linka.jpg");
        Vec cistici_prostredek = new Vec("Čistící_prostředek", "Tímhle se meje nádobí", true,"cistici_prostredek.jpg");
        Vec spinave_nadobi = new Vec("Špinavé_nádobí", "Hromada špinavého nádobí", false,"spinave_nadobi.jpg");
        Vec vana = new Vec("Vana", "Ve vaně je možné se vykoupat", false,"vana.jpg");
        Vec umyvadlo = new Vec("Umyvadlo", "V umyvadle je možné si umýt ruce", false,"umyvadlo.jpg");
        Vec mydlo = new Vec("Mýdlo", "Mýdlo slouží k mytí rukou", true,"mydlo.jpg");
        Vec snubni_prsten = new Vec("Snubní_prsten", "Zlatý prsten, kterým jsi chtěl požádat svou přítelkyni o ruku", true,"snubni_prsten.jpg");
        
        loznice.setX(135);
        loznice.setY(15);
        hala.setX(135);
        hala.setY(117);
        pracovna.setX(50);
        pracovna.setY(152);
        kuchyne.setX(136);
        kuchyne.setY(200);
        zachod.setX(231);
        zachod.setY(148);
        koupelna.setX(235);
        koupelna.setY(80);
        

        // umístíme věci do prostorů
        zachod.vlozVec(toaletniPapir);
        zachod.vlozVec(toaleta);
        loznice.vlozVec(postel);
        loznice.vlozVec(nocni_stolek);
        loznice.vlozVec(polstar);
        loznice.vlozVec(perina);
        hala.vlozVec(kytka);
        kuchyne.vlozVec(stul);
        kuchyne.vlozVec(zidle);
        kuchyne.vlozVec(zidle);
        kuchyne.vlozVec(linka);
        kuchyne.vlozVec(cistici_prostredek);
        kuchyne.vlozVec(spinave_nadobi);
        pracovna.vlozVec(stul);
        pracovna.vlozVec(zidle);
        pracovna.vlozVec(dok);
        pracovna.vlozVec(snubni_prsten);
        koupelna.vlozVec(umyvadlo);
        koupelna.vlozVec(mydlo);
        koupelna.vlozVec(vana);
        koupelna.vlozVec(gumovy_zvon);
               
        // vložíme postavu
        hala.vlozPostavu(pritelkyne);
        

        aktualniProstor = loznice;  // hra začíná v ložnici
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda, který vrátí inventář, který má hráč právě u sebe
     * 
     *  @return    batoh    botoh v jedné konkrétní 
     */
    public Batoh getBatoh() {
        return this.batoh;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostord
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

    public boolean hracVyhral() {
         
        return false;
    }
    
    public boolean getVyhra() {
        
        return vyhra;
    }
    
    @Override
    public void notifyObservers(){
        setChanged();
        super.notifyObservers();
    }

}
