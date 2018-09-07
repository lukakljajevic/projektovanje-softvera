/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.GlavnaServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.KomunikacijaServer;
import kontroler.KontrolerServer;

/**
 *
 * @author Luka
 */
public class PokreniServerNit extends Thread {


    public PokreniServerNit() {}

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut!");
            KontrolerServer.getInstance().uspesnoPokretanjeServera();
            ZatvaranjeServeraNit zs = new ZatvaranjeServeraNit(ss, this);
            zs.start();
            
            while (!isInterrupted()) {
                System.out.println("radi server");
                Socket socket = ss.accept();
                System.out.println("Klijent se povezao");
                ObradaZahtevaKlijentaNit ozk = new ObradaZahtevaKlijentaNit(socket);
                ozk.start();
            }
            
            System.out.println("Zaustavljen server");
            KontrolerServer.getInstance().uspesnoZaustavljenServer();
            
            
        } catch (Exception e) {
            KontrolerServer.getInstance().uspesnoZaustavljenServer();
        }
        
    }
    
    
    
    
}
