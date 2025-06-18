package com.cubc.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class ApiConst {
    public enum ApiUUID {
        GET_COIN_DESK("取得幣別匯率資訊"),
        ADD_CURRENCY("新增幣別資訊"),

        QUERY_CURRENCY("更新幣別資訊"),
        UPDATE_CURRENCY("更新幣別資訊"),
        DELETE_CURRENCY("刪除幣別資訊"),
        ;

        String desc;

        ApiUUID(String desc) {
            this.desc = desc;
        }

        public String geDesc() {
            return desc;
        }

        public static ApiUUID findApiUUID(String txID) {
            return Arrays.stream(ApiUUID.values())
                    .filter(s -> s.name().equals(StringUtils.upperCase(txID)))
                    .findFirst().orElse(ApiUUID.GET_COIN_DESK);
        }
    }
}
