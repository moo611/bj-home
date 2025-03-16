package com.example.bjhome.service;

import com.example.bjhome.domain.RhUser;

import java.util.List;

/**
 * 用户Service接口
 *
 * 
 * @date 2024-10-19
 */
public interface IRhUserService
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
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteRhUserByIds(Long[] ids);

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteRhUserById(Long id);

    RhUser selectRtUserByUsername(String username);
}
