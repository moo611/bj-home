package com.example.bjhome.service;

import java.util.List;
import com.example.bjhome.domain.RhService;

/**
 * 服务Service接口
 *
 * @author ruoyi
 * @date 2025-03-15
 */
public interface IRhServiceService
{
    /**
     * 查询服务
     *
     * @param id 服务主键
     * @return 服务
     */
    public RhService selectRhServiceById(Long id);

    /**
     * 查询服务列表
     *
     * @param rhService 服务
     * @return 服务集合
     */
    public List<RhService> selectRhServiceList(RhService rhService);

    /**
     * 新增服务
     *
     * @param rhService 服务
     * @return 结果
     */
    public int insertRhService(RhService rhService);

    /**
     * 修改服务
     *
     * @param rhService 服务
     * @return 结果
     */
    public int updateRhService(RhService rhService);

    /**
     * 批量删除服务
     *
     * @param ids 需要删除的服务主键集合
     * @return 结果
     */
    public int deleteRhServiceByIds(Long[] ids);

    /**
     * 删除服务信息
     *
     * @param id 服务主键
     * @return 结果
     */
    public int deleteRhServiceById(Long id);
}
