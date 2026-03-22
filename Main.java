import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        DocumentFile documentFile = new DocumentFile("file-001");
        documentFile.validate();
        System.out.println("DocumentFile validated: " + documentFile.getValidationStatus());

        Shop shop = new Shop("shop-001", "PrintHub Central");

        PrintSpec printSpec = new PrintSpec("A4", "COLOR", 2, false);

        PrintOrder printOrder = new PrintOrder("customer-001", "shop-001", "file-001", printSpec);
        System.out.println("PrintOrder created: " + printOrder.getOrderId());

        double totalPrice = shop.calculateTotal(printOrder.getOrderId(), 150.0);
        printOrder.setTotalPrice(totalPrice);
        System.out.println("Total price: " + totalPrice);

        PaymentTransaction payment = new PaymentTransaction(printOrder.getOrderId(), totalPrice);
        boolean success = payment.validate();
        System.out.println("Payment valid: " + success);

        if (success) {
            payment.markSuccess();
            String status = shop.updateStatus("CONFIRMED");
            printOrder.updateStatus(status);
            System.out.println("Order status: " + printOrder.getStatus());
        }
    }
}
