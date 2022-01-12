package com.example.tradeinfo.configs;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigXML {
    @Bean
    public Workbook workbook() {
        return new XSSFWorkbook();
    }
}
