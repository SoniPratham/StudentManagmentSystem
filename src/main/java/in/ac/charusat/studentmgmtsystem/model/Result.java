package in.ac.charusat.studentmgmtsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Result {
    @Id
    Integer ResultId ;
    String Name;
    Integer CourseID , StudentID;

    public Result(Integer resultId, String name, Integer courseID, Integer studentID) {
        ResultId = resultId;
        Name = name;
        CourseID = courseID;
        StudentID = studentID;
    }

    public Result() {

    }

    public Integer getResultId() {
        return ResultId;
    }

    public void setResultId(Integer resultId) {
        ResultId = resultId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCourseID() {
        return CourseID;
    }

    public void setCourseID(Integer courseID) {
        CourseID = courseID;
    }

    public Integer getStudentID() {
        return StudentID;
    }

    public void setStudentID(Integer studentID) {
        StudentID = studentID;
    }
}
