package com.example.bjhome.service;

import java.util.List;
import com.example.bjhome.domain.RhReserve;

/**
 * 服务预约Service接口
 *
 * @author ruoyi
 * @date 2025-03-15
 */
public interface IRhReserveService
{
    /**
     * 查询服务预约
     *
     * @param id 服务预约主键
     * @return 服务预约
     */
    public RhReserve selectRhReserveById(Long id);

    /**
     * 查询服务预约列表
     *
     * @param rhReserve 服务预约
     * @return 服务预约集合
     */
    public List<RhReserve> selectRhReserveList(RhReserve rhReserve);

    /**
     * 新增服务预约
     *
     * @param rhReserve 服务预约
     * @return 结果
     */
    public int insertRhReserve(RhReserve rhReserve);

    /**
     * 修改服务预约
     *
     * @param rhReserve 服务预约
     * @return 结果
     */
    public int updateRhReserve(RhReserve rhReserve);

    /**
     * 批量删除服务预约
     *
     * @param ids 需要删除的服务预约主键集合
     * @return 结果
     */
    public int deleteRhReserveByIds(Long[] ids);

    /**
     * 删除服务预约信息
     *
     * @param id 服务预约主键
     * @return 结果
     */
    public int deleteRhReserveById(Long id);
}
