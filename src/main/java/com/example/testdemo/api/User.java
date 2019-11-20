package com.example.testdemo.api;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userId;
    private String userName;
    private String cardType;
    private String cardNum;
    private String phone;
    private String flag;
    private Date createTime;
    private Date updateTime;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
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
