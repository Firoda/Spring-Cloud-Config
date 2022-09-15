package com.mettl.cloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

    @Value("${custom.greeting}")
    private String greeting;

    @Value("$mpaas-gateway.props{sso.whitelisted.clientIds}")
    private String clientIds;

    @Value("")


    @GetMapping("/greeting")
    public String getGreeting(){
        return "(This value is being read from the file defined in spring.cloud.config.name )The greeting config value is: "  + greeting;
    }

    @GetMapping("/clientId")
    public String getClientIds(){
        return "We are now reading a property with $mpaas-gateway.props{} and the value is: " + clientIds;
    }
}
