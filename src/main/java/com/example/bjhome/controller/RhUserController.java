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
import com.example.bjhome.utils.UsernameUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


/**
 * 用户Controller
 *
 * 
 * @date 2024-10-19
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*") // 允许所有来源，或替换为具体的来源
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


    @PostMapping("/import")
    public AjaxResult uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            InputStream is = file.getInputStream();
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<RhUser> users = new ArrayList<>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // Skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();
                RhUser user = new RhUser();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            user.setNickname(currentCell.getStringCellValue());
                            break;
                        case 1:
                            user.setAge((long)currentCell.getNumericCellValue());
                            break;
                        case 2:
                            if (currentCell.getStringCellValue().equals("男")){
                                user.setSex("0");
                            }else{
                                user.setSex("1");
                            }

                            break;
                        default:
                            break;
                    }

                    user.setUsername(UsernameUtil.generateRandomUsername());
                    cellIdx++;
                }

                users.add(user);
            }

            workbook.close();
            rhUserService.batchInsert(users);
            return AjaxResult.success("导入成功");

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return AjaxResult.error("导入失败");

        }

    }

    @GetMapping("/export")
    public void export(HttpServletResponse response, RhUserListReq rhUserListReq) {
        RhUser rhUser = new RhUser();
        BeanUtils.copyProperties(rhUserListReq, rhUser);
        List<RhUser> list = rhUserService.selectRhUserList(rhUser);

        if (list.size() > 0) {

            try {
                // 创建一个新的 Excel 工作簿
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Sheet1");

                // 创建表头行
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("用户名");
                headerRow.createCell(1).setCellValue("昵称");
                headerRow.createCell(2).setCellValue("年龄");
                headerRow.createCell(3).setCellValue("性别");

                int rows = list.size();

                // 填充数据
                for (int i = 0; i < rows; i++) {
                    Row row = sheet.createRow(i + 1);

                    row.createCell(0).setCellValue(list.get(i).getUsername());
                    row.createCell(1).setCellValue(list.get(i).getNickname());
                    row.createCell(2).setCellValue(list.get(i).getAge());
                    String sex = "男";

                    if (list.get(i).getSex().equals("1")) {
                        sex = "女";
                    }
                    row.createCell(3).setCellValue(sex);
                }

                // 设置响应头
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.setHeader("Content-Disposition", "attachment; filename=example.xlsx");

                // 将 Excel 写入到响应的输出流
                workbook.write(response.getOutputStream());
                workbook.close();
                response.getOutputStream().flush();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }


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
