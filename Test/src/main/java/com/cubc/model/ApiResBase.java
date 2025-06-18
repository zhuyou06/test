package com.cubc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResBase<T> {

    @Schema(description = "回覆訊息代碼")
    @JsonProperty("msgCode")
    String msgCode;

    @Schema(description = "回覆訊息")
    @JsonProperty("msgContent")
    String msgContent;

    @JsonProperty("result")
    T result;
}
