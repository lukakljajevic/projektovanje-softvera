/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.KontrolerKlijent;
import transfer.KlijentZahtev;
import transfer.ServerOdgovor;

/**
 *
 * @author Luka
 */
public class KomunikacijaKlijent {
    private static KomunikacijaKlijent instance;
    Socket soket;
    
    private KomunikacijaKlijent() {
        try {
            soket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            KontrolerKlijent.getInstance().serverNijePokrenut();
        }
    }
    
    public static KomunikacijaKlijent getInstance() {
        if (instance == null) {
            instance = new KomunikacijaKlijent();
        }
        return instance;
    }
    
    public void posaljiZahtev(KlijentZahtev kz) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(kz);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerOdgovor primiOdgovor() {
        ServerOdgovor so = new ServerOdgovor();
        
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            so = (ServerOdgovor) ois.readObject();
        } catch (Exception ex) {
            try {
                soket.close();
            } catch (IOException ex1) {
                Logger.getLogger(KomunikacijaKlijent.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println("Soket zatvoren");
        }
        
        return so;
    }
}
