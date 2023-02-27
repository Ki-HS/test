package com.test.demo.controller;

import com.test.demo.Model.NewPwDto;
import com.test.demo.Model.User;
import com.test.demo.Service.UserService;
import com.test.demo.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    private final HttpServletResponse response;

//
//    @GetMapping("/login")
//    public ResponseEntity<HttpStatus> login(@RequestBody Map<String,Object> json){
//        String id= (String) json.get("id");
//        User user = userService.findUser(id);
//        if(user==null||user.getPw().equals((String)json.get("pw"))) return null;
//    }

    
    @GetMapping("/loginFail")
    public void loginFail(){
        String redirectURL = "http://localhost:3000/";
        try{
            response.sendRedirect(redirectURL);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @GetMapping("/login")
    public void loginSuccess(){
        String redirectURL = "http://localhost:3000/home";
        try{
            response.sendRedirect(redirectURL);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/logout")
    public void logoutSuccess(){
        String redirectURL = "http://localhost:3000/";
        try{
            response.sendRedirect(redirectURL);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signUp(@RequestBody User user){
        String pw = user.getPw();
        //user.setPw(new BCryptPasswordEncoder().encode(pw));
        userDao.signUp(user);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/signup/DupId")
    public ResponseEntity<HttpStatus> checkDupID(@RequestParam String id){
        if(userService.findUser(id)==null) return ResponseEntity.ok().body(HttpStatus.OK);
        else return null;
    }

    @GetMapping("/findID")
    public ResponseEntity<String> findId(@RequestParam String nickname, @RequestParam String email, @RequestParam String phone_number){

        String id = userDao.findID(nickname, email, phone_number);
        if(id==null) return null;
//        String t = userService.findID(json);
//        System.out.println(t);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/findPW")
    public ResponseEntity<String> findPW(@RequestParam String nickname, @RequestParam String email, @RequestParam String phone_number, @RequestParam String id){
        String pw = userDao.findPW(id, nickname, email, phone_number);
        if(pw==null) return null;
        return ResponseEntity.ok().body(pw);
    }

    @PostMapping("/changePW")
    public ResponseEntity<HttpStatus> changePW(@RequestBody NewPwDto newPwDto){
        User user = userDao.findUser(newPwDto.getId());
        user.setPw(newPwDto.pw);
        //user.setPw(new BCryptPasswordEncoder().encode(newPwDto.getPw()));
        userDao.updateUser(user);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

}
