package com.cubc.aop.aspect;

import com.cubc.constant.AOPConst;
import com.cubc.constant.MessageConst;
import com.cubc.error.CubcException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Slf4j
@Aspect
@Component
//@Order(REQ_VALIDATE_ORDER)
public class RequestValidAspect {
    /**
     * 攔截點
     * @param bindingResult
     */
    @Before(value = AOPConst.POINTCUT_WEBLAYER + "&& args(.., bindingResult) ")
    public void requestValid(BindingResult bindingResult) {
        validRequestParams(bindingResult);
    }

    /**
     * param 是否有檢核錯誤
     * @param result
     */
    private void validRequestParams(BindingResult result) {
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(i->log.error("fieldError res: {}.{} = {}", i.getObjectName(),
                    i.getField(), i.getDefaultMessage()));
            FieldError fieldError = result.getFieldErrors().get(0);
            throw new CubcException(MessageConst.RtnCode.M9908, String.format("%s.%s: %s",
                    fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage()));
        }
    }
}
