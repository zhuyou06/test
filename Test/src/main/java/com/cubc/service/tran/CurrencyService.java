package com.cubc.service.tran;

import com.cubc.constant.MessageConst;
import com.cubc.entity.Currency;
import com.cubc.error.CubcException;
import com.cubc.model.req.trans.CurrencyReq;
import com.cubc.model.req.trans.DeleteCurrencyReq;
import com.cubc.model.req.trans.QueryCurrencyReq;
import com.cubc.model.req.trans.UpdateCurrencyReq;
import com.cubc.model.res.trans.CurrencyRes;
import com.cubc.model.res.trans.QueryCurrencyRes;
import com.cubc.repository.CurrencyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Slf4j
@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository repository;

    public void add(CurrencyReq req) {
        com.cubc.entity.Currency currency = Currency.builder()
                .id(req.getCode())
                .name(req.getName())
                .build();

        this.repository.save(currency);
    }

    public List<CurrencyRes> query() {
        List<com.cubc.entity.Currency> currecnyList = this.repository.findAll();

        return currecnyList.stream()
                .map(cur -> CurrencyRes.builder()
                        .code(cur.getId())
                        .name(cur.getName())
                        .build())
                .collect(Collectors.toList());
    }

    public CurrencyRes query(String code) {
        com.cubc.entity.Currency cur = this.repository.findById(code).orElseThrow(()-> new CubcException(MessageConst.RtnCode.M9901));

        return CurrencyRes.builder()
                .code(cur.getId())
                .name(cur.getName())
                .build();
    }

    public void update(CurrencyReq req) {
        Currency currency = this.repository.findById(req.getCode()).orElseThrow(() -> new CubcException(MessageConst.RtnCode.M9901));
        currency.setName(req.getName());
        this.repository.save(currency);
    }

    public void delete(String code) {
        Currency currency = this.repository.findById(code).orElseThrow(() -> new CubcException(MessageConst.RtnCode.M9901));
        this.repository.delete(currency);
    }
}
