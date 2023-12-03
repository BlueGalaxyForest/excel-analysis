package com.forest.excelanalysis.easyexcel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DemoData {
    private String string;
    private Date date;
    private Double doubleData;
}
