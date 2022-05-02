package sourcepackage.se.kth.iv1350.hackers.model;
import java.time.LocalDateTime;
import sourcepackage.se.kth.iv1350.hackers.DTO.*;

/**
 * The receipt of a Sale.
 */
public class Receipt{
    private SaleDTO saleInformation;

    /** 
     * Creates a new instance of Receipt.
     * 
     * @param saleDTO Contains all the information that is to be printed.
     */
    public Receipt(SaleDTO saleInformation) {
        this.saleInformation = saleInformation;
    }

    /**
     * Creates a string with the contents of the receipt
     * 
     * @return receipt string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendLine(sb, "Point of Sale");
        endSection(sb);

        LocalDateTime currentTime = LocalDateTime.now();
        sb.append("Sale time");
        appendLine(sb, currentTime.toString());
        endSection(sb);

        sb.append("Sale");

        for (HashMap.Entry<String, Item> entry : items.entrySet()){
            String key = entry.getKey();
            Item value = entry.getValue();
            sb.append(key);
            sb.append(value.toString());
        }

        sb.append("Total price:");
        appendLine(sb, /*get totalprice*/);
        sb.append("Amound paid:");
        appendLine(sb, /* get amountPaid*/);
        sb.append("Change");
        appendLine(sb, /* get change*/);
        endSection(sb);

        return sb.toString();
    }

    private void appendLine(StringBuilder sb, String line){
        sb.append(line);
        sb.append("\n");
    }
    
    private void endSection(StringBuilder sb){
        sb.append("\n");
    }

}