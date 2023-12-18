package com.nocl.studentmanager.database.dao;

import com.nocl.studentmanager.database.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentInfoDAO {
    List<Student> getStudentInfo(Student student);
    void insertStudent(
            @Param("Name") String name,
            @Param("Age") Integer age,
            @Param("Gender") String gender,
            @Param("Addr") String addr,
            @Param("Academy") String academy,
            @Param("Specialized") String specialized,
            @Param("StudentClass") String studentClass
    );
    List<String> getStudentClass(@Param("name") String name);
    List<String> getSpecialized(@Param("name") String name);
    List<String> getAcademy();
    List<String> getAllSpecialized();
    List<String> getAllStudentClass();
    // 通过 院校群 查询到 班级群
    List<String> getAcademyOfStudentClass(@Param("name") String name, @Param("data") Integer data);
    // 通过专业 查询到 院校
    String getSpecializedOfAcademy(@Param("name") String name);
    // 根据 班 到 专业
    String getStudentClassOfSpecialized(@Param("name") String name);
    // 根据 班 到 院
    String getStudentClassOfAcademy(@Param("name") String name);
    // 获取整个表数据长度
    Integer getStudentInfoCount();
}
