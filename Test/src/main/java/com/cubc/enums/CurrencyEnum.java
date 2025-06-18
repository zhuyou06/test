package com.cubc.enums;

public enum CurrencyEnum {

    USD("USD", "美元"),
    EUR("EUR", "歐元"),
    GBP("GBP", "英鎊");

    private final String code;
    private final String name;

    CurrencyEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(String code) {
        for (CurrencyEnum currency : CurrencyEnum.values()) {
            if (currency.getCode().equals(code)) {
                return currency.getName();
            }
        }
        return "";
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
