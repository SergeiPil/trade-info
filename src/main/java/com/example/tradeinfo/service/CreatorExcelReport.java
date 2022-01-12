package com.example.tradeinfo.service;

import com.example.tradeinfo.excelreport.ExcelReport;
import com.example.tradeinfo.excelreport.Report;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatorExcelReport extends CreatorReport {

    private final Workbook workbook;

    @Override
    public Report createReport() {
        return new ExcelReport(workbook);
    }
}
