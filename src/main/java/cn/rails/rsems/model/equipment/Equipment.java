package cn.rails.rsems.model.equipment;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * 设备实体
 * Created by 董立华 on 2017/3/14.
 */
@SuppressWarnings("serial")
@TableName("T_EQUIPMENT")
public class Equipment {

    private String guid;//主键
    private String equipmentCategoryId;//设备分类id
    private String positonId;//位置id
    private String name;//设备名称
    private String code;//编码
    private String qrCode;//二维码
    private Integer serviceState;//服务状态：1启用，0未启用，2待测试，3报废
    private Integer state;//状态，1包内，0保外
    private Integer levels;//1一级，2二级，3三级
    private Double price;//价格
    private String assetsCompanyCode;//企业字典资产单位
    private String maintainCompanyCode;//企业字典运维单位
    private String manufactCompanyCode;//企业字典制造单位
    private Date purchaseTime;//采购日期
    private Date runningTime;//运行日期
    private Date installTime;//安装日期
    private Date warrantyStartTime;//质保开始日期
    private Date warrantyEndTime;//质保结束日期
    private String materialCode;//物资
    private String fixedCode;//固定资产
    private String comments;//备注

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getEquipmentCategoryId() {
        return equipmentCategoryId;
    }

    public void setEquipmentCategoryId(String equipmentCategoryId) {
        this.equipmentCategoryId = equipmentCategoryId;
    }

    public String getPositonId() {
        return positonId;
    }

    public void setPositonId(String positonId) {
        this.positonId = positonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Integer getServiceState() {
        return serviceState;
    }

    public void setServiceState(Integer serviceState) {
        this.serviceState = serviceState;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAssetsCompanyCode() {
        return assetsCompanyCode;
    }

    public void setAssetsCompanyCode(String assetsCompanyCode) {
        this.assetsCompanyCode = assetsCompanyCode;
    }

    public String getMaintainCompanyCode() {
        return maintainCompanyCode;
    }

    public void setMaintainCompanyCode(String maintainCompanyCode) {
        this.maintainCompanyCode = maintainCompanyCode;
    }

    public String getManufactCompanyCode() {
        return manufactCompanyCode;
    }

    public void setManufactCompanyCode(String manufactCompanyCode) {
        this.manufactCompanyCode = manufactCompanyCode;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Date getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Date runningTime) {
        this.runningTime = runningTime;
    }

    public Date getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Date installTime) {
        this.installTime = installTime;
    }

    public Date getWarrantyStartTime() {
        return warrantyStartTime;
    }

    public void setWarrantyStartTime(Date warrantyStartTime) {
        this.warrantyStartTime = warrantyStartTime;
    }

    public Date getWarrantyEndTime() {
        return warrantyEndTime;
    }

    public void setWarrantyEndTime(Date warrantyEndTime) {
        this.warrantyEndTime = warrantyEndTime;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getFixedCode() {
        return fixedCode;
    }

    public void setFixedCode(String fixedCode) {
        this.fixedCode = fixedCode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}

