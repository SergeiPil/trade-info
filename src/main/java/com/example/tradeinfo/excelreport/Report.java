package com.example.tradeinfo.excelreport;

import com.example.tradeinfo.bond.Bond;
import com.example.tradeinfo.stock.Stock;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface Report {
    void createFinalReport(Stock stock, Bond bond) throws IOException;
}
