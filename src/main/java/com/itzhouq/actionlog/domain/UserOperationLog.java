package com.itzhouq.actionlog.domain;

import java.util.Date;

public class UserOperationLog {
    private Integer id;

    private Long userId;

    private String username;

    private String pageName;

    private String pageContent;

    private String operateButton;

    private Byte organizationLevel;

    private Byte operateType;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName == null ? null : pageName.trim();
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent == null ? null : pageContent.trim();
    }

    public String getOperateButton() {
        return operateButton;
    }

    public void setOperateButton(String operateButton) {
        this.operateButton = operateButton == null ? null : operateButton.trim();
    }

    public Byte getOrganizationLevel() {
        return organizationLevel;
    }

    public void setOrganizationLevel(Byte organizationLevel) {
        this.organizationLevel = organizationLevel;
    }

    public Byte getOperateType() {
        return operateType;
    }

    public void setOperateType(Byte operateType) {
        this.operateType = operateType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}