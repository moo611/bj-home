package com.example.bjhome.domain;


import com.example.bjhome.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 活动参与对象 rh_activity_join
 *
 * @author ruoyi
 * @date 2025-03-15
 */
public class RhActivityJoin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private Long activityId;

    /** 报名人 */
    
    private String username;

    /** 0、报名1、签到 */
    
    private String type;


    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    String activityName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date endTime;

    /** 删除标识 */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setActivityId(Long activityId)
    {
        this.activityId = activityId;
    }

    public Long getActivityId()
    {
        return activityId;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

   
}
