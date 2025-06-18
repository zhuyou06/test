package com.cubc.feign;

import com.cubc.config.FeignClientConfig;
import com.cubc.constant.FeignClientConst;
import com.cubc.feign.cd.res.CodeDeskRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = FeignClientConst.CLIENT_CD, url = "${coindesk.url}",
        configuration = FeignClientConfig.class)
public interface CDClient {

    @CrossOrigin(origins = {"*"})
    @GetMapping("/coindesk.json")
    CodeDeskRes getCodeDesk();
}
