package com.cubc.model.res.parse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCoinDeskRes {
    private String updatedTimeTW;
    private String chartName;
    private List<CurrencyRes> currencyResList;
}
