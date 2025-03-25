package com.example.bjhome.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bjhome.mapper.RhActivityJoinMapper;
import com.example.bjhome.domain.RhActivityJoin;
import com.example.bjhome.service.IRhActivityJoinService;

/**
 * 活动参与Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@Service
public class RhActivityJoinServiceImpl implements IRhActivityJoinService
{
    @Autowired
    private RhActivityJoinMapper rhActivityJoinMapper;

    /**
     * 查询活动参与
     *
     * @param id 活动参与主键
     * @return 活动参与
     */
    @Override
    public RhActivityJoin selectRhActivityJoinById(Long id)
    {
        return rhActivityJoinMapper.selectRhActivityJoinById(id);
    }

    /**
     * 查询活动参与列表
     *
     * @param rhActivityJoin 活动参与
     * @return 活动参与
     */
    @Override
    public List<RhActivityJoin> selectRhActivityJoinList(RhActivityJoin rhActivityJoin)
    {
        return rhActivityJoinMapper.selectRhActivityJoinList(rhActivityJoin);
    }

    /**
     * 新增活动参与
     *
     * @param rhActivityJoin 活动参与
     * @return 结果
     */
    @Override
    public int insertRhActivityJoin(RhActivityJoin rhActivityJoin)
    {
        RhActivityJoin query = new RhActivityJoin();
        query.setUsername(rhActivityJoin.getUsername());
        query.setActivityId(rhActivityJoin.getActivityId());
        List<RhActivityJoin>rhActivityJoinList=rhActivityJoinMapper.selectRhActivityJoinList(query);
        if (!rhActivityJoinList.isEmpty()){
            return -32001;
        }

        rhActivityJoin.setCreateTime(new Date());
        return rhActivityJoinMapper.insertRhActivityJoin(rhActivityJoin);
    }

    /**
     * 修改活动参与
     *
     * @param rhActivityJoin 活动参与
     * @return 结果
     */
    @Override
    public int updateRhActivityJoin(RhActivityJoin rhActivityJoin)
    {
        rhActivityJoin.setUpdateTime(new Date());
        return rhActivityJoinMapper.updateRhActivityJoin(rhActivityJoin);
    }

    /**
     * 批量删除活动参与
     *
     * @param ids 需要删除的活动参与主键
     * @return 结果
     */
    @Override
    public int deleteRhActivityJoinByIds(Long[] ids)
    {
        return rhActivityJoinMapper.deleteRhActivityJoinByIds(ids);
    }

    /**
     * 删除活动参与信息
     *
     * @param id 活动参与主键
     * @return 结果
     */
    @Override
    public int deleteRhActivityJoinById(Long id)
    {
        return rhActivityJoinMapper.deleteRhActivityJoinById(id);
    }
}
