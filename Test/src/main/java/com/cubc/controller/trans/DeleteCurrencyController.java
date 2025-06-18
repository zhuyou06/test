package com.cubc.controller.trans;

import com.cubc.constant.ApiConst;
import com.cubc.controller.BaseController;
import com.cubc.model.ApiReqBase;
import com.cubc.model.ApiResBase;
import com.cubc.model.req.trans.DeleteCurrencyReq;
import com.cubc.model.res.trans.DeleteCurrencyRes;
import com.cubc.service.tran.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
//@Tag(name = "trans")
public class DeleteCurrencyController extends BaseController<DeleteCurrencyReq, DeleteCurrencyRes> {

    @Autowired
    private CurrencyService service;

    @Override
    @PostMapping(value = "v1/trans/deleteCurrency", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "更新貨幣資訊", description = "更新貨幣資訊", operationId = "deleteCurrency")
    public ApiResBase<DeleteCurrencyRes> execute(@RequestBody @Valid ApiReqBase<DeleteCurrencyReq> req, BindingResult bindingResult)  {
        this.service.delete(req.getParams());
        return result(new DeleteCurrencyRes());
    }

    @Override
    public ApiConst.ApiUUID apiUid() {
        return ApiConst.ApiUUID.DELETE_CURRENCY;
    }
}
