package com.example.bjhome.service;

import java.util.List;
import com.example.bjhome.domain.RhActivityJoin;

/**
 * 活动参与Service接口
 *
 * @author ruoyi
 * @date 2025-03-15
 */
public interface IRhActivityJoinService
{
    /**
     * 查询活动参与
     *
     * @param id 活动参与主键
     * @return 活动参与
     */
    public RhActivityJoin selectRhActivityJoinById(Long id);

    /**
     * 查询活动参与列表
     *
     * @param rhActivityJoin 活动参与
     * @return 活动参与集合
     */
    public List<RhActivityJoin> selectRhActivityJoinList(RhActivityJoin rhActivityJoin);

    /**
     * 新增活动参与
     *
     * @param rhActivityJoin 活动参与
     * @return 结果
     */
    public int insertRhActivityJoin(RhActivityJoin rhActivityJoin);

    /**
     * 修改活动参与
     *
     * @param rhActivityJoin 活动参与
     * @return 结果
     */
    public int updateRhActivityJoin(RhActivityJoin rhActivityJoin);

    /**
     * 批量删除活动参与
     *
     * @param ids 需要删除的活动参与主键集合
     * @return 结果
     */
    public int deleteRhActivityJoinByIds(Long[] ids);

    /**
     * 删除活动参与信息
     *
     * @param id 活动参与主键
     * @return 结果
     */
    public int deleteRhActivityJoinById(Long id);
}
