package tcu.se2018.springmvc.api;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:8081")
@RestController
public class HelloController {

    // REST API:
    // url
    // HTTP METHOD:
    //      GET：只从服务器读取资源数据
    //      POST：往服务器增加资源，比如说发表一篇博客
    //      PUT：修改服务器上的资源
    //      DELETE：删除服务器上的资源
    // REQUEST PARAMETER
    //      url 参数，https://cn.bing.com/search?q=Spring+MVC&qs=n&form=QBLH&sp=-1&pq=spring+mvc&sc=8-10&sk=&cvid=1B23F1A79E5648C1B2A9A0645F200114
    //      body 参数：post 方法的表单
    // Request 内容类型
    // Response (Status Code)
    // Response 内容类型
    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "name", defaultValue = "Spring Boot") String surname) {
        return "Hello, " + surname;
    }

    @GetMapping("/hello/{name}")
    public String sayHello2(@PathVariable String name) {
        return "Hello, " + name + " Again!";
    }
}
