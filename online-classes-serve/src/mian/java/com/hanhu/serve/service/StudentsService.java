package com.hanhu.serve.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hanhu.serve.entity.RespPageBean;
import com.hanhu.serve.entity.Students;
import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-03
 */
public interface StudentsService extends IService<Students> {

    /**
     * 获取所有学生（分页）
     * @param currentPage  当前页面
     * @param size   页面大小 默认10
     * @param students  学生对象
     * @param beginDateScope   入学日期范围
     * @return
     **/
    RespPageBean getAllStudentsByPage(Integer currentPage, Integer size, Students students, LocalDate[] beginDateScope);

}
