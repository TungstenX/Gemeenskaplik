/**
 *
 */
package za.co.pas.lib.gemeenskaplik;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre Labuschagne
 */
public class BeginStopLeerMaker {
    private static final Logger LOG = Logger.getLogger(BeginStopLeerMaker.class.getName());
    
    public static void MaakBegin(String naam) {
        if(naam != null) {
            Maak(naam + ".begin");
        }
    }    
    
    public static void MaakStop(String naam) {
        if(naam != null) {
            Maak(naam + ".stop");
        }
    }    
    
    private static void Maak(String naam) {        
        File file = new File(naam);
        try (FileOutputStream fos  = new FileOutputStream(file)){
            fos.write(Long.toString(System.currentTimeMillis()).getBytes());
        } catch(Exception e) {
            LOG.log(Level.SEVERE, "Fout terwylf leer geskep word: {0}", e.toString());
        }
    }
}
