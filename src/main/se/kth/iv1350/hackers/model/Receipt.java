package se.kth.iv1350.hackers.model;
import java.time.LocalDateTime;
import java.util.HashMap;

import se.kth.iv1350.hackers.DTO.*;

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
        appendLine(sb, "Point of sale");
        endSection(sb);

        LocalDateTime currentTime = LocalDateTime.now();
        sb.append("Sale time ");
        appendLine(sb, currentTime.toString());
        endSection(sb);

        sb.append("Sale ");

        HashMap<String, Item> items = saleInformation.getItemList();
        for (HashMap.Entry<String, Item> entry : items.entrySet()){
            String key = entry.getKey();
            Item value = entry.getValue();
            appendLine(sb,key);
            sb.append(value.getItemDescription().getItemName());
            sb.append(" " + Double.toString(value.getQuantity().getAmount()));
        }
        sb.append ("\n");

        sb.append("Total price: ");
        appendLine(sb, Double.toString(saleInformation.getTotalPrice().getTotal().getAmount()));
        sb.append("Total price incl. VAT: ");
        appendLine(sb, Double.toString(saleInformation.getTotalPrice().getTotalIncludingVAT().getAmount()));
        sb.append("Total price incl. VAT and discount: ");
        appendLine(sb, Double.toString(saleInformation.getTotalPrice().getTotalDiscountedIncludingVAT().getAmount()));
        sb.append("Amount paid: ");
        appendLine(sb, Double.toString(saleInformation.getAmountPaid().getAmount()));
        sb.append("Change: ");
        appendLine(sb, Double.toString(saleInformation.getChangeAmount().getAmount()));
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