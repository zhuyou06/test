package com.cubc.controller;

import com.cubc.constant.ApiConst;
import com.cubc.constant.MessageConst;
import com.cubc.model.ApiReqBase;
import com.cubc.model.ApiResBase;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

@RequestMapping("api/")
public abstract class BaseController<E, T> {
    public abstract ApiResBase<T> execute(ApiReqBase<E> req, BindingResult bindingResult) throws NoSuchAlgorithmException, ParseException, IOException, JAXBException;

    /**
     * success response
     *
     * @param result
     * @return
     */
    public ApiResBase<T> result(T result) {
        ApiResBase<T> apiResBase = new ApiResBase<>();
        MessageConst.RtnCode rtnCode = MessageConst.RtnCode.SUCCESS;
        apiResBase.setMsgCode(rtnCode.getCode());
        apiResBase.setMsgContent(rtnCode.getDescription());
        apiResBase.setResult(result);
        return apiResBase;
    }

    public abstract ApiConst.ApiUUID apiUid();
}
