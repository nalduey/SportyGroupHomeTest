package com.sportygroup.hometest.enums;

import java.util.stream.Stream;

public enum ProviderBetaEnum {
    MSG_TYPE_ODDS("ODDS"),

    MSG_TYPE_SETTLEMENT("SETTLEMENT"),
    HOME("home"),

    DRAW("draw"),

    AWAY("away");

    private final String nameConvention;

    ProviderBetaEnum(String nameConvention) {
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

    public static ProviderBetaEnum fromString(String value) {
        return Stream.of(ProviderBetaEnum.values())
                .filter(e -> e.nameConvention.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No BetaEnum for: " + value));
    }


}
