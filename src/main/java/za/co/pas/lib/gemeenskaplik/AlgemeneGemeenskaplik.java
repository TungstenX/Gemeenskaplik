/**
 *
 */
package za.co.pas.lib.gemeenskaplik;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre Labuschagne
 */
public class AlgemeneGemeenskaplik {

    private static final Logger LOG = Logger.getLogger(AlgemeneGemeenskaplik.class.getName());

    public static final String OPSIE_SIM = "--sim";
    public static final String OPSIE_HELP = "--help";
    public static final String OPSIE_DIENS_NAAM = "--diens";

    /**
     *
     * @param reëls
     * @param args
     * @return
     */
    public static final Map<String, String> WisselArgs(List<ArgsReël> reëls, String[] args)
            throws IllegalArgumentException {
        if ((reëls == null) || reëls.isEmpty()) {
            throw new IllegalArgumentException("Geen reëls gestuur");
        }
        Map<String, String> ret = new TreeMap<>();
        if ((args == null) || (args.length == 0)) {
            //nie 'n fout nie
            LOG.log(Level.INFO, "Geen args");
            return ret;
        }

        for (ArgsReël reël : reëls) {
            for (int i = 0; i < args.length; i++) {
                String s = args[i];
                if (s.toLowerCase().startsWith(reël.getOpsieKode().toLowerCase())) {
                    String waarde = null;
                    if (reël.isHetWaarde()) {
                        int pos = s.indexOf("=");
                        if(pos != -1) {
                            waarde = s.substring(pos + 1);
                        } else {
                            throw new IllegalArgumentException("Arg waarde verwag maar nie gekry nie vir " + reël.getOpsieKode());
                        }
                    }
                    ret.put(reël.getOpsieKode(), waarde);
                }
            }
        }
        return ret;
    }
    
    /**
     * Kry die waarde in die kaart, stuur null terug as die sleutel daar is maar die waarde is null
     * @param sleutel
     * @param kaart
     * @return 
     */
    public static final String Kry(String sleutel, Map<String, String> kaart) {
        return Kry(sleutel, kaart, false);
    }
    
    /**
     * Kry die waarde in die kaart
     * @param sleutel
     * @param kaart
     * @param leegVirNulWaarde stuur "" terug as die waarde nul is
     * @return 
     */
    public static final String Kry(String sleutel, Map<String, String> kaart, boolean leegVirNulWaarde) {
        if(kaart.containsKey(sleutel)) {
            String ret = kaart.get(sleutel);
            if((ret == null) && leegVirNulWaarde) {
                return "";
            }
            return ret;
        }
        return null;
    }
    
    public static void TekenRaam(StringBuilder sb, String[] lines) {
        sb.append("\n\u256D");
        for(int i = 0; i < 78; i++) {
            sb.append("\u2500");
        }
        sb.append("\u256E\n");
        
        for(String s : lines) {
            sb.append("\u2502").append(s);
            int rest = 78 - s.length();
            for(int i = 0; i < rest; i++) {
                sb.append(" ");
            }
            sb.append("\u2502\n");
        }
        
        sb.append("\u2570");
        for(int i = 0; i < 78; i++) {
            sb.append("\u2500");
        }
        sb.append("\u256F\n");        
    }
}
