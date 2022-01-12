package com.example.tradeinfo.service;

import com.example.tradeinfo.bond.Bond;
import com.example.tradeinfo.excelreport.Report;
import com.example.tradeinfo.stock.Stock;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public abstract class CreatorReport {
    public void returnReport(Stock stock, Bond bond) throws IOException {
        Report report = createReport();
        report.createFinalReport(stock, bond);
    }

    public abstract Report createReport();
}
