package com.example.tradeinfo.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BondsApiClient {
    public String getBondsRequest() {
        RestTemplate restTemplate = new RestTemplate();
        String resource = "https://iss.moex.com/iss/engines/stock/markets/bonds/boardgroups/58/securities.xml?iss.dp=comma&securities.columns=SECID,SHORTNAME,COUPONVALUE,ACCRUEDINT,NEXTCOUPON,COUPONPERIOD,MATDATE,PREVPRICE,LOTSIZE&marketdata.columns=SECID,LASTTOPREVPRICE,LAST,HIGH,LOW,OPEN,YIELDATWAPRICE,DURATION";
        ResponseEntity<String> response = restTemplate.getForEntity(resource, String.class);
        return response.getBody();
    }
}
