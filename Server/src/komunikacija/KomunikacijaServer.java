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
import kontroler.KontrolerServer;
import transfer.KlijentZahtev;
import transfer.ServerOdgovor;

/**
 *
 * @author Luka
 */
public class KomunikacijaServer {
    private static KomunikacijaServer instance;
    
    private boolean serverRadi = false;
    private boolean serverJeIskljucen = true;
    
    public static KomunikacijaServer getInstance() {
        if (instance == null) {
            instance = new KomunikacijaServer();
        }
        return instance;
    }

    public boolean isServerRadi() {
        return serverRadi;
    }

    public void setServerRadi(boolean serverRadi) {
        this.serverRadi = serverRadi;
    }

    public boolean isServerJeIskljucen() {
        return serverJeIskljucen;
    }

    public void setServerJeIskljucen(boolean serverJeIskljucen) {
        this.serverJeIskljucen = serverJeIskljucen;
    }
    
    public void posaljiOdgovorKljientu(Socket socket, ServerOdgovor so) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public KlijentZahtev primiZahtevOdKlijenta(Socket socket) throws Exception {
        KlijentZahtev kz = new KlijentZahtev();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        kz = (KlijentZahtev) in.readObject();
        return kz;
    }
}
