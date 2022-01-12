package com.example.tradeinfo.excelreport;

import com.example.tradeinfo.bond.Bond;
import com.example.tradeinfo.bond.BondRowData;
import com.example.tradeinfo.stock.RowData;
import com.example.tradeinfo.stock.Stock;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
@Data
@RequiredArgsConstructor
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ExcelReport implements Report {

    private static final String SECID = "Тикер";
    private static final String SHORTNAME = "Бумага сокр";
    private static final String PREVPRICE = "Цена закр";
    private static final String LOTSIZE = "Лот";
    private static final String LASTTOPREVPRICE = "% изм закр";
    private static final String LAST = "Цена послед сд";
    private static final String HIGH = "Макс цена";
    private static final String LOW = "Мин цена";
    private static final String OPEN = "Открытие";
    private static final String YIELDATWAPRICE = "Доходность";
    private static final String DURATION = "Дюрация";
    private static final String COUPONVALUE = "Купон";
    private static final String ACCRUEDINT = "НКД";
    private static final String NEXTCOUPON = "Дата выпл купона";
    private static final String COUPONPERIOD = "Длительность купона";
    private static final String MATDATE = "Погашение";

    private final Workbook workbook;
    private Sheet sheet;


    @PostConstruct
    public void createFinalReport(Stock stock, Bond bond) throws IOException {
        createExcelSheet();
        createHeader();
        fillTable(stock, bond);
        writeReport();
    }


    private void fillTable(Stock stock, Bond bond) {
        fillStockFields(stock);
        fillBondFields(bond);

    }

    private void fillBondFields(Bond bond) {
        int rowCount = sheet.getLastRowNum() + 1;
        List<BondRowData> bondRowDataList = bond.getData().get(0).getRows().getRow();
        List<BondRowData> bondRowMarketData = bond.getData().get(1).getRows().getRow();
        for (BondRowData bondRow : bondRowDataList) {
            Row row = sheet.createRow(rowCount);
            String secId = bondRow.getSecId();
            BondRowData data = bondRowMarketData.stream().filter(x -> x.getSecId().equals(secId)).findAny().orElseThrow();
            Cell cell = row.createCell(0);
            cell.setCellValue(bondRow.getSecId());
            cell = row.createCell(1);
            cell.setCellValue(bondRow.getShortName());
            cell = row.createCell(2);
            cell.setCellValue(data.getLastTopPrevPrice());
            cell = row.createCell(3);
            cell.setCellValue(data.getLast());
            cell = row.createCell(4);
            cell.setCellValue(data.getHigh());
            cell = row.createCell(5);
            cell.setCellValue(data.getLow());
            cell = row.createCell(6);
            cell.setCellValue(data.getOpen());
            cell = row.createCell(7);
            cell.setCellValue(bondRow.getPrevPrice());
            cell = row.createCell(8);
            cell.setCellValue(bondRow.getLotSize());
            cell = row.createCell(9);
            cell.setCellValue(bondRow.getCouponValue());
            cell = row.createCell(10);
            cell.setCellValue(bondRow.getAccruedint());
            cell = row.createCell(11);
            cell.setCellValue(bondRow.getNextCouponDate());
            cell = row.createCell(12);
            cell.setCellValue(bondRow.getCouponPeriod());
            cell = row.createCell(13);
            cell.setCellValue(bondRow.getMatDate());
            cell = row.createCell(14);
            cell.setCellValue(data.getYieldatwaprice());
            cell = row.createCell(15);
            cell.setCellValue(data.getDuration());
            rowCount++;
        }
    }

    private void fillStockFields(Stock stock) {
        int rowCount = 1;
        List<RowData> rowStockDataList = stock.getData().get(0).getRows().getRow();
        List<RowData> rowStockMarketData = stock.getData().get(1).getRows().getRow();
        for (RowData rowData : rowStockDataList) {
            Row row = sheet.createRow(rowCount);
            String secId = rowData.getSecId();
            RowData data = rowStockMarketData.stream().filter(x -> x.getSecId().equals(secId)).findAny().orElseThrow();
            Cell cell = row.createCell(0);
            cell.setCellValue(rowData.getSecId());
            cell = row.createCell(1);
            cell.setCellValue(rowData.getShortName());
            cell = row.createCell(2);
            cell.setCellValue(data.getLastTopPrevPrice());
            cell = row.createCell(3);
            cell.setCellValue(data.getLast());
            cell = row.createCell(4);
            cell.setCellValue(data.getHigh());
            cell = row.createCell(5);
            cell.setCellValue(data.getLow());
            cell = row.createCell(6);
            cell.setCellValue(data.getOpen());
            cell = row.createCell(7);
            cell.setCellValue(rowData.getPrevPrice());
            cell = row.createCell(8);
            cell.setCellValue(rowData.getLotSize());
            rowCount++;

        }
    }

    private void createExcelSheet() {
        sheet = workbook.createSheet("ALLs");
    }

    private void createHeader() {
        Row header = sheet.createRow(0);
        CellStyle headerStyle = getCellStyle();
        Cell headerCell = header.createCell(0);
        headerCell.setCellValue(SECID);
        headerCell.setCellStyle(headerStyle);
        createHeaderCell(header, headerStyle, SHORTNAME, 1);
        createHeaderCell(header, headerStyle, LASTTOPREVPRICE, 2);
        createHeaderCell(header, headerStyle, LAST, 3);
        createHeaderCell(header, headerStyle, HIGH, 4);
        createHeaderCell(header, headerStyle, LOW, 5);
        createHeaderCell(header, headerStyle, OPEN, 6);
        createHeaderCell(header, headerStyle, PREVPRICE, 7);
        createHeaderCell(header, headerStyle, LOTSIZE, 8);
        createHeaderCell(header, headerStyle, COUPONVALUE, 9);
        createHeaderCell(header, headerStyle, ACCRUEDINT, 10);
        createHeaderCell(header, headerStyle, NEXTCOUPON, 11);
        createHeaderCell(header, headerStyle, COUPONPERIOD, 12);
        createHeaderCell(header, headerStyle, MATDATE, 13);
        createHeaderCell(header, headerStyle, YIELDATWAPRICE, 14);
        createHeaderCell(header, headerStyle, DURATION, 15);


    }

    private void createHeaderCell(Row header, CellStyle headerStyle, String value, Integer column) {
        Cell headerCell = header.createCell(column);
        headerCell.setCellValue(value);
        headerCell.setCellStyle(headerStyle);
    }

    private CellStyle getCellStyle() {
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 11);
        font.setBold(false);
        headerStyle.setFont(font);
        return headerStyle;
    }

    public void writeReport() throws IOException {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();
    }
}
