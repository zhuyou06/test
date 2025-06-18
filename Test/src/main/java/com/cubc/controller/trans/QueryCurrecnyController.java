package com.cubc.controller.trans;

import com.cubc.constant.ApiConst;
import com.cubc.controller.BaseController;
import com.cubc.model.ApiReqBase;
import com.cubc.model.ApiResBase;
import com.cubc.model.req.trans.QueryCurrencyReq;
import com.cubc.model.res.trans.QueryCurrencyRes;
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
public class QueryCurrecnyController extends BaseController<QueryCurrencyReq, QueryCurrencyRes> {

    @Autowired
    private CurrencyService service;

    @Override
    @PostMapping(value = "v1/trans/queryCurrency", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "查詢貨幣資訊", description = "查詢貨幣資訊", operationId = "queryCurrency")
    public ApiResBase<QueryCurrencyRes> execute(@RequestBody @Valid ApiReqBase<QueryCurrencyReq> req, BindingResult bindingResult) {
        return result(service.query(req.getParams()));
    }

    @Override
    public ApiConst.ApiUUID apiUid() {
        return ApiConst.ApiUUID.QUERY_CURRENCY;
    }
}

