package com.wty.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author wangtengyu
 * @Create 2018-04-23-9:16
 */
@Getter
@Setter
public class ForeCast implements Serializable{
//    "forecast": [
//    {
//        "date": "23日星期一",
//            "high": "高温 19℃",
//            "fengli": "<![CDATA[3-4级]]>",
//            "low": "低温 9℃",
//            "fengxiang": "东北风",
//            "type": "多云"
//    },

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
