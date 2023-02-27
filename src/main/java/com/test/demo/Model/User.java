package com.test.demo.Model;


import lombok.*;

import java.util.ArrayList;
import java.util.Collection;


@Getter
@Setter
@Builder
public class User {
    private String id;
    private String pw;
    private String nickname;
    private int age;
    private String email;
    private String phoneNumber;
    private char sex;
    private String adminAuth;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> collection = new ArrayList<>();
//        collection.add(() -> {
//                return adminAuth;
//        });
//        return collection;
//    }

    public String getPassword() {
        return pw;
    }

    public String getUsername() {
        return id;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
