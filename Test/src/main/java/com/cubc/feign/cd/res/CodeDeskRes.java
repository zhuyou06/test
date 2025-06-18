package com.cubc.feign.cd.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CodeDeskRes {
    public Time time;
    public String disclaimer;
    public String chartName;
    private Map<String, Currency> bpi;

    @Data
    @Builder
    public static class Currency {
        public String code;
        public String symbol;
        public String rate;
        public String description;
        @JsonProperty("rate_float")
        public double rateFloat;
    }


    @Data
    public static class Time {
        public String updated;
        public String updatedISO;
        public String updateduk;
    }
}
