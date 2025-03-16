package com.example.bjhome.service.impl;

import com.example.bjhome.domain.RhUser;
import com.example.bjhome.mapper.RhUserMapper;
import com.example.bjhome.service.IRhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户Service业务层处理
 *
 * 
 * @date 2024-10-19
 */
@Service
public class RhUserServiceImpl implements IRhUserService
{
    @Autowired
    private RhUserMapper sptUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;  // 注入 PasswordEncode
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public RhUser selectRhUserById(Long id)
    {
        return sptUserMapper.selectRhUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param sptUser 用户
     * @return 用户
     */
    @Override
    public List<RhUser> selectRhUserList(RhUser sptUser)
    {
        return sptUserMapper.selectRhUserList(sptUser);
    }

    /**
     * 新增用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    @Override
    public int insertRhUser(RhUser sptUser)
    {
        RhUser old = sptUserMapper.selectRhUserByUsername(sptUser.getUsername());
        if (old != null){
            return -32001;
        }
        String encodedPassword = passwordEncoder.encode(sptUser.getPassword());
        sptUser.setPassword(encodedPassword);
        sptUser.setCreateTime(new Date());
        
        return sptUserMapper.insertRhUser(sptUser);
    }

    /**
     * 修改用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    @Override
    public int updateRhUser(RhUser sptUser)
    {

        RhUser old = sptUserMapper.selectRhUserByUsername(sptUser.getUsername());
        if (!old.getId().equals(sptUser.getId())){
            return -32001;
        }

        sptUser.setUpdateTime(new Date());
        return sptUserMapper.updateRhUser(sptUser);
    }

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteRhUserByIds(Long[] ids)
    {
        return sptUserMapper.deleteRhUserByIds(ids);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteRhUserById(Long id)
    {
        return sptUserMapper.deleteRhUserById(id);
    }

    @Override
    public RhUser selectRtUserByUsername(String username) {
        return sptUserMapper.selectRhUserByUsername(username);
    }
}
