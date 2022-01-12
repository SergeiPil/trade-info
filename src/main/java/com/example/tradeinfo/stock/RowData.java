package com.example.tradeinfo.stock;


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
public class RowData {
    @JacksonXmlProperty(localName = "SECID")
    private String secId;
    @JacksonXmlProperty(localName = "SHORTNAME")
    private String shortName;
    @JacksonXmlProperty(localName = "PREVPRICE")
    private String prevPrice;
    @JacksonXmlProperty(localName = "LASTTOPREVPRICE")
    private double lastTopPrevPrice;
    @JacksonXmlProperty(localName = "LAST")
    private double last;
    @JacksonXmlProperty(localName = "HIGH")
    private double high;
    @JacksonXmlProperty(localName = "LOW")
    private double low;
    @JacksonXmlProperty(localName = "OPEN")
    private double open;
    @JacksonXmlProperty(localName = "LOTSIZE")
    private int lotSize;
    @JacksonXmlProperty(localName = "data_version")
    private String dataVersion;
    @JacksonXmlProperty(localName = "seqnum")
    private String seqNum;

}
