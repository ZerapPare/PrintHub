import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentTransaction {
    private String paymentId;
    private String orderId;
    private double amount;
    private String method;
    private String status;
    private String qrCodeData;
    private LocalDateTime paidAt;
    private String receiptNo;

    public PaymentTransaction(String orderId, double amount) {
        this.paymentId = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.amount = amount;
        this.status = "PENDING";
    }

    public boolean validate() {
        return orderId != null && amount > 0;
    }

    public void markSuccess() {
        this.status = "SUCCESS";
        this.paidAt = LocalDateTime.now();
        this.receiptNo = "RCP-" + System.currentTimeMillis();
        System.out.println("Payment marked SUCCESS, receipt: " + receiptNo);
    }

    public void markFailed() {
        this.status = "FAILED";
        System.out.println("Payment marked FAILED");
    }

    public String getPaymentId() { return paymentId; }
    public String getStatus() { return status; }
}
