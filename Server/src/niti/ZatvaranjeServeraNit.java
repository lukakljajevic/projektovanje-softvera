/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Luka
 */
public class ZatvaranjeServeraNit extends Thread {
    ServerSocket ss;
    PokreniServerNit ps;
    boolean kraj = false;

    public ZatvaranjeServeraNit(ServerSocket ss, PokreniServerNit ps) {
        this.ss = ss;
        this.ps = ps;
    }

    
    
    @Override
    public void run() {
        while(!kraj) {
            if(ps.isInterrupted()) {
                try {
                    ss.close();
                    kraj = true;
                } catch (IOException ex) {
                    
                }
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    
                }
            }
        }
    }
}
