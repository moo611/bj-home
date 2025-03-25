package com.example.bjhome.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bjhome.mapper.RhReserveMapper;
import com.example.bjhome.domain.RhReserve;
import com.example.bjhome.service.IRhReserveService;

/**
 * 服务预约Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@Service
public class RhReserveServiceImpl implements IRhReserveService
{
    @Autowired
    private RhReserveMapper rhReserveMapper;

    /**
     * 查询服务预约
     *
     * @param id 服务预约主键
     * @return 服务预约
     */
    @Override
    public RhReserve selectRhReserveById(Long id)
    {
        return rhReserveMapper.selectRhReserveById(id);
    }

    /**
     * 查询服务预约列表
     *
     * @param rhReserve 服务预约
     * @return 服务预约
     */
    @Override
    public List<RhReserve> selectRhReserveList(RhReserve rhReserve)
    {
        return rhReserveMapper.selectRhReserveList(rhReserve);
    }

    /**
     * 新增服务预约
     *
     * @param rhReserve 服务预约
     * @return 结果
     */
    @Override
    public int insertRhReserve(RhReserve rhReserve)
    {
        RhReserve query = new RhReserve();
        query.setServiceId(rhReserve.getServiceId());
        query.setUsername(rhReserve.getUsername());
        List<RhReserve>rhReserves = rhReserveMapper.selectRhReserveList(query);
        if (rhReserves.size() > 0){
            return -32001;
        }

        rhReserve.setCreateTime(new Date());
        return rhReserveMapper.insertRhReserve(rhReserve);
    }

    /**
     * 修改服务预约
     *
     * @param rhReserve 服务预约
     * @return 结果
     */
    @Override
    public int updateRhReserve(RhReserve rhReserve)
    {
        rhReserve.setUpdateTime(new Date());
        return rhReserveMapper.updateRhReserve(rhReserve);
    }

    /**
     * 批量删除服务预约
     *
     * @param ids 需要删除的服务预约主键
     * @return 结果
     */
    @Override
    public int deleteRhReserveByIds(Long[] ids)
    {
        return rhReserveMapper.deleteRhReserveByIds(ids);
    }

    /**
     * 删除服务预约信息
     *
     * @param id 服务预约主键
     * @return 结果
     */
    @Override
    public int deleteRhReserveById(Long id)
    {
        return rhReserveMapper.deleteRhReserveById(id);
    }
}
