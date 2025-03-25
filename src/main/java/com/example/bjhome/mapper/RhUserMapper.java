package com.example.bjhome.mapper;

import com.example.bjhome.domain.RhUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户Mapper接口
 *
 * 
 * @date 2024-10-19
 */
@Mapper
public interface RhUserMapper
{
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    public RhUser selectRhUserById(Long id);

    /**
     * 查询用户列表
     *
     * @param rhUser 用户
     * @return 用户集合
     */
    public List<RhUser> selectRhUserList(RhUser rhUser);

    /**
     * 新增用户
     *
     * @param rhUser 用户
     * @return 结果
     */
    public int insertRhUser(RhUser rhUser);

    /**
     * 修改用户
     *
     * @param rhUser 用户
     * @return 结果
     */
    public int updateRhUser(RhUser rhUser);

    /**
     * 删除用户
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteRhUserById(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRhUserByIds(Long[] ids);

    RhUser selectRhUserByUsername(String username);

}
