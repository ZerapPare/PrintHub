import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // 1. Create DocumentFile and validate
        DocumentFile documentFile = new DocumentFile("file-001");
        documentFile.validate();
        System.out.println("DocumentFile validated: " + documentFile.getValidationStatus());

        // 2. Setup Shop
        Shop shop = new Shop("shop-001", "PrintHub Central");

        // 3. Setup PrintSpec
        PrintSpec printSpec = new PrintSpec("A4", "COLOR", 2, false);

        // 4. Create PrintOrder
        PrintOrder printOrder = new PrintOrder("customer-001", "shop-001", "file-001", printSpec);
        System.out.println("PrintOrder created: " + printOrder.getOrderId());

        // 5. Calculate total
        double totalPrice = shop.calculateTotal(printOrder.getOrderId(), 150.0);
        printOrder.setTotalPrice(totalPrice);
        System.out.println("Total price: " + totalPrice);

        // 6. Create PaymentTransaction and validate
        PaymentTransaction payment = new PaymentTransaction(printOrder.getOrderId(), totalPrice);
        boolean success = payment.validate();
        System.out.println("Payment valid: " + success);

        // 7. Update order status
        if (success) {
            payment.markSuccess();
            String status = shop.updateStatus("CONFIRMED");
            printOrder.updateStatus(status);
            System.out.println("Order status: " + printOrder.getStatus());
        }
    }
}
