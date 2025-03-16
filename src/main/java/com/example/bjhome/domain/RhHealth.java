package com.example.bjhome.domain;

import com.example.bjhome.domain.base.BaseEntity;

import java.math.BigDecimal;


/**
 * 健康信息对象 rh_health
 *
 * @author ruoyi
 * @date 2025-03-15
 */
public class RhHealth extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String username;

    /** 血压 */
    
    private String bloodPressure;

    /** 体重 */
    
    private BigDecimal weight;

    /** 身高 */
    
    private BigDecimal height;

    /** 心率 */
    
    private Long heartRate;

    /** 血糖 */
    
    private BigDecimal bloodSugar;

    /** 删除标识 */
    private String delFlag;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private Integer age;

    private String sex;

    private String nickname;


    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setBloodPressure(String bloodPressure)
    {
        this.bloodPressure = bloodPressure;
    }

    public String getBloodPressure()
    {
        return bloodPressure;
    }
    public void setWeight(BigDecimal weight)
    {
        this.weight = weight;
    }

    public BigDecimal getWeight()
    {
        return weight;
    }
    public void setHeight(BigDecimal height)
    {
        this.height = height;
    }

    public BigDecimal getHeight()
    {
        return height;
    }
    public void setHeartRate(Long heartRate)
    {
        this.heartRate = heartRate;
    }

    public Long getHeartRate()
    {
        return heartRate;
    }
    public void setBloodSugar(BigDecimal bloodSugar)
    {
        this.bloodSugar = bloodSugar;
    }

    public BigDecimal getBloodSugar()
    {
        return bloodSugar;
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
