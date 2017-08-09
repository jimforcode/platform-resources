package cn.creatoo.controller.test;

import cn.creatoo.controller.system.AbstractController;
import cn.creatoo.model.common.R;
import cn.creatoo.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
@Controller
@RequestMapping("/test")
public class TestController extends AbstractController {
    @Autowired
    private TestService testService;

    @RequestMapping("/batchAdd")
    @ResponseBody
    public R batchAdd(int num){
        int res= this.testService.batchAdd(num);
        return R.ok(res);
    }
}
