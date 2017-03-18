package cn.rails.rsems.model.system;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhongjian on 2017-3-14.
 * 权限表
 *
 */
@SuppressWarnings("serial")
@TableName("D_RIGHTS")
public class Rights extends Model<Rights> {


    @TableId
    private String guid;

    /** 名称 */
    @TableField("NAME")
    private String name;
    @TableField("PINYIN")
    private String pinyin;

    @TableField("PARENTID")
    private String parentId;

    @TableField("URL")
    private String url;

    @TableField("STATE")
    private  Integer state;

    @TableField("CREATEPERSONCODE")
    private String createPersonCode;
    @TableField("CREATETIME")
    private Date createTime;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreatePersonCode() {
        return createPersonCode;
    }

    public void setCreatePersonCode(String createPersonCode) {
        this.createPersonCode = createPersonCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
