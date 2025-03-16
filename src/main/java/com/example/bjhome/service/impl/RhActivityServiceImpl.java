package com.example.bjhome.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bjhome.mapper.RhActivityMapper;
import com.example.bjhome.domain.RhActivity;
import com.example.bjhome.service.IRhActivityService;

/**
 * 活动Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@Service
public class RhActivityServiceImpl implements IRhActivityService
{
    @Autowired
    private RhActivityMapper rhActivityMapper;

    /**
     * 查询活动
     *
     * @param id 活动主键
     * @return 活动
     */
    @Override
    public RhActivity selectRhActivityById(Long id)
    {
        return rhActivityMapper.selectRhActivityById(id);
    }

    /**
     * 查询活动列表
     *
     * @param rhActivity 活动
     * @return 活动
     */
    @Override
    public List<RhActivity> selectRhActivityList(RhActivity rhActivity)
    {
        return rhActivityMapper.selectRhActivityList(rhActivity);
    }

    /**
     * 新增活动
     *
     * @param rhActivity 活动
     * @return 结果
     */
    @Override
    public int insertRhActivity(RhActivity rhActivity)
    {
        rhActivity.setCreateTime(new Date());
        return rhActivityMapper.insertRhActivity(rhActivity);
    }

    /**
     * 修改活动
     *
     * @param rhActivity 活动
     * @return 结果
     */
    @Override
    public int updateRhActivity(RhActivity rhActivity)
    {
        rhActivity.setUpdateTime(new Date());
        return rhActivityMapper.updateRhActivity(rhActivity);
    }

    /**
     * 批量删除活动
     *
     * @param ids 需要删除的活动主键
     * @return 结果
     */
    @Override
    public int deleteRhActivityByIds(Long[] ids)
    {
        return rhActivityMapper.deleteRhActivityByIds(ids);
    }

    /**
     * 删除活动信息
     *
     * @param id 活动主键
     * @return 结果
     */
    @Override
    public int deleteRhActivityById(Long id)
    {
        return rhActivityMapper.deleteRhActivityById(id);
    }
}
