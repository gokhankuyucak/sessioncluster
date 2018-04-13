package com.kuyucak.projects.sessionsample.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController
{
    private static Logger log = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("/")
    public String getIndex(Model model){
        setHostNameAndAddress(model);
        return "home";
    }

    @RequestMapping("/hello")
    public String getHello(Model model){
        setHostNameAndAddress(model);
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    private void setHostNameAndAddress(Model model){
        final InetAddress localHost;
        try {
            localHost = InetAddress.getLocalHost();
            model.addAttribute("host", localHost.getHostName());
            model.addAttribute("ip", localHost.getHostAddress());
        } catch (UnknownHostException e) {
            log.warn("An exception occurred while trying to determine the host and IP address: {}", e);
        }
    }
}
