package com.testapp.com.testapp.controllers;

import com.testapp.com.testapp.controllers.com.testapp.services.TestAppService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class TestControllers {

    @Autowired
    TestAppService testAppService;

    @RequestMapping(value = "/print",method = RequestMethod.GET)
    public String print(@PathParam(value = "id") String id
                        ){
        return "this is sample print method   "+id;

    }

    @RequestMapping(value = "/byProduct",method = RequestMethod.POST)
    public String byproduct(@PathParam(value = "store") String store,
                            @PathParam(value = "style") String upc){
        return "search by product values store: "+store+"  and style:  "+upc;


    }

    @RequestMapping(value = "/searchProduct",method = RequestMethod.GET)
    public  JSONObject getRestApiResponse(@PathParam(value = "store") Integer store,
                                          @PathParam(value = "upc") String upc){
        return  testAppService.getRestApiResponse(store,upc);

    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public JSONObject getRestResponseSSl(){
        return testAppService.gatrestResponse();

    }



}
