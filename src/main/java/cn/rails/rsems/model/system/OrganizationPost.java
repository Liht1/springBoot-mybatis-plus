package cn.rails.rsems.model.system;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
//import com.sun.javafx.sg.PGShape;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhongjian on 2017-3-14.
 * 组织机构岗位表
 *
 */
@SuppressWarnings("serial")
@TableName("D_ORGANIZATION_POST")
public class OrganizationPost extends Model<OrganizationPost> {


    @TableId
    private String guid;

    /** 名称 */
    @TableField("ORGANIZATIONID")
    private String organizationId;
    @TableField("POSTID")
    private String postId;
    @TableField("CREATEPERSONCODE")
    private String createPersonCode;
    @TableField("CREATETIME")
    private Date createTime;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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


    @Override
    protected Serializable pkVal() {
        return guid;
    }
}
