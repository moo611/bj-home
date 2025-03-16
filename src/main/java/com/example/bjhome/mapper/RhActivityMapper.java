package com.example.bjhome.mapper;

import java.util.List;
import com.example.bjhome.domain.RhActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 活动Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@Mapper
public interface RhActivityMapper
{
    /**
     * 查询活动
     *
     * @param id 活动主键
     * @return 活动
     */
    public RhActivity selectRhActivityById(Long id);

    /**
     * 查询活动列表
     *
     * @param rhActivity 活动
     * @return 活动集合
     */
    public List<RhActivity> selectRhActivityList(RhActivity rhActivity);

    /**
     * 新增活动
     *
     * @param rhActivity 活动
     * @return 结果
     */
    public int insertRhActivity(RhActivity rhActivity);

    /**
     * 修改活动
     *
     * @param rhActivity 活动
     * @return 结果
     */
    public int updateRhActivity(RhActivity rhActivity);

    /**
     * 删除活动
     *
     * @param id 活动主键
     * @return 结果
     */
    public int deleteRhActivityById(Long id);

    /**
     * 批量删除活动
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRhActivityByIds(Long[] ids);
}
