package com.nocl.studentmanager.database.dao;

import com.nocl.studentmanager.database.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentInfoDAO {
    List<Student> getStudentInfo(Student student);
    Integer getStudentCount(Student student);
    List<Student> getStudentIndex(@Param("student") Student student, @Param("page") Integer page, @Param("index") Integer index);
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
    // 删除数据
    void deleteStudentInfo(@Param("uid") Integer uid);
    void updateStudentAcademy(@Param("uid") Integer uid, @Param("academyName") Integer academy);
    void updateStudentSpecialized(@Param("uid") Integer uid, @Param("specializedName") Integer specialized);
    void updateStudentClass(@Param("uid") Integer uid, @Param("studentClassName") Integer studentClass);
    void updateStudentName(@Param("uid") Integer uid, @Param("name") String name);
    void updateStudentAge(@Param("uid") Integer uid, @Param("age") Integer age);
    void updateStudentGender(@Param("uid") Integer uid, @Param("gender") String gender);
    void updateStudentAddr(@Param("uid") Integer uid, @Param("addr") String addr);
    Integer getAcademyUid(@Param("name") String name);
    Integer getSpecializedUid(@Param("name") String name);
    Integer getStudentClassUid(@Param("name") String name);
}
