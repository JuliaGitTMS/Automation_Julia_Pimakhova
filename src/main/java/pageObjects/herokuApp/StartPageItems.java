package pageObjects.herokuApp;

public enum StartPageItems {
    DYNAMIC_CONTROLS("Dynamic Controls"),
    FRAMES("Frames"),
    SORTABLE_DATA_TABLES("Sortable Data Tables");

    private String item;

    StartPageItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

}
