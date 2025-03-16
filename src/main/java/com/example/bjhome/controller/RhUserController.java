package com.example.bjhome.controller;

import com.example.bjhome.config.auth.JwtUtil;
import com.example.bjhome.config.auth.MyUserDetailsService;
import com.example.bjhome.config.auth.UserUtil;
import com.example.bjhome.domain.RhUser;
import com.example.bjhome.domain.base.AjaxResult;
import com.example.bjhome.domain.base.R;
import com.example.bjhome.domain.req.RhUserListReq;
import com.example.bjhome.domain.req.LoginReq;
import com.example.bjhome.service.IRhUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


/**
 * 用户Controller
 *
 * 
 * @date 2024-10-19
 */
@RestController
@RequestMapping("/user")
public class RhUserController extends BaseController {
    @Autowired
    private IRhUserService rhUserService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/login")
    @ApiOperation("登录")
    public AjaxResult login(@RequestBody LoginReq loginReq) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword())
            );
        }catch (Exception e){
            return AjaxResult.error("用户名或密码错误");
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginReq.getUsername());
        return AjaxResult.success("ok",jwtUtil.generateToken(userDetails.getUsername()));

    }


    /**
     * 查询用户列表
     */

    @GetMapping("/list")
    public R list(RhUserListReq rhUserListReq) {
        PageHelper.startPage(rhUserListReq.getPageNum(), rhUserListReq.getPageSize());
        RhUser rhUser = new RhUser();
        BeanUtils.copyProperties(rhUserListReq, rhUser);

        List<RhUser> rhUsers = rhUserService.selectRhUserList(rhUser);
        if (rhUsers.size() > 0) {
            PageInfo<RhUser> pageInfo = new PageInfo<>(rhUsers);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<RhUser>(Collections.emptyList()));
    }


    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(rhUserService.selectRhUserById(id));
    }

    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/info")
    @ApiOperation("获取用户详细信息")
    public AjaxResult getInfo()
    {
        String username = UserUtil.getCurrentUsername();
        return success(rhUserService.selectRtUserByUsername(username));
    }

    /**
     * 新增用户
     */


    @PostMapping
    public AjaxResult add(@RequestBody RhUser rhUser) {

        int res = rhUserService.insertRhUser(rhUser);
        if (res == -32001){
            return AjaxResult.error("用户名已存在");
        }
        return toAjax(res);


    }

    /**
     * 修改用户
     */


    @PutMapping
    public AjaxResult edit(@RequestBody RhUser rhUser) {
        int res = rhUserService.updateRhUser(rhUser);
        if (res == -32001){
            return AjaxResult.error("用户名已存在");
        }
        return toAjax(res);
    }

    /**
     * 删除用户
     */


    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(rhUserService.deleteRhUserByIds(ids));
    }
}
