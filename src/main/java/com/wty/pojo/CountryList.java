package com.wty.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @Author wangtengyu
 * @Create 2018-04-24-16:02
 */
@XmlRootElement(name = "China")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class CountryList {

    @XmlElement(name = "country")
    private List<Country> countryList;
}
