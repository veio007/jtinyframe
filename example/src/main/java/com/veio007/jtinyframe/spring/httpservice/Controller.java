package com.veio007.jtinyframe.spring.httpservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {

    // rpmt播放地址: rtmp://192.168.102.80 playpath=t3.mp4 app=ondemand?token=111
    @RequestMapping(value = "/auth", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> auth(HttpServletRequest request) {
        ResponseEntity<String> responseEntity = new ResponseEntity<String>("ok", HttpStatus.OK);
        System.out.println(request.getParameter("token"));
        return responseEntity;
    }

    @RequestMapping(value = "/play", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> paly(HttpServletRequest request) {
        ResponseEntity<String> responseEntity = new ResponseEntity<String>("ok", HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/done", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> done(HttpServletRequest request) {
        ResponseEntity<String> responseEntity = new ResponseEntity<String>("ok", HttpStatus.OK);
        return responseEntity;
    }
}
