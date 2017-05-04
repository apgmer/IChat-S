package me.xiaotian.ichat.controller;

import me.xiaotian.ichat.entity.UserEntity;
import me.xiaotian.ichat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/")
    @ResponseBody
    public String index(){
        List<UserEntity> userEntities = userService.queryAllUser();
        return "xxxxxx";
    }

}
