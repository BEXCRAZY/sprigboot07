package com.springboottest.springboot07.testService.learnspring;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.springboottest.springboot07.testService.learnspring.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @description:
 * @date: 2021/2/22
 **/
@Slf4j
@RestController
public class FoeExcel {

    @RequestMapping("/read")
    public String readData() {

        ArrayList<User> users = new ArrayList<>();

        File f = new File("F:\\BCODE\\a.xlsx");

        if (!f.exists()) {
            log.debug("文件不存在！");
            return "文件不存在";
        }

        AnalysisEventListener<User> userListener = ExcelUtils.getListener(users::addAll, 2);
        EasyExcel.read(f, User.class, userListener).sheet().doRead();

        return JSON.toJSONString(users);

    }

    @RequestMapping("/write")
    public String writeData() {

        ArrayList<User> users = new ArrayList<>();

        users.add(new User("zangsan", 15));
        users.add(new User("zangsa", 14));
        users.add(new User("zangs", 18));
        users.add(new User("zang", 15));
        users.add(new User("zan", 13));
        users.add(new User("za", 12));


        File f = new File("F:\\BCODE\\b.xlsx");


        EasyExcel.write(f, User.class).sheet().doWrite(users);

        return JSON.toJSONString(users);

    }

    //业务处理
    private Consumer<List<User>> buOperation(ArrayList<User> users) {
        return list -> users.addAll(list);
    }

    @RequestMapping("/easy")
    public String write() {

        ArrayList<User> users = new ArrayList<>();

        users.add(new User("zangsan", 15));
        users.add(new User("zangsa", 14));
        users.add(new User("zangs", 18));
        users.add(new User("zang", 15));
        users.add(new User("zan", 13));
        users.add(new User("za", 12));


        File f = new File("F:\\BCODE\\b.xlsx");

        String s = new ExcelUtils<User>().writeValue(users, f, new User());

        return s;

    }

    @PostMapping("/ok")
    public String read(@RequestParam("file") MultipartFile file) {

        List<User> users = new ExcelUtils<User>().readValue(file, new User(), 2, 1);

        users.stream().forEach(System.out::println);

        return JSON.toJSONString(users);

    }

}
