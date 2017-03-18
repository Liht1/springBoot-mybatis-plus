package cn.rails.rsems.model.system;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhongjian on 2017-3-14.
 *
 * 单位类别单位表
 */

@SuppressWarnings("serial")
@TableName("D_COMPANYTYPE_COMPANY")
public class CompanyTypeCompany extends Model<CompanyTypeCompany> {


    @TableId
    private String guid;

    /** 名称 */
    @TableField("COMPANYTYPEID")
    private String companyTypeId;
    @TableField("COMPANYID")
    private String companyId;
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

    public String getCompanyTypeId() {
        return companyTypeId;
    }

    public void setCompanyTypeId(String companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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
