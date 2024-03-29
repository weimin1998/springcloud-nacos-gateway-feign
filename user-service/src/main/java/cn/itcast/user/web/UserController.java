package cn.itcast.user.web;

import cn.itcast.user.config.NacosConfig;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


//    @Autowired
//    private NacosConfig config;
    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id, @RequestHeader(value = "name",required = false)String name) {
        System.out.println("name: "+ name);
        return userService.queryById(id);
    }

//    @GetMapping("/nacosconfig")
//    public String nacosconfig() {
//        return config.getName() + config.getAge();
//    }
}
