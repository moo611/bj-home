package com.example.bjhome.domain;


import com.example.bjhome.domain.base.BaseEntity;

/**
 * 服务对象 rh_service
 *
 * @author ruoyi
 * @date 2025-03-15
 */
public class RhService extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 服务名称 */
    
    private String name;

    /** 描述 */
    
    private String description;

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
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
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
