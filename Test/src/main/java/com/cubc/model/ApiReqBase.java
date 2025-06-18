package com.cubc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiReqBase<T>{
    @Schema(description = "交易時間")
    @NotBlank
    @JsonProperty("txDateTime")
    private String txDateTime;

    @Schema(description = "channelID", example = "MB")
    @NotBlank
    @JsonProperty("channelID")
    private String channelID;

    @Schema(description = "phone device id", example = "ddwdwdwd")
    @JsonProperty("deviceUUID")
    private String deviceUUID;

    @Valid
    @JsonProperty("params")
    private T params;
}
