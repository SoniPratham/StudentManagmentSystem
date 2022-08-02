package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

        @Autowired
        CourseRepository CourseRepository;
//    List<Student> Courses = new ArrayList<>(
//            Arrays.asList(
//                    new Student(1, "Tom", "US"),
//                    new Student(2, "Harry", "Canada"),
//                    new Student(3, "Nick", "UK")
//            )
//    );

        // Mappings - URL endpoints
        // Get the list of all student
        @GetMapping("/listCourses")
        public List<Course> getAllCourses() {
            return CourseRepository.findAll();
        }

        // Get the student information
        @GetMapping("/Course/{id}")
        public Course getCourse(@PathVariable Integer id) {
            return CourseRepository.findById(id).get();
        }

        // Delete the Course
        @DeleteMapping("/Course/{id}")
        public List<Course> deleteCourse(@PathVariable Integer id) {
            CourseRepository.delete(CourseRepository.findById(id).get());
            return CourseRepository.findAll();
        }

        // Add new Course
        @PostMapping("/Course")
        public List<Course> addCourse(@RequestBody Course Course) {
            CourseRepository.save(Course);
            return CourseRepository.findAll();
        }

        // Update the Course information
        @PutMapping("/Course/{id}")
        public List<Course> updateCourse(@RequestBody Course Course, @PathVariable Integer id) {
            Course CourseObj = CourseRepository.findById(id).get();
            CourseObj.setTitle(Course.getTitle());
            CourseObj.setDiscription(Course.getDiscription());
            CourseRepository.save(CourseObj);
            return CourseRepository.findAll();
        }

}
