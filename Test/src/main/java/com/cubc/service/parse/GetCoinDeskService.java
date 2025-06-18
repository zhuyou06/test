package com.cubc.service.parse;

//import com.cubc.comp.CDComp;
//import com.cubc.fegion.cd.res.CodeDeskRes;
import com.cubc.model.req.parse.GetCoinDeskReq;
import com.cubc.model.res.parse.GetCoinDeskRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class GetCoinDeskService {
    //@Autowired
    //private CDComp comp;

    public GetCoinDeskRes query(GetCoinDeskReq req) {
        //CodeDeskRes res = this.comp.query();
       // System.out.println("res = " + res);
        return null;
    }
}
