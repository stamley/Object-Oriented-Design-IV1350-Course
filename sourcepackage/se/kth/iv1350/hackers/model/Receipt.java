package sourcepackage.se.kth.iv1350.hackers.model;
import java.time.LocalDateTime;
import java.util.HashMap;

import sourcepackage.se.kth.iv1350.hackers.DTO.*;
import sourcepackage.se.kth.iv1350.hackers.util.Amount;
import java.util.HashMap;

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
    public String receiptToString(){
        StringBuilder sb = new StringBuilder();
        appendLine(sb, "Point of Sale");
        endSection(sb);

        LocalDateTime currentTime = LocalDateTime.now();
        sb.append("Sale time");
        appendLine(sb, currentTime.toString());
        endSection(sb);

        sb.append("Sale");

        HashMap<String, Item> items = saleInformation.getItemList();
        for (HashMap.Entry<String, Item> entry : items.entrySet()){
            String key = entry.getKey();
            Item value = entry.getValue();
            sb.append(key);
            sb.append(value.toString());
        }

        sb.append("Total price:");
        appendLine(sb, saleInformation.getTotalPrice().getTotal().toString());
        sb.append("Total price incl. VAT:");
        appendLine(sb, saleInformation.getTotalPrice().getTotalIncludingVAT().toString());
        sb.append("Total price incl. VAT and discount:");
        appendLine(sb, saleInformation.getTotalPrice().getTotalDiscountedIncludingVAT().toString());
        sb.append("Amound paid:");
        appendLine(sb, saleInformation.getAmountPaid().toString());
        sb.append("Change");
        appendLine(sb, saleInformation.getChangeAmount().toString());
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