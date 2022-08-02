package com.kjcManager.tools;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.kjcManager.util.DESUtil;

public class EncryptablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {  
	   public static String key = "FHGT4KHVJKVKV2KHCTBM";
	   public static String keySafe;
  
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)  
        throws BeansException {  
            try {  
            	keySafe=props.getProperty("key.safe")==null?"0":props.getProperty("key.safe"); 
            	  String username = props.getProperty("jdbc.username");  
                  if (username != null) {  
                  	props.setProperty("jdbc.username", DESUtil.decrypt(username,key));  
//                  	System.out.println(props.getProperty("jdbc.username"));
                  }  
                    
                  String password = props.getProperty("jdbc.password");  
                  if (password != null) {  
                  	props.setProperty("jdbc.password", DESUtil.decrypt(password,key)); 
                  }  
                    
                  String url = props.getProperty("jdbc.url");  
                  if (url != null) {  
                  	props.setProperty("jdbc.url",DESUtil.decrypt( url,key)); 
                  }  
                super.processProperties(beanFactory, props);  
            } catch (Exception e) {  
                e.printStackTrace();  
                throw new BeanInitializationException(e.getMessage());  
            }  
        } 
}