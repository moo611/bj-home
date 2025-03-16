package com.example.bjhome.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.bjhome.domain.base.AjaxResult;
import com.example.bjhome.domain.base.R;
import com.example.bjhome.domain.req.RhActivityListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bjhome.domain.RhActivity;
import com.example.bjhome.service.IRhActivityService;


/**
 * 活动Controller
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@RestController
@RequestMapping("/activity")
public class RhActivityController extends BaseController
{
    @Autowired
    private IRhActivityService rhActivityService;

    /**
     * 查询活动列表
     */
    
    @GetMapping("/list")
    public R list(RhActivityListReq rhActivityListReq)
    {
        PageHelper.startPage(rhActivityListReq.getPageNum(), rhActivityListReq.getPageSize());
        RhActivity rhActivity = new RhActivity();
        BeanUtils.copyProperties(rhActivityListReq, rhActivity);

        List<RhActivity> rhActivitys = rhActivityService.selectRhActivityList(rhActivity);
        if (rhActivitys.size() > 0) {
            PageInfo<RhActivity> pageInfo = new PageInfo<>(rhActivitys);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<RhActivity>(Collections.emptyList()));
    }

   

    /**
     * 获取活动详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rhActivityService.selectRhActivityById(id));
    }

    /**
     * 新增活动
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody RhActivity rhActivity)
    {
        return toAjax(rhActivityService.insertRhActivity(rhActivity));
    }

    /**
     * 修改活动
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody RhActivity rhActivity)
    {
        return toAjax(rhActivityService.updateRhActivity(rhActivity));
    }

    /**
     * 删除活动
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rhActivityService.deleteRhActivityByIds(ids));
    }
}
