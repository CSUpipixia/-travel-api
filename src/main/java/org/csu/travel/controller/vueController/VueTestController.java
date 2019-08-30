package org.csu.travel.controller.vueController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class VueTestController {
    /**
     * 控制器，前后端分离用的不同协议和端口，所以需要加入@CrossOrigin支持跨域。
     */
    @CrossOrigin
    @RequestMapping(value = "/vue/test", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String test() {
        return "Hello, VUE";
    }
}
