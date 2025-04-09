package com.example.bjhome.service.impl;

import com.example.bjhome.domain.RhUser;
import com.example.bjhome.mapper.RhUserMapper;
import com.example.bjhome.service.IRhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private RhUserMapper rhUserMapper;
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
        return rhUserMapper.selectRhUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param rhUser 用户
     * @return 用户
     */
    @Override
    public List<RhUser> selectRhUserList(RhUser rhUser)
    {
        return rhUserMapper.selectRhUserList(rhUser);
    }

    /**
     * 新增用户
     *
     * @param rhUser 用户
     * @return 结果
     */
    @Override
    public int insertRhUser(RhUser rhUser)
    {
        RhUser old = rhUserMapper.selectRhUserByUsername(rhUser.getUsername());
        if (old != null){
            return -32001;
        }
        String encodedPassword = passwordEncoder.encode(rhUser.getPassword());
        rhUser.setPassword(encodedPassword);
        rhUser.setCreateTime(new Date());
        
        return rhUserMapper.insertRhUser(rhUser);
    }

    /**
     * 修改用户
     *
     * @param rhUser 用户
     * @return 结果
     */
    @Override
    public int updateRhUser(RhUser rhUser)
    {

        RhUser old = rhUserMapper.selectRhUserByUsername(rhUser.getUsername());
        if (!old.getId().equals(rhUser.getId())){
            return -32001;
        }

        rhUser.setUpdateTime(new Date());
        return rhUserMapper.updateRhUser(rhUser);
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
        return rhUserMapper.deleteRhUserByIds(ids);
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
        return rhUserMapper.deleteRhUserById(id);
    }

    @Override
    public RhUser selectRtUserByUsername(String username) {
        return rhUserMapper.selectRhUserByUsername(username);
    }

    @Override
    @Transactional
    public void batchInsert(List<RhUser> users) {

        for (RhUser user : users) {
            user.setCreateTime(new Date());
            user.setRole("2");
            user.setPassword(passwordEncoder.encode("123456"));
            rhUserMapper.insertRhUser(user);

        }


    }
}
