import java.time.LocalDateTime;

public class Shop {
    private String shopId;
    private String name;
    private String description;
    private String contactPhone;
    private String openingHours;
    private LocalDateTime createdAt;

    public Shop(String shopId, String name) {
        this.shopId = shopId;
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

    public double calculateTotal(String orderId, double price) {
        return price;
    }

    public String updateStatus(String newStatus) {
        return newStatus;
    }

    public String getShopId() { return shopId; }
    public String getName() { return name; }
}
