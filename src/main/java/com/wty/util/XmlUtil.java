package com.wty.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @Author wangtengyu
 * @Create 2018-04-24-16:13
 */

public class XmlUtil {


    public static Object Xml2Object(Class<?> clazz,String xmlStr) throws JAXBException, IOException {
        Object xmlObject=null;
        Reader reader=null;
        JAXBContext jaxbContext=JAXBContext.newInstance(clazz);
        Unmarshaller unmarshal=jaxbContext.createUnmarshaller();
        reader=new StringReader(xmlStr);
        xmlObject=unmarshal.unmarshal(reader);
        if(null!=reader){
            reader.close();
        }

        return xmlObject;
    }
}
