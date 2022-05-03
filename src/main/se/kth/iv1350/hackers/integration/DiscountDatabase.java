package se.kth.iv1350.hackers.integration;
import se.kth.iv1350.hackers.DTO.DiscountDTO;
import se.kth.iv1350.hackers.util.Amount;

/**
 * A representation of a discount database.
 */
public class DiscountDatabase {
    /**
     * Creates an instance of discount DTO based on the customerID.
     * 
     * @param customerID Checks eligibility of discount.
     * @return An object of type discount dto.
     */
    public DiscountDTO discountRequest(int customerID){
        return new DiscountDTO(this.fetchDiscountAmountFromDatabase(customerID), 
                               this.fetchTypeOfDiscountFromDatabase(customerID));
    }
     /**
     * Placeholder method for fetching discount amount from discount database.
     * @return String with type of discount.
     * @param customerID Placeholder for checking eligibility in the future.
     */

    public Amount fetchDiscountAmountFromDatabase(int customerID){
        return new Amount(0.1);
    }

    /**
     * Placeholder method for fetching type of discount from discount database.
     * @return String with type of discount.
     * @param customerID Placeholder for checking eligibility in the future.
     */

    public String fetchTypeOfDiscountFromDatabase(int customerID){
        return "PlaceholderTypeOfDiscount";
    }
}
