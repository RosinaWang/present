package com.present.sign.service;

import com.alibaba.fastjson.JSONObject;
import com.present.common.dto.ResponseDto;
import com.present.common.service.BaseService;
import com.present.common.util.CheckUtil;
import com.present.sign.dao.StudentSignDao;
import com.present.sign.dto.CourseSignInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Larry-sea on 2017/3/24.
 * <p>
 * <p>
 * 通过courseId 和学生id来确定签到信息
 * 学生获取某个一签到课程的所有签到记录信息
 */
@Service("getCourseSignInfo")
public class StudentGetCourseSignInfo extends BaseService<List<CourseSignInfoDto>> {

    @Autowired
    StudentSignDao studentSignDao;

    /**
     * @param params   业务参数
     * @param request  request对象
     * @param response response对象
     * @return
     */
    @Override
    public ResponseDto<List<CourseSignInfoDto>> process(JSONObject params, HttpServletRequest request, HttpServletResponse response) {
        CheckUtil.checkEmpty(params, "courseId", "studentId");
        ResponseDto<List<CourseSignInfoDto>> courseSignInfoDto = new ResponseDto<List<CourseSignInfoDto>>();
        List<CourseSignInfoDto> courseSignInfoDtos = studentSignDao.queryCourseSignInfoDto(params.getString("courseId"), params.getString("studentId"));
        courseSignInfoDto.setData(courseSignInfoDtos);
        return courseSignInfoDto;
    }








}
