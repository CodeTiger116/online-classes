package com.hanhu.serve.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.hanhu.serve.entity.*;
import com.hanhu.serve.service.AdminService;
import com.hanhu.serve.service.GradesService;
import com.hanhu.serve.service.MajorService;
import com.hanhu.serve.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import onway.org.cn.comm.web.controller.BaseController;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author hanhu
 * @since 2022-01-25
 */
@RestController
@RequestMapping("/student/basic")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private GradesService gradesService;

    /**
     * 获取所有成员（分页）
     * @param currentPage  当前页面
     * @param size   页面大小 默认10
     * @param students  学生（admin）对象
     * @param beginDateScope   入学日期范围
     * @return
     */
    @ApiOperation(value = "获取所有学生(分页) ")
    @GetMapping("/")
    public RespPageBean getAllStudentsByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                             @RequestParam(defaultValue = "10") Integer size,
                                             Students students,
                                             LocalDate[] beginDateScope){
        return adminService.getAllStudentsByPage(currentPage,size,students,beginDateScope);

    }



    @ApiOperation(value = "获取所有学生(不分页)")
    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getStudent(null);
    }





    @ApiOperation(value = "更新学生")
    @PutMapping("/")
    public RespBean updateStudent(@RequestBody Admin admin){
        if(adminService.updateById(admin)){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败！");
    }



    @ApiOperation(value = "获取所有角色")
    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.list();
    }



    @ApiOperation(value = "更新操作员角色")
    @GetMapping("/role")
    public RespBean updateRole(Integer adminId,Integer[] rids){
        return adminService.updateAdminRole(adminId,rids);
    }



    @ApiOperation("获取所有专业")
    @GetMapping("/major")
    public List<Major> getAllMajor(){
        return majorService.list();
    }



    @ApiOperation("获取所有班级")
    @GetMapping("/grade")
    public List<Grades> getAllGrade(){
        return gradesService.list();
    }



    @ApiOperation(value = "添加学生")
    @PostMapping("/")
    public RespBean addStudent(@RequestBody Admin admin){
        if(adminService.save(admin)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }



    @ApiOperation(value = "删除学生")
    @DeleteMapping("/{id}")
    public RespBean deleteStudent(@PathVariable  Integer id){
        if(adminService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }



    //用流的形式导出
    @ApiOperation(value = "导出学生数据")
    @GetMapping(value = "/export",produces = "application/octet-stream") //解决乱码
    public void exportStudent(HttpServletResponse response){


        List<Admin> list = adminService.getStudent(null);

        //导出数据( 文件名、sheetName、excel版本：03版HSSF和07版XSSF  03版导出速度快，兼容性高
        ExportParams params = new ExportParams("学生表","学生表", ExcelType.HSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(params,Admin.class,list);

        ServletOutputStream outputStream = null;
        try {
            //用流的形式传出
            response.setHeader("content-type","application/octet-stream");
            //防止中文乱码
            response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode("学生表.xls","utf-8"));
            outputStream = response.getOutputStream();

            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            if(null != outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @ApiOperation(value = "导入学生")
    @PostMapping("/import")
    public RespBean importStudent(MultipartFile file){
        //先准备参数
        ImportParams params = new ImportParams();
        //先去掉模板xls的标题行
        params.setTitleRows(1);

        //查班级中的所有项
        List<Grades> gradesList = gradesService.list();
        //查专业中的所有项
        List<Major> majorList = majorService.list();

        try {
            List<Admin> list = ExcelImportUtil.importExcel(file.getInputStream(),Admin.class,params);
            //excel中的班级、专业导入后，Admin中的major和grade字段收到相应的值，但需要获取对应的id
            list.forEach(admin -> {
                //new Grades(admin.getGrades().getGradeName()))：用到有参构造，此时Grade中只有name
                //前面查询到所有的list（有id，有name）
                //gradesList.indexOf()  用EqualsAndHashCode方法，去进行相应比较，拿到对应的下标
                //通过下标拿到完整的Grade对象 (有id，有name)
                //通过getId，拿到对应id
                Integer id = gradesList.get(gradesList.indexOf(new Grades(admin.getGrades().getGradeName()))).getId();
                //设置id
                admin.setGradeId(id);

                //同理，设置majorId
                admin.setMajorId(majorList.get(majorList.indexOf(new Major(admin.getMajor().getMajorName()))).getId());

            });

            //插入
            if(adminService.saveBatch(list)){
                return RespBean.success("导入成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespBean.error("导入失败");
    }





}

