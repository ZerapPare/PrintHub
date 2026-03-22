import java.time.LocalDateTime;
import java.util.UUID;

public class PrintOrder {
    private String orderId;
    private String orderNo;
    private String customerId;
    private String shopId;
    private String fileId;
    private PrintSpec printSpec;
    private String status;
    private LocalDateTime createdAt;
    private double totalPrice;

    public PrintOrder(String customerId, String shopId, String fileId, PrintSpec printSpec) {
        this.orderId = UUID.randomUUID().toString();
        this.orderNo = "ORD-" + System.currentTimeMillis();
        this.customerId = customerId;
        this.shopId = shopId;
        this.fileId = fileId;
        this.printSpec = printSpec;
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }

    public double calculateTotal() {
        return totalPrice;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public String getOrderId() { return orderId; }
    public String getStatus() { return status; }
    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
