package com.example.tradeinfo.stock;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.List;

/*bond uses*/
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Rows {
    @JacksonXmlElementWrapper(localName = "row", useWrapping = false)
    private List<RowData> row;
}
