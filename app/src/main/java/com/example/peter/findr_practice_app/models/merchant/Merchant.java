package com.example.peter.findr_practice_app.models.merchant;

/**
 * Created by peter on 11/29/17.
 */

public class Merchant {
    private boolean active;
    private String name;
    private String id;
    private MerchantInfo info;


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MerchantInfo getInfo() {
        return info;
    }

    public void setInfo(MerchantInfo info) {
        this.info = info;
    }
}
