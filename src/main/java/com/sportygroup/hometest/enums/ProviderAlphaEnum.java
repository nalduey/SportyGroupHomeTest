package com.sportygroup.hometest.enums;

import java.util.stream.Stream;

public enum ProviderAlphaEnum {
    MSG_TYPE_ODDS("odds_update"),

    MSG_TYPE_SETTLEMENT("settlement"),
    HOME("1"),

    DRAW("X"),

    AWAY("2");

    private final String nameConvention;

    ProviderAlphaEnum(String nameConvention) {
        this.nameConvention = nameConvention;
    }

    @Override
    public String toString() {
        return nameConvention;
    }

    public ProviderStandardEnum toStandard() {
        return switch (this) {
            case HOME -> ProviderStandardEnum.HOME;
            case DRAW -> ProviderStandardEnum.DRAW;
            case AWAY -> ProviderStandardEnum.AWAY;
            default -> throw new IllegalArgumentException("No standard mapping for: " + this);
        };
    }

    public static ProviderAlphaEnum fromString(String value) {
        return Stream.of(ProviderAlphaEnum.values())
                .filter(e -> e.nameConvention.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No AlphaEnum for: " + value));
    }


}
