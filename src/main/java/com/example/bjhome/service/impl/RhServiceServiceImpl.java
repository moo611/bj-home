package com.example.bjhome.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bjhome.mapper.RhServiceMapper;
import com.example.bjhome.domain.RhService;
import com.example.bjhome.service.IRhServiceService;

/**
 * 服务Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@Service
public class RhServiceServiceImpl implements IRhServiceService
{
    @Autowired
    private RhServiceMapper rhServiceMapper;

    /**
     * 查询服务
     *
     * @param id 服务主键
     * @return 服务
     */
    @Override
    public RhService selectRhServiceById(Long id)
    {
        return rhServiceMapper.selectRhServiceById(id);
    }

    /**
     * 查询服务列表
     *
     * @param rhService 服务
     * @return 服务
     */
    @Override
    public List<RhService> selectRhServiceList(RhService rhService)
    {
        return rhServiceMapper.selectRhServiceList(rhService);
    }

    /**
     * 新增服务
     *
     * @param rhService 服务
     * @return 结果
     */
    @Override
    public int insertRhService(RhService rhService)
    {
        rhService.setCreateTime(new Date());
        return rhServiceMapper.insertRhService(rhService);
    }

    /**
     * 修改服务
     *
     * @param rhService 服务
     * @return 结果
     */
    @Override
    public int updateRhService(RhService rhService)
    {
        rhService.setUpdateTime(new Date());
        return rhServiceMapper.updateRhService(rhService);
    }

    /**
     * 批量删除服务
     *
     * @param ids 需要删除的服务主键
     * @return 结果
     */
    @Override
    public int deleteRhServiceByIds(Long[] ids)
    {
        return rhServiceMapper.deleteRhServiceByIds(ids);
    }

    /**
     * 删除服务信息
     *
     * @param id 服务主键
     * @return 结果
     */
    @Override
    public int deleteRhServiceById(Long id)
    {
        return rhServiceMapper.deleteRhServiceById(id);
    }
}
