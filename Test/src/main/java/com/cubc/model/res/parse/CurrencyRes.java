package com.cubc.model.res.parse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRes {
    private String code;
    private String name;
    private String symbol;
    private String rate;
    private String description;
    private double rateFloat;
}
