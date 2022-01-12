package com.example.tradeinfo.bond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BondRowData {
    @JacksonXmlProperty(localName = "SECID")
    private String secId;
    @JacksonXmlProperty(localName = "SHORTNAME")
    private String shortName;
    @JacksonXmlProperty(localName = "LASTTOPREVPRICE")
    private String lastTopPrevPrice;
    @JacksonXmlProperty(localName = "PREVPRICE")
    private String prevPrice;
    @JacksonXmlProperty(localName = "COUPONVALUE")
    private double couponValue;
    @JacksonXmlProperty(localName = "ACCRUEDINT")
    private double accruedint;
    @JacksonXmlProperty(localName = "NEXTCOUPON")
    private String nextCouponDate;
    @JacksonXmlProperty(localName = "COUPONPERIOD")
    private int couponPeriod;
    @JacksonXmlProperty(localName = "MATDATE")
    private String matDate;
    @JacksonXmlProperty(localName = "LOTSIZE")
    private int lotSize;
    @JacksonXmlProperty(localName = "LAST")
    private double last;
    @JacksonXmlProperty(localName = "HIGH")
    private double high;
    @JacksonXmlProperty(localName = "LOW")
    private double low;
    @JacksonXmlProperty(localName = "OPEN")
    private double open;
    @JacksonXmlProperty(localName = "YIELDATWAPRICE")
    private double yieldatwaprice;
    @JacksonXmlProperty(localName = "DURATION")
    private double duration;
}
