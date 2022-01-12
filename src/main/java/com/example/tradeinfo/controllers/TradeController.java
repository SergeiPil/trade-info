package com.example.tradeinfo.controllers;

import com.example.tradeinfo.bond.Bond;
import com.example.tradeinfo.client.ActionsApiClient;
import com.example.tradeinfo.client.BondsApiClient;
import com.example.tradeinfo.parsers.StockParser;
import com.example.tradeinfo.service.CreatorExcelReport;
import com.example.tradeinfo.service.CreatorReport;
import com.example.tradeinfo.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Component
@RestController
public class TradeController {
    @Autowired
    private StockParser stockParser;
    @Autowired
    private ActionsApiClient actionsApiClient;
    @Autowired
    private BondsApiClient bondsApiClient;
    @Qualifier("creatorExcelReport")
    @Autowired
    private CreatorReport report;
    @Autowired
    private CreatorExcelReport creatorExcelReport;

    @GetMapping("/report")
    public void getReport() throws IOException {
        generateReport();

    }

    private void generateReport() throws IOException {
        String actionsApiResponse = actionsApiClient.getActionRequest();
        Stock stock = stockParser.parseStock(actionsApiResponse);
        String bondsApiResponse = bondsApiClient.getBondsRequest();
        Bond bond = stockParser.parseBond(bondsApiResponse);
        report = creatorExcelReport;
        report.returnReport(stock, bond);

    }

}
