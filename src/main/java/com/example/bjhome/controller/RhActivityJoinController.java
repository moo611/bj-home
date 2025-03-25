package com.example.bjhome.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.bjhome.domain.RhActivity;
import com.example.bjhome.domain.base.AjaxResult;
import com.example.bjhome.domain.base.R;
import com.example.bjhome.domain.req.RhActivityJoinListReq;
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

import com.example.bjhome.domain.RhActivityJoin;
import com.example.bjhome.service.IRhActivityJoinService;


/**
 * 活动参与Controller
 *
 * @author ruoyi
 * @date 2025-03-15
 */
@RestController
@RequestMapping("/join")
public class RhActivityJoinController extends BaseController {
    @Autowired
    private IRhActivityJoinService rhActivityJoinService;

    /**
     * 查询活动参与列表
     */

    @GetMapping("/list")
    public R list(RhActivityJoinListReq rhActivityJoinListReq) {
        PageHelper.startPage(rhActivityJoinListReq.getPageNum(), rhActivityJoinListReq.getPageSize());
        RhActivityJoin rhActivityJoin = new RhActivityJoin();
        BeanUtils.copyProperties(rhActivityJoinListReq, rhActivityJoin);

        List<RhActivityJoin> rhActivityJoins = rhActivityJoinService.selectRhActivityJoinList(rhActivityJoin);
        if (rhActivityJoins.size() > 0) {
            PageInfo<RhActivityJoin> pageInfo = new PageInfo<>(rhActivityJoins);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<RhActivityJoin>(Collections.emptyList()));
    }


    /**
     * 获取活动参与详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(rhActivityJoinService.selectRhActivityJoinById(id));
    }

    /**
     * 新增活动参与
     */


    @PostMapping
    public AjaxResult add(@RequestBody RhActivityJoin rhActivityJoin) {
        int rows = rhActivityJoinService.insertRhActivityJoin(rhActivityJoin);

        if (rows == -32001) {
            return AjaxResult.error("您已经报名过了");
        }

        return toAjax(rows);
    }

    /**
     * 修改活动参与
     */


    @PutMapping
    public AjaxResult edit(@RequestBody RhActivityJoin rhActivityJoin) {
        return toAjax(rhActivityJoinService.updateRhActivityJoin(rhActivityJoin));
    }

    /**
     * 删除活动参与
     */


    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(rhActivityJoinService.deleteRhActivityJoinByIds(ids));
    }
}
