package com.nocl.studentmanager.database.dao;

import com.nocl.studentmanager.database.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentInfoDAO {
    List<Student> getStudentInfo();
    int insertStudent(
            @Param("Name") String name,
            @Param("Age") Integer age,
            @Param("Gender") String gender,
            @Param("Addr") String addr,
            @Param("Academy") String academy,
            @Param("Specialized") String specialized,
            @Param("StudentClass") String studentClass
    );
    List<String> getAcademy();
}
