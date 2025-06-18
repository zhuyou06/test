package com.cubc.model.req.trans;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UpdateCurrencyReq {

    @NotBlank
    @Size(max = 4)
    @Schema(description = "幣別代碼", example = "USD")
    private String code;

    @NotBlank
    @Size(max = 100)
    @Schema(description = "幣別名稱", example = "美金")
    private String name;
}
