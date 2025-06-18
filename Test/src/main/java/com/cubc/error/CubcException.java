package com.cubc.error;

import com.cubc.constant.MessageConst;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class CubcException extends RuntimeException{

    /**
     * 錯誤代碼
     */
    private final String returnCode;
    /**
     * log exception 訊息
     */
    private final String extInfo;
    /**
    /**
     * 錯誤參數
     */
    private final String[] params;


    public CubcException(MessageConst.RtnCode rtnCode) {
        this(rtnCode.getCode(), rtnCode.getDescription());
    }

    public CubcException(MessageConst.RtnCode rtnCode, String extInfo) {
        this(rtnCode.getCode(), extInfo);
    }

    public CubcException(String returnCode, String extInfo) {
        super(String.format("%s%s", StringUtils.trim(returnCode),
                extInfo));
        this.returnCode = StringUtils.trim(returnCode);
        this.extInfo = extInfo;
        this.params = new String[]{};
    }
}
