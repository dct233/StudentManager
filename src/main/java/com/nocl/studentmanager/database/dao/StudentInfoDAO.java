package com.nocl.studentmanager.database.dao;

import com.nocl.studentmanager.database.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentInfoDAO {
    List<Student> getStudentInfo();
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
    void getAcademyId(@Param("name") int name);
}
