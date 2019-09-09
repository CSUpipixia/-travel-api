package org.csu.travel.controller.WXController;


import com.alibaba.fastjson.JSONObject;
import org.csu.travel.domain.Account;
import org.csu.travel.result.Result;
import org.csu.travel.service.AccountService;
import org.csu.travel.util.GenerateToken;
import org.csu.travel.util.WXAuth;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

import static org.csu.travel.result.ResultFactory.buildFailResult;
import static org.csu.travel.result.ResultFactory.buildSuccessResult;

@CrossOrigin
@Controller
public class WXLoginController {

    @Autowired
    private AccountService accountService;

    private WXAuth wxAuth;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result account(@RequestBody Map<String, String> map) throws JSONException {

        String code = map.get("code");
        String userId = map.get("userid");
        String password = map.get("password");

        Account account = new Account();
        account.setUsername(userId);
        account.setPassword(password);

        JSONObject jsonObject = wxAuth.getSessionKey(code);
        String session_key = (String) jsonObject.get("session_key");
        String openid = (String) jsonObject.get("openid");

        if (accountService.getAccount(userId) != null) {
            if (accountService.getAccount(account) != null) {
                if (account.getOpenid() == null) {
                    account.setOpenid(openid);
                    account.setSessionKey(session_key);
                    accountService.updateAccount(account);
                    String token = GenerateToken.getToken(account);
                    Map<String, Object> newMap = new HashMap<>();
                    newMap.put("account", account);
                    newMap.put("token", token);

                    JSONObject newObject = new JSONObject(newMap);
                    return buildSuccessResult(newObject);
                } else {
                    return buildSuccessResult(account);
                }
            } else {
                return buildFailResult("密码错误");
            }
        } else {
            return  buildFailResult("用户名不存在");
        }
    }
}
