package com.example.tradeinfo.bond;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class BondRows {
    @JacksonXmlElementWrapper(localName = "row", useWrapping = false)
    private List<BondRowData> row;
}
