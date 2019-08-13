package io.iktech.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class MonitoringController {
    private static final Logger logger = LoggerFactory.getLogger(MonitoringController.class);

    @RequestMapping(value = "/healthz", method = RequestMethod.GET)
    public void health(HttpServletResponse httpServletResponse) {
        logger.debug("Health check endpoint accessed");
        httpServletResponse.setStatus(HttpStatus.OK.value());
    }

    @RequestMapping(value = "/ready", method = RequestMethod.GET)
    public void ready(HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.setStatus(HttpStatus.OK.value());
        } catch (UsernameNotFoundException e) {
            logger.debug("Ignoring user not found exception", e);
        } catch (Exception e) {
            httpServletResponse.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        }
    }
}
