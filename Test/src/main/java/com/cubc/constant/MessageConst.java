package com.cubc.constant;

public class MessageConst {
    public enum RtnCode {

        SUCCESS("0000", "成功"),
        M9901("9901", "資料不存在"),
        M9908("9908", "格式有誤"),
        M9999("9999", "未知異常"),
        ;

        private final String code;
        private final String description;

        RtnCode(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }
}
