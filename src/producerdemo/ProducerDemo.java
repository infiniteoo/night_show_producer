/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerdemo;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author troy
 */
public class ProducerDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    new UserInterface();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ProducerDemo.class.getName()).log(Level.SEVERE, null, ex);
                };

            };

        });
    };

};
