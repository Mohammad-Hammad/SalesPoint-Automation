package org.example;
public class SharedContext {
    private static SharedContext instance;
    private String ICCID;

    // Private constructor for singleton
    private SharedContext() {}

    // Get the singleton instance
    public static SharedContext getInstance() {
        if (instance == null) {
            instance = new SharedContext();
        }
        return instance;
    }

    // Getter and setter for ICCID
    public String getICCID() {
        return ICCID;
    }

    public void setICCID(String ICCID) {
        this.ICCID = ICCID;
    }
}
