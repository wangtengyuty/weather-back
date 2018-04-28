package com.wty.Service.impl;

import com.wty.Service.ICountryDataService;
import com.wty.pojo.Country;
import com.wty.pojo.CountryList;
import com.wty.util.XmlUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author wangtengyu
 * @Create 2018-04-24-16:32
 */
@Service("iCountryDataService")
public class CountryDataServiceImpl implements ICountryDataService {


    @Override
    public List<Country> getCountryList() throws IOException, JAXBException {
        Resource resource=new ClassPathResource("city.xml");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuilder str=new StringBuilder();
        String line="";
        while ((line=bufferedReader.readLine())!=null){
            str=str.append(line);
        }
        CountryList countryList=(CountryList) XmlUtil.Xml2Object(CountryList.class,str.toString());
        return countryList.getCountryList();
    }
}
