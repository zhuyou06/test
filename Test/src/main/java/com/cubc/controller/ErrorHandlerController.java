package com.cubc.controller;

import com.cubc.error.CubcException;
import com.cubc.model.ApiResBase;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.MissingFormatArgumentException;

@Slf4j
@RestControllerAdvice
public class ErrorHandlerController {


    /**
     * API自定義錯誤
     */
    @ExceptionHandler(CubcException.class)
    @ResponseBody
    public ApiResBase<Object> handleCubcExceptionn(CubcException e) {
        log.error("CubcException code:{}, extInfo:{}", e.getReturnCode(), e.getExtInfo());
        log.error("handleTCBPPNBException: ", e);
        return returnResponse( e.getReturnCode(), e.getExtInfo(), e.getParams());
    }

    /**
     * 包裝錯誤回應response
     */
    private ApiResBase<Object> returnResponse( String code, String extInfo, String[] params) {
        return ApiResBase.builder()
                .msgCode(code)
                .msgContent(extInfo)
                .build();
    }
}
