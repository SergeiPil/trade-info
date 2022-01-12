package com.example.tradeinfo.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActionsApiClient {

    public String getActionRequest() {
        RestTemplate restTemplate = new RestTemplate();
        String resource = "https://iss.moex.com/iss/engines/stock/markets/shares/boardgroups/57/securities.xml?iss.dp=comma&securities.columns=SECID,SHORTNAME,PREVPRICE,LOTSIZE,PREVDATA,&marketdata.columns=SECID,LASTTOPREVPRICE,LAST,HIGH,LOW,OPEN";
        ResponseEntity<String> response = restTemplate.getForEntity(resource, String.class);
        return response.getBody();
    }

}
