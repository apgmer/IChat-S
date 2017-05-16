package me.xiaotian.ichat.family.controller;

import me.xiaotian.ichat.entity.UserEntity;
import me.xiaotian.ichat.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by guoxiaotian on 2017/5/16.
 */
@RestController
@Secured("USER")
public class FamilyController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "hello world";
    }

}
