package com.cubc.service.parse;

import com.cubc.enums.CurrencyEnum;
import com.cubc.feign.CDClient;
import com.cubc.feign.cd.res.CodeDeskRes;
import com.cubc.model.req.parse.GetCoinDeskReq;
import com.cubc.model.res.parse.CurrencyRes;
import com.cubc.model.res.parse.GetCoinDeskRes;
import com.cubc.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
@Slf4j
public class GetCoinDeskService {

    private final CDClient cdClient;

    public GetCoinDeskService(CDClient cdClient) {
        this.cdClient = cdClient;
    }


    public GetCoinDeskRes query() {
        CodeDeskRes coinDeskRes = cdClient.getCodeDesk();
        GetCoinDeskRes coinDeskInfoRes = new GetCoinDeskRes();
        coinDeskInfoRes.setUpdatedTimeTW(DateUtil.formatDateTime(coinDeskRes.getTime().getUpdatedISO()));
        coinDeskInfoRes.setChartName(coinDeskRes.getChartName());
        coinDeskInfoRes.setCurrencyResList(
                coinDeskRes.getBpi().values().stream()
                .map(this::convertToCurrencyInfo)
                .collect(Collectors.toList()));
        return coinDeskInfoRes;
    }

    private CurrencyRes convertToCurrencyInfo(CodeDeskRes.Currency currency) {
        return CurrencyRes.builder()
                .code(currency.getCode())
                .name(CurrencyEnum.getName(currency.getCode()))
                .symbol(currency.getSymbol())
                .rate(currency.getRate())
                .rateFloat(currency.getRateFloat())
                .description(currency.getDescription())
                .build();
    }

}
