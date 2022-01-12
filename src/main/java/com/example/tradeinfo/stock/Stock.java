package com.example.tradeinfo.stock;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
@Accessors(chain = true)
@JacksonXmlRootElement(localName = "document")
public class Stock {
    @JacksonXmlElementWrapper(localName = "data", useWrapping = false)
    private List<DataStock> data;
}
