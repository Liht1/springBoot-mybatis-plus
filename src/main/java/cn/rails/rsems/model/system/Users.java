package cn.rails.rsems.model.system;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhongjian on 2017-3-14.
 * 用户表
 *
 */
@SuppressWarnings("serial")
@TableName("D_USERS")
public class Users extends Model<Users> {

    @TableId
    private String guid;

    /** 名称 */
    @TableField("LOGINNAME")
    private String loginName;
    @TableField("USERNAME")
    private String userName;
    @TableField("PASSWORD")
    private String passWord;
    @TableField("PINYIN")
    private String pinyin;
    @TableField("STATE")
    private String state;
    @TableField("TEL")
    private Date tel;
    @TableField("CREATEPERSONCODE")
    private String createPersonCode;

    @TableField("CREATETIME")
    private String createTime;

    @TableField("COMMENTS")
    private String comments;

    @Override
    protected Serializable pkVal() {
        return guid;
    }


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getTel() {
        return tel;
    }

    public void setTel(Date tel) {
        this.tel = tel;
    }

    public String getCreatePersonCode() {
        return createPersonCode;
    }

    public void setCreatePersonCode(String createPersonCode) {
        this.createPersonCode = createPersonCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
