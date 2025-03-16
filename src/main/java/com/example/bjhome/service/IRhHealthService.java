package com.example.bjhome.service;

import java.util.List;
import com.example.bjhome.domain.RhHealth;

/**
 * 健康信息Service接口
 *
 * @author ruoyi
 * @date 2025-03-15
 */
public interface IRhHealthService
{
    /**
     * 查询健康信息
     *
     * @param id 健康信息主键
     * @return 健康信息
     */
    public RhHealth selectRhHealthById(Long id);

    /**
     * 查询健康信息列表
     *
     * @param rhHealth 健康信息
     * @return 健康信息集合
     */
    public List<RhHealth> selectRhHealthList(RhHealth rhHealth);

    /**
     * 新增健康信息
     *
     * @param rhHealth 健康信息
     * @return 结果
     */
    public int insertRhHealth(RhHealth rhHealth);

    /**
     * 修改健康信息
     *
     * @param rhHealth 健康信息
     * @return 结果
     */
    public int updateRhHealth(RhHealth rhHealth);

    /**
     * 批量删除健康信息
     *
     * @param ids 需要删除的健康信息主键集合
     * @return 结果
     */
    public int deleteRhHealthByIds(Long[] ids);

    /**
     * 删除健康信息信息
     *
     * @param id 健康信息主键
     * @return 结果
     */
    public int deleteRhHealthById(Long id);
}
