package com.example.bjhome.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bjhome.mapper.RhHealthMapper;
import com.example.bjhome.domain.RhHealth;
import com.example.bjhome.service.IRhHealthService;

/**
 * 健康信息Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@Service
public class RhHealthServiceImpl implements IRhHealthService
{
    @Autowired
    private RhHealthMapper rhHealthMapper;

    /**
     * 查询健康信息
     *
     * @param id 健康信息主键
     * @return 健康信息
     */
    @Override
    public RhHealth selectRhHealthById(Long id)
    {
        return rhHealthMapper.selectRhHealthById(id);
    }

    /**
     * 查询健康信息列表
     *
     * @param rhHealth 健康信息
     * @return 健康信息
     */
    @Override
    public List<RhHealth> selectRhHealthList(RhHealth rhHealth)
    {
        return rhHealthMapper.selectRhHealthList(rhHealth);
    }

    /**
     * 新增健康信息
     *
     * @param rhHealth 健康信息
     * @return 结果
     */
    @Override
    public int insertRhHealth(RhHealth rhHealth)
    {
        RhHealth record = rhHealthMapper.selectRhHealthByUsername(rhHealth.getUsername());
        if (record != null){
            return -32001;
        }

        rhHealth.setCreateTime(new Date());
        return rhHealthMapper.insertRhHealth(rhHealth);
    }

    /**
     * 修改健康信息
     *
     * @param rhHealth 健康信息
     * @return 结果
     */
    @Override
    public int updateRhHealth(RhHealth rhHealth)
    {
        rhHealth.setUpdateTime(new Date());
        return rhHealthMapper.updateRhHealth(rhHealth);
    }

    /**
     * 批量删除健康信息
     *
     * @param ids 需要删除的健康信息主键
     * @return 结果
     */
    @Override
    public int deleteRhHealthByIds(Long[] ids)
    {
        return rhHealthMapper.deleteRhHealthByIds(ids);
    }

    /**
     * 删除健康信息信息
     *
     * @param id 健康信息主键
     * @return 结果
     */
    @Override
    public int deleteRhHealthById(Long id)
    {
        return rhHealthMapper.deleteRhHealthById(id);
    }
}
