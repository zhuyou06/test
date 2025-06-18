package com.cubc.controller.trans;

import com.cubc.constant.ApiConst;
import com.cubc.controller.BaseController;
import com.cubc.model.ApiReqBase;
import com.cubc.model.ApiResBase;
import com.cubc.model.req.trans.AddCurrencyReq;
import com.cubc.model.res.trans.AddCurrencyRes;
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
public class AddCurrencyController extends BaseController<AddCurrencyReq, AddCurrencyRes> {

    @Autowired
    private CurrencyService service;

    @Override
    @PostMapping(value = "v1/trans/addCurrency", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "新增貨幣資訊", description = "新增貨幣資訊", operationId = "addCurrency")
    public ApiResBase<AddCurrencyRes> execute(@RequestBody @Valid ApiReqBase<AddCurrencyReq> req, BindingResult bindingResult)  {
        System.out.println("收到請求: " + req); // Debug
        this.service.add(req.getParams());
        return result(new AddCurrencyRes());
    }

    @Override
    public ApiConst.ApiUUID apiUid() {
        return ApiConst.ApiUUID.ADD_CURRENCY;
    }
}
