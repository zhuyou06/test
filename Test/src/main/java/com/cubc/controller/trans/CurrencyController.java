package com.cubc.controller.trans;

import com.cubc.model.req.trans.CurrencyReq;
import com.cubc.model.res.trans.CurrencyRes;
import com.cubc.service.tran.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService service;

    @PostMapping
    @Operation(summary = "新增貨幣資訊", description = "新增貨幣資訊")
    public ResponseEntity<CurrencyRes> add(@RequestBody @Valid CurrencyReq req, BindingResult bindingResult)  {
        this.service.add(req);
        return ResponseEntity.ok(new CurrencyRes(req.getCode(),req.getName()));
    }

    @GetMapping()
    @Operation(summary = "查詢貨幣資訊", description = "查詢貨幣資訊")
    public ResponseEntity<List<CurrencyRes>> query() {
        return ResponseEntity.ok(this.service.query());
    }

    @GetMapping("/{code}")
    @Operation(summary = "查詢貨幣資訊", description = "查詢貨幣資訊")
    public ResponseEntity<CurrencyRes> query(@PathVariable("code") String code) {
        return ResponseEntity.ok(this.service.query(code));
    }

    @DeleteMapping("/{code}")
    @Operation(summary = "刪除貨幣資訊", description = "刪除貨幣資訊")
    public ResponseEntity<Void> delete(@PathVariable("code") String code) {
        this.service.delete(code);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Operation(summary = "更新貨幣資訊", description = "更新貨幣資訊")
    public ResponseEntity<CurrencyRes> update(@RequestBody @Valid CurrencyReq req) {
        this.service.update(req);
        return ResponseEntity.ok(new CurrencyRes(req.getCode(),req.getName()));
    }
 }
