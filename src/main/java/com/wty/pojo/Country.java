package com.wty.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author wangtengyu
 * @Create 2018-04-24-15:58
 */
@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Country {

    @XmlAttribute(name="id")
    private String cityId;

    @XmlAttribute(name="name")
    private String cityName;

    @XmlAttribute(name="weatherCode")
    private String cityKey;

}
