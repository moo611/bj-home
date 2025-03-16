package com.example.bjhome.mapper;

import java.util.List;
import com.example.bjhome.domain.RhReserve;
import org.apache.ibatis.annotations.Mapper;

/**
 * 服务预约Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@Mapper
public interface RhReserveMapper
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
     * 删除服务预约
     *
     * @param id 服务预约主键
     * @return 结果
     */
    public int deleteRhReserveById(Long id);

    /**
     * 批量删除服务预约
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRhReserveByIds(Long[] ids);
}
