package com.cubc.model.res.trans;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryCurrencyRes {

    @Schema(description = "幣別清單")
    private List<Currency> currencyList = new ArrayList<>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Currency {
        @Schema(description = "幣別代碼", example = "")
        private String code;
        @Schema(description = "幣別名稱", example = "")
        private String name;
    }
}
