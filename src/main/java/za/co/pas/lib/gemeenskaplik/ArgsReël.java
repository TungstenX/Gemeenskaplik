/**
 *
 */
package za.co.pas.lib.gemeenskaplik;

/**
 *
 * @author Andre Labuschagne
 */
public class ArgsReël {
    private String opsieKode;
//    private boolean verpligtend;
    private boolean hetWaarde;

    public ArgsReël(String opsieKode, boolean hetWaarde) {
        this.opsieKode = opsieKode;
        this.hetWaarde = hetWaarde;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Opsie Kode: ");
        sb.append(opsieKode).append(", Het Waarde: ").append(hetWaarde);
        return sb.toString();
    }
    
    
    /**
     * @return the opsieKode
     */
    public String getOpsieKode() {
        return opsieKode;
    }

    /**
     * @param opsieKode the opsieKode to set
     */
    public void setOpsieKode(String opsieKode) {
        this.opsieKode = opsieKode;
    }
//
//    /**
//     * @return the verpligtend
//     */
//    public boolean isVerpligtend() {
//        return verpligtend;
//    }
//
//    /**
//     * @param verpligtend the verpligtend to set
//     */
//    public void setVerpligtend(boolean verpligtend) {
//        this.verpligtend = verpligtend;
//    }

    /**
     * @return the hetWaarde
     */
    public boolean isHetWaarde() {
        return hetWaarde;
    }

    /**
     * @param hetWaarde the hetWaarde to set
     */
    public void setHetWaarde(boolean hetWaarde) {
        this.hetWaarde = hetWaarde;
    }
    
}
