package com.example.bjhome.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.bjhome.domain.RhService;
import com.example.bjhome.domain.base.AjaxResult;
import com.example.bjhome.domain.base.R;
import com.example.bjhome.domain.req.RhServiceListReq;
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

import com.example.bjhome.domain.RhService;
import com.example.bjhome.service.IRhServiceService;


/**
 * 服务Controller
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@RestController
@RequestMapping("/service")
public class RhServiceController extends BaseController
{
    @Autowired
    private IRhServiceService rhServiceService;

    /**
     * 查询服务列表
     */
    
    @GetMapping("/list")
    public R list(RhServiceListReq rhServiceListReq)
    {
        PageHelper.startPage(rhServiceListReq.getPageNum(), rhServiceListReq.getPageSize());
        RhService rhService = new RhService();
        BeanUtils.copyProperties(rhServiceListReq, rhService);

        List<RhService> rhServices = rhServiceService.selectRhServiceList(rhService);
        if (rhServices.size() > 0) {
            PageInfo<RhService> pageInfo = new PageInfo<>(rhServices);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<RhService>(Collections.emptyList()));
    }



    /**
     * 获取服务详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rhServiceService.selectRhServiceById(id));
    }

    /**
     * 新增服务
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody RhService rhService)
    {
        return toAjax(rhServiceService.insertRhService(rhService));
    }

    /**
     * 修改服务
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody RhService rhService)
    {
        return toAjax(rhServiceService.updateRhService(rhService));
    }

    /**
     * 删除服务
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rhServiceService.deleteRhServiceByIds(ids));
    }
}
