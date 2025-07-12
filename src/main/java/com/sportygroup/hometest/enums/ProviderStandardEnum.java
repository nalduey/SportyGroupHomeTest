package com.sportygroup.hometest.enums;

public enum ProviderStandardEnum {
    MSG_TYPE_ODDS("odds_update"),

    MSG_TYPE_SETTLEMENT("settlement"),
    HOME("home"),

    DRAW("draw"),

    AWAY("away");

    private final String nameConvention;

    ProviderStandardEnum(String nameConvention) {
        this.nameConvention = nameConvention;
    }

    @Override
    public String toString() {
        return nameConvention;
    }

}
