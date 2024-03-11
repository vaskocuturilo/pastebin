package com.example.pastebin.entity;

public enum DateStamp {
    KEEP_FOREVER("Keep Forever"),
    ONE_HOUR("One Hour"),
    ONE_DAY("One Day"),
    ONE_WEEK("One Week"),
    ONE_MONTH("One Month"),
    ONE_YEAR("One Year");

    private String expireTime;

    DateStamp(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getExpireTime() {
        return expireTime;
    }
}
