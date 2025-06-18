package com.cubc.controller.parse;

import com.cubc.constant.ApiConst;
import com.cubc.controller.BaseController;
import com.cubc.model.ApiReqBase;
import com.cubc.model.ApiResBase;
import com.cubc.model.req.parse.GetCoinDeskReq;
import com.cubc.model.res.parse.GetCoinDeskRes;
import com.cubc.service.parse.GetCoinDeskService;
import com.cubc.service.tran.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

@RestController
@Slf4j
@Tag(name = "account")
public class GetCoinDeskController extends BaseController<GetCoinDeskReq, GetCoinDeskRes> {

    @Autowired
    private GetCoinDeskService service;

    @Override
    @PostMapping(value = "v1/account/getCoinDesk", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "取得貨幣資訊", description = "取得貨幣資訊", operationId = "getCoinDesk")
    public ApiResBase<GetCoinDeskRes> execute(ApiReqBase<GetCoinDeskReq> req, BindingResult bindingResult) throws NoSuchAlgorithmException, ParseException, IOException, JAXBException {
         return result(this.service.query(req.getParams()));
    }

    @Override
    public ApiConst.ApiUUID apiUid() {
        return ApiConst.ApiUUID.GET_COIN_DESK;
    }
}
