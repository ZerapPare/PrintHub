import java.time.LocalDateTime;

public class DocumentFile {
    private String fileId;
    private String uploaderCustomerId;
    private String originalName;
    private String fileType;
    private double sizeMB;
    private int pageCount;
    private String storageUrl;
    private LocalDateTime uploadedAt;
    private String validationStatus;

    public DocumentFile(String fileId) {
        this.fileId = fileId;
        this.uploadedAt = LocalDateTime.now();
        this.validationStatus = "PENDING";
    }

    public void validate() {
        if (fileId != null && !fileId.isEmpty()) {
            this.validationStatus = "VALID";
        } else {
            this.validationStatus = "INVALID";
        }
    }

    public String getFileId() { return fileId; }
    public String getValidationStatus() { return validationStatus; }
}
