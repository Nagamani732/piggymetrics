package com.piggymetrics.account.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Data
public class Item {

    @NotNull
    @Length(min = 1, max = 20)
    private String title;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Currency currency;

    @NotNull
    private TimePeriod period;

    @NotNull
    private String icon;
}
