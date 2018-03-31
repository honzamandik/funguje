/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.honzamandik.adventura.main;

import com.github.honzamandik.adventura.logika.Hra;
import com.github.honzamandik.adventura.logika.IHra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GuiAdventura extends Application {
	
	
	/*public static void main(String[] args) {
        launch(args);
    }*/
	
	 /**
     *  Hlavní metoda hry -text pro textové rozhraní
     *  
     */	
	public static void main(String[] args) {
    	if (args.length == 0) {
            launch(args);
        } else {
            if (args[0].equals("-text")) {
                IHra hra = new Hra();
                TextoveRozhrani ui = new TextoveRozhrani(hra);
                ui.hraj();
            } else {
                System.out.println("Neplatný parametr");
            }
        }
    }
    
    
	 /**
     *  Startuje hru
     *  
     */	
	@Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    
    
}
