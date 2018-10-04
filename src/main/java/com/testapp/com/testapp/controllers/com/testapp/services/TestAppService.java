package com.testapp.com.testapp.controllers.com.testapp.services;

import com.testapp.com.testapp.controllers.com.testapp.configurations.SSLByPassConfiguration;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@Service
public class TestAppService {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Value("${baseurl}")
    String baseUrl;

    @Value("${cboUrl}")
    String cboUrl;



    @PostConstruct
    public void init() throws KeyManagementException, NoSuchAlgorithmException {
        SSLByPassConfiguration.turnOffSslChecking();
    }

    public JSONObject getRestApiResponse(Integer store,String upc){

        String url= baseUrl+"store="+store+"&upc="+upc;

        System.out.print("base url is "+url);

        JSONObject result= restTemplate.getForObject(url,JSONObject.class);
        return result;

    }

    public JSONObject gatrestResponse(){

        return restTemplate.getForObject(cboUrl,JSONObject.class);
    }

}
