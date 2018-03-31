package com.github.honzamandik.adventura.main;


import java.util.Scanner;
import com.github.honzamandik.adventura.logika.IHra;
/**
 *  Class TextoveRozhrani
 * 
 *  Toto je uÅ¾ivatelskÃ©ho rozhranÃ­ aplikace Adventura
 *  Tato tÅ™Ã­da vytvÃ¡Å™Ã­ instanci tÅ™Ã­dy Hra, kterÃ¡ pÅ™edstavuje logiku aplikace.
 *  ÄŒte vstup zadanÃ½ uÅ¾ivatelem a pÅ™edÃ¡vÃ¡ tento Å™etÄ›zec logice a vypisuje odpovÄ›Ä� logiky na konzoli.
 *  Pokud chcete hrÃ¡t tuto hru, vytvoÅ™te instanci tÃ©to tÅ™Ã­dy
 *  a potÃ© na nÃ­ vyvolejte metodu "hraj". 
 *  
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro Å¡kolnÃ­ rok 2014/2015
 */

public class TextoveRozhrani {
    private IHra hra;

    /**
     *  VytvÃ¡Å™Ã­ hru.
     */
    public TextoveRozhrani(IHra hra) {
        this.hra = hra;
    }

    /**
     *  HlavnÃ­ metoda hry. VypÃ­Å¡e ÃºvodnÃ­ text a pak opakuje Ä�tenÃ­ a zpracovÃ¡nÃ­
     *  pÅ™Ã­kazu od hrÃ¡Ä�e do konce hry (dokud metoda konecHry() z logiky nevrÃ¡tÃ­
     *  hodnotu true). Nakonec vypÃ­Å¡e text epilogu.
     */
    public void hraj() {
        System.out.println(hra.vratUvitani());

        // zÃ¡kladnÃ­ cyklus programu - opakovanÄ› se Ä�tou pÅ™Ã­kazy a potÃ©
        // se provÃ¡dÄ›jÃ­ do konce hry.

        while (!hra.konecHry()) {
            String radek = prectiString();
            System.out.println(hra.zpracujPrikaz(radek));
        }

        System.out.println(hra.vratEpilog());
    }

    /**
     *  Metoda pÅ™eÄ�te pÅ™Ã­kaz z pÅ™Ã­kazovÃ©ho Å™Ã¡dku
     *
     *@return    VracÃ­ pÅ™eÄ�tenÃ½ pÅ™Ã­kaz jako instanci tÅ™Ã­dy String
     */
    private String prectiString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        return scanner.nextLine();
    }

}
