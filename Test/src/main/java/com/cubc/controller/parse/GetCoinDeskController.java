package com.cubc.controller.parse;

import com.cubc.model.res.parse.GetCoinDeskRes;
import com.cubc.service.parse.GetCoinDeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/getCoinDesk")
public class GetCoinDeskController {

    @Autowired
    private GetCoinDeskService service;

    @GetMapping
    public ResponseEntity<GetCoinDeskRes> getCoinDeskData() {
        return ResponseEntity.ok(this.service.query());
    }
}
