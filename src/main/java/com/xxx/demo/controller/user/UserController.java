package com.xxx.demo.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.xxx.demo.services.user.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 *
 * @author luomouren
 * @date 2017/6/4
 */
@RestController
@RequestMapping({"/user"})
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysUserService sysUserServices;

    @RequestMapping(value = "/registeredUser")
    @ResponseBody
    public String registeredUser(String userName, String realName, String cellphone, String emodelId, String password, String email, String description) {
        logger.info("registeredUser:userName:" + userName + ",realName:" + realName + ",cellphone:" + cellphone + ",emodelId:" + emodelId + ",password" + password + ",email" + email + ",description:" + description);
        JSONObject jsonObject = sysUserServices.registeredUser(userName, realName, cellphone, emodelId, password, email, description);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/modifyUserInfo")
    @ResponseBody
    public String modifyUserInfo(String userId, String userName, String realName, String cellphone, String emodelId, String email, String description) {
        logger.info("registeredUser:userId:" + userId + ",userName:" + userName + ",realName:" + realName + ",cellphone:" + cellphone + ",emodelId:" + emodelId + ",email" + email + ",description:" + description);
        JSONObject jsonObject = sysUserServices.modifyUserInfo(userId, userName, realName, cellphone, emodelId, email, description);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/modifyUserPassword")
    @ResponseBody
    public String modifyUserPassword(String userId, String oldPassword, String newPassword) {
        JSONObject jsonObject = sysUserServices.modifyUserPassword(userId, oldPassword, newPassword);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/resetUserPassword")
    @ResponseBody
    public String resetUserPassword(String userId, String newPassword) {
        JSONObject jsonObject = sysUserServices.resetUserPassword(userId, newPassword);
        return jsonObject.toJSONString();
    }
}


