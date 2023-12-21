package pageObjects.herokuApp;

public enum StartPageItems {
    DYNAMIC_CONTROLS ("Dynamic Controls"),
    FRAMES ("Frames");

    private String item;

    StartPageItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

}
