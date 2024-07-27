package com.example.Port.Check;

public class PortCheckResponse {
    private boolean open;

    public PortCheckResponse(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}

