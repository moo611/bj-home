package com.example.bjhome.domain;

import java.util.Date;

import com.example.bjhome.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 服务预约对象 rh_reserve
 *
 * @author ruoyi
 * @date 2025-03-15
 */
public class RhReserve extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 服务id */
    
    private Long serviceId;

    /** 预约时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    
    private Date serviceDate;

    /** 预约人 */
    
    private String username;

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
    public void setServiceId(Long serviceId)
    {
        this.serviceId = serviceId;
    }

    public Long getServiceId()
    {
        return serviceId;
    }
    public void setServiceDate(Date serviceDate)
    {
        this.serviceDate = serviceDate;
    }

    public Date getServiceDate()
    {
        return serviceDate;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
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
