package com.example.bjhome.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.bjhome.domain.RhReserve;
import com.example.bjhome.domain.base.AjaxResult;
import com.example.bjhome.domain.base.R;
import com.example.bjhome.domain.req.RhReserveListReq;
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

import com.example.bjhome.domain.RhReserve;
import com.example.bjhome.service.IRhReserveService;


/**
 * 服务预约Controller
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@RestController
@RequestMapping("/reserve")
public class RhReserveController extends BaseController
{
    @Autowired
    private IRhReserveService rhReserveService;

    /**
     * 查询服务预约列表
     */
    
    @GetMapping("/list")
    public R list(RhReserveListReq rhReserveListReq)
    {
        PageHelper.startPage(rhReserveListReq.getPageNum(), rhReserveListReq.getPageSize());
        RhReserve rhReserve = new RhReserve();
        BeanUtils.copyProperties(rhReserveListReq, rhReserve);

        List<RhReserve> rhReserves = rhReserveService.selectRhReserveList(rhReserve);
        if (rhReserves.size() > 0) {
            PageInfo<RhReserve> pageInfo = new PageInfo<>(rhReserves);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<RhReserve>(Collections.emptyList()));
    }



    /**
     * 获取服务预约详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rhReserveService.selectRhReserveById(id));
    }

    /**
     * 新增服务预约
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody RhReserve rhReserve)
    {
        return toAjax(rhReserveService.insertRhReserve(rhReserve));
    }

    /**
     * 修改服务预约
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody RhReserve rhReserve)
    {
        return toAjax(rhReserveService.updateRhReserve(rhReserve));
    }

    /**
     * 删除服务预约
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rhReserveService.deleteRhReserveByIds(ids));
    }
}
