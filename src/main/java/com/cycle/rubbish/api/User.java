package com.cycle.rubbish.api;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class User implements UserDetails {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userId;
    private String userName;
    private String password;
    private String cardType;
    private String cardNum;
    private String phone;
    private String flag;
    private Date createTime;
    private Date updateTime;

    private List<GrantedAuthority> authorityList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String cardType, String cardNum, String phone, String flag, Date createTime) {
        this.userName = userName;
        this.cardType = cardType;
        this.cardNum = cardNum;
        this.phone = phone;
        this.flag = flag;
        this.createTime = createTime;
    }

}
