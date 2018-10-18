package com.example.demo.controller;

import com.example.demo.repository.IUserMapper;
import com.example.demo.repository.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

////////////////////////////////

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserMapper userMapper;

    @GetMapping(value = "/message")
//    @ResponseBody
    public Map<String, String> userMessage() {
        Map<String, String> userMessage = new HashMap<>();
        userMessage.put("name", "admin");
        userMessage.put("password", "123456");
        userMessage.put("other", "some");
        int a = 2;
        if(1 < a  && a < 3){

        }
        return userMessage;
    }

    @GetMapping(value = "/info")
//    @ResponseBody
    public Map<String, String> getUser() {
        Map<String, String> user = new HashMap<>();
        System.out.println(this.userMapper);
        UserDto userDto = this.userMapper.selectUserById("asdf1");
        System.out.println(userDto.getName());
        user.put("age",userDto.getAge());
        return user;
    }

    @RequestMapping("/getUsers")
    public List<UserDto> getUsers() {
//        List<UserDto> list = new ArrayList<UserDto>();
        List<UserDto> list = (List<UserDto>) this.userMapper.selectUsers();
        return list;
    }

    @GetMapping(value = "/update/{id}")
//    @ResponseBody
    public Map<String, String> updateUser(@PathVariable String id) {
        Map<String, String> user = new HashMap<>();
        System.out.println(this.userMapper+":updateUser");
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName("aaaa");
        String name = "a1aa";
        int num;
        num = this.userMapper.updateUserById(name,id);
        System.out.println(num);
        user.put("num",num+"");
        return user;
    }
    @RequestMapping("/insert")
    public Map insert(){
        Map result = new HashMap();
        UserDto userDto = new UserDto();
        userDto.setId("asdf3");
        userDto.setName("c");
        userDto.setAge("16");
        int num;
        num = this.userMapper.insertUser(userDto);
        result.put("num",num);
        return result;
    }

    @RequestMapping(value = "/delete")
    public String deleteUser() {
        Map<String, String> user = new HashMap<>();
        System.out.println("deleteUser");
        int i = this.userMapper.deleteUser("asdf1");
        user.put("num",i+"");
        return i+"";
    }

    @RequestMapping("/insertBatch")
    public void insertBatch(){
        List<UserDto> list = new ArrayList<UserDto>();
        UserDto ud;
        for(int i = 0; i < 2; i++){
            ud = new UserDto();
            ud.setAge("111222");
            ud.setName("name" + i + i);
            ud.setId("q" + i + i);
            list.add(ud);
        }
        try{
            int resultNum = this.userMapper.insertBatch(list);
            System.out.println(resultNum);
        }catch (Exception e){
            System.out.println("---------------->");
            e.printStackTrace();
            System.out.println("<------------------");
        }finally {
            System.out.println("end");
        }


    }


    @RequestMapping("/insertBatchTwo")
    @Transactional
    public Map insertBatchTwo() throws Exception{
        Map result = new HashMap();
        UserDto userDto;
        try{
            userDto = new UserDto();
            userDto.setId("asdf001");
            userDto.setName("c");
            userDto.setAge("16");
            this.userMapper.insertUser(userDto);
            userDto = new UserDto();
            userDto.setId("asdf001");
            userDto.setName("c");
            userDto.setAge("16");
            this.userMapper.insertUser(userDto);
            result.put("msg","success");
        }catch (Exception e){
//            e.printStackTrace();
            result.put("msg","fail");
        }
       return result;
    }
















}
