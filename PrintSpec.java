import java.time.LocalDateTime;

public class PrintSpec {
    private String paperSize;
    private String colorMode;
    private int copies;
    private boolean binding;
    private LocalDateTime pickupTime;
    private String notes;
    private boolean isVinyl;

    public PrintSpec(String paperSize, String colorMode, int copies, boolean binding) {
        this.paperSize = paperSize;
        this.colorMode = colorMode;
        this.copies = copies;
        this.binding = binding;
    }

    public String getPaperSize() { return paperSize; }
    public String getColorMode() { return colorMode; }
    public int getCopies() { return copies; }
    public boolean isBinding() { return binding; }
}
