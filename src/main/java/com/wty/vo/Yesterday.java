package com.wty.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author wangtengyu
 * @Create 2018-04-23-9:15
 */
@Getter
@Setter
public class Yesterday implements Serializable {

//    "yesterday": {
//        "date": "22日星期日",
//                "high": "高温 16℃",
//                "fx": "东北风",
//                "low": "低温 12℃",
//                "fl": "<![CDATA[3-4级]]>",
//                "type": "阴"
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
