package com.example.bjhome.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.bjhome.domain.RhHealth;
import com.example.bjhome.domain.base.AjaxResult;
import com.example.bjhome.domain.base.R;
import com.example.bjhome.domain.req.RhHealthListReq;
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

import com.example.bjhome.domain.RhHealth;
import com.example.bjhome.service.IRhHealthService;


/**
 * 健康信息Controller
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@RestController
@RequestMapping("/health")
public class RhHealthController extends BaseController
{
    @Autowired
    private IRhHealthService rhHealthService;

    /**
     * 查询健康信息列表
     */
    
    @GetMapping("/list")
    public R list(RhHealthListReq rhHealthListReq)
    {
        PageHelper.startPage(rhHealthListReq.getPageNum(), rhHealthListReq.getPageSize());
        RhHealth rhHealth = new RhHealth();
        BeanUtils.copyProperties(rhHealthListReq, rhHealth);

        List<RhHealth> rhHealths = rhHealthService.selectRhHealthList(rhHealth);
        if (rhHealths.size() > 0) {
            PageInfo<RhHealth> pageInfo = new PageInfo<>(rhHealths);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<RhHealth>(Collections.emptyList()));
    }

    /**
     * 导出健康信息列表
     */
    
    
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, RhHealth rhHealth)
//    {
//        List<RhHealth> list = rhHealthService.selectRhHealthList(rhHealth);
//        ExcelUtil<RhHealth> util = new ExcelUtil<RhHealth>(RhHealth.class);
//        util.exportExcel(response, list, "健康信息数据");
//    }

    /**
     * 获取健康信息详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rhHealthService.selectRhHealthById(id));
    }

    /**
     * 新增健康信息
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody RhHealth rhHealth)
    {
        int rows = rhHealthService.insertRhHealth(rhHealth);
        if (rows == -32001){
            return AjaxResult.error("已经录入过了");
        }
        return toAjax(rows);
    }

    /**
     * 修改健康信息
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody RhHealth rhHealth)
    {
        return toAjax(rhHealthService.updateRhHealth(rhHealth));
    }

    /**
     * 删除健康信息
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rhHealthService.deleteRhHealthByIds(ids));
    }
}
