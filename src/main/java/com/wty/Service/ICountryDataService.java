package com.wty.Service;

import com.wty.pojo.Country;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

/**
 * @Author wangtengyu
 * @Create 2018-04-24-16:30
 */
public interface ICountryDataService {

    List<Country> getCountryList() throws IOException, JAXBException;

}
