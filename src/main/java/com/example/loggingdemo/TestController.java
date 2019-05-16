package com.example.loggingdemo;

import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    TelemetryClient telemetryClient;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getTest()
    {
        //track a custom event
        telemetryClient.trackEvent("getTest invoked");
        return new ResponseEntity<>("{\"message\":\"App running!\"}", HttpStatus.OK);
    }
}
