package com.dianziban.bbs.controller;

import com.dianziban.bbs.service.BbsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    BbsService bbsService;

    @RequestMapping(path = {"/","/index"},method = {RequestMethod.GET})
    @ResponseBody
    public String index(HttpSession httpSession){
        logger.info("VISIT HOME");
        return  bbsService.getMessage(2) + "Hello JRI bbs"+ httpSession.getAttribute("msg");
    }

    @RequestMapping(path = {"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("userId") int userId,
                          @PathVariable("groupId") String groupId,
                          @RequestParam(value = "type",defaultValue = "1") int type,
                          @RequestParam(value = "key",defaultValue = "false") String key){
        return String.format("Profile Page of %s / %d, t: %d k: %s",groupId,userId,type,key);
    }

    @RequestMapping(path = {"/vm"},method ={RequestMethod.GET})
    public String template(Model model){
        model.addAttribute("value1","vvvvv1");
        return "home";
    }

}
