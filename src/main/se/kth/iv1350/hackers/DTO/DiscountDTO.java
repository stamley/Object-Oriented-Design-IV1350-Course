package se.kth.iv1350.hackers.DTO;
import se.kth.iv1350.hackers.util.Amount;

/**
 * Contains information about discount type and percentage.
 */
public final class DiscountDTO{
    private Amount totalDiscountPercentage;
    private String typeOfDiscount;

    /**
     * Creates a new instance representing a discount data transferable object.
     * 
     * @param totalDiscountPercentage The total discount percentage.
     * @param typeOfDiscount The type of discount.
     */
    public DiscountDTO(Amount totalDiscountPercentage, String typeOfDiscount){
        this.totalDiscountPercentage = totalDiscountPercentage;
        this.typeOfDiscount = typeOfDiscount;
    }

    /**
     * Getter method for type of discount.
     * 
     * @return Type of discount
     */
    public String getTypeOfDiscount() {
        return this.typeOfDiscount;
    }

    /**
     * Getter method for total discount percentage.
     * 
     * @return Total discount percentage.
     */

    public Amount getTotalDiscountPercentage() {
        return this.totalDiscountPercentage;
    }

    @Override
    public boolean equals(Object otherObj){
        if(otherObj == null){
            return false;
        }
        if(this.getClass() != otherObj.getClass()){
            return false;
        }
        
        final DiscountDTO other = (DiscountDTO) otherObj;
        if(this.totalDiscountPercentage != other.totalDiscountPercentage){
            return false;
        }
        if(this.typeOfDiscount.equals(other.typeOfDiscount)){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Discount: " + totalDiscountPercentage.toString() + "\nType of discount: " + typeOfDiscount;
    }

}