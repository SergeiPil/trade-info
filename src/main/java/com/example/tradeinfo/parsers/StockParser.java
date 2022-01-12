package com.example.tradeinfo.parsers;

import com.example.tradeinfo.bond.Bond;
import com.example.tradeinfo.stock.Stock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Component;

@Component
public class StockParser {
    public Stock parseStock(String stockXML) throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.coercionConfigDefaults().setAcceptBlankAsEmpty(true);
        return objectMapper.readValue(stockXML, Stock.class);
    }

    public Bond parseBond(String bondXml) throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.coercionConfigDefaults().setAcceptBlankAsEmpty(true);
        return objectMapper.readValue(bondXml, Bond.class);
    }
}
