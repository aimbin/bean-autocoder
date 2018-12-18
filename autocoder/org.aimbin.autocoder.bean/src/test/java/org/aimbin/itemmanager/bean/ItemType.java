package org.aimbin.itemmanager.bean;

import java.util.Date;
import org.aimbin.autocoder.annotations.Column;

public class ItemType {

    @Column(name = "id")
    private String id = null;
    @Column(name = "name", notNull = true)
    private String name = null;
    @Column(name = "status")
    private Integer status = null;
    @Column(name = "scores")
    private Double scores = null;
    @Column(name = "rootId")
    private String rootId = null;
    @Column(name = "parentId", notNull = true)
    private String parentId = null;
    @Column(name = "nameCn")
    private String nameCn = null;
    @Column(name = "description")
    private String description = null;
    @Column(name = "creator")
    private String creator = null;
    @Column(name = "createTime", notNull = true, defaultValue = "sysdate")
    private Date createTime = null;
    @Column(name = "opTimestamp", notNull = true, defaultValue = "sysdate")
    private Date opTimestamp = null;
    @Column(name = "recentUsed")
    private Boolean recentUsed = null;

    public void setId(String id) {
         this.id = id;
    }
    public String getId() {
        return this.id;
    }
    public void setName(String name) {
         this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setStatus(Integer status) {
         this.status = status;
    }
    public Integer getStatus() {
        return this.status;
    }
    public void setScores(Double scores) {
         this.scores = scores;
    }
    public Double getScores() {
        return this.scores;
    }
    public void setRootId(String rootId) {
         this.rootId = rootId;
    }
    public String getRootId() {
        return this.rootId;
    }
    public void setParentId(String parentId) {
         this.parentId = parentId;
    }
    public String getParentId() {
        return this.parentId;
    }
    public void setNameCn(String nameCn) {
         this.nameCn = nameCn;
    }
    public String getNameCn() {
        return this.nameCn;
    }
    public void setDescription(String description) {
         this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
    public void setCreator(String creator) {
         this.creator = creator;
    }
    public String getCreator() {
        return this.creator;
    }
    public void setCreateTime(Date createTime) {
         this.createTime = createTime;
    }
    public Date getCreateTime() {
        return this.createTime;
    }
    public void setOpTimestamp(Date opTimestamp) {
         this.opTimestamp = opTimestamp;
    }
    public Date getOpTimestamp() {
        return this.opTimestamp;
    }
    public void setRecentUsed(Boolean recentUsed) {
         this.recentUsed = recentUsed;
    }
    public Boolean getRecentUsed() {
        return this.recentUsed;
    }
}