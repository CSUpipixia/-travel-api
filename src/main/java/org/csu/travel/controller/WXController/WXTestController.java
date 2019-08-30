package org.csu.travel.controller.WXController;

import org.csu.travel.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.csu.travel.result.ResultFactory.buildSuccessResult;

@Controller
public class WXTestController {
    /**
     * 控制器，前后端分离用的不同协议和端口，所以需要加入@CrossOrigin支持跨域。
     */
    @CrossOrigin
    @RequestMapping(value = "/wx/test", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result test() {
        return buildSuccessResult("Hello, WX");
    }
}
