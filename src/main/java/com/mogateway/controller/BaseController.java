package com.mogateway.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-04-24.
 */
@Controller
public class BaseController {

    protected Map<String, Object> map = new HashMap<String, Object>();

    protected Logger logger = Logger.getLogger(this.getClass());

    protected HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return  request;
    }

    protected HttpSession getSession() {
        return  this.getRequest().getSession();
    }
}
