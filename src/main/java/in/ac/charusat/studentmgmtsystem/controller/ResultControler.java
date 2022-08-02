package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Result;
import in.ac.charusat.studentmgmtsystem.repository.aresultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class ResultControler {
    @Autowired
    aresultRepository aresultRepository;
//    List<Result> Results = new ArrayList<>(
//            Arrays.asList(
//                    new Result(1, "Tom", "US"),
//                    new Result(2, "Harry", "Canada"),
//                    new Result(3, "Nick", "UK")
//            )
//    );

    // Mappings - URL endpoints
    // Get the list of all Result
    @GetMapping("/listResults")
    public List<Result> getAllResults() {
        return aresultRepository.findAll();
    }

    // Get the Result information
    @GetMapping("/Result/{id}")
    public Result getResult(@PathVariable Integer id) {
        return aresultRepository.findById(id).get();
    }

    // Delete the Result
    @DeleteMapping("/Result/{id}")
    public List<Result> deleteResult(@PathVariable Integer id) {
        aresultRepository.delete(aresultRepository.findById(id).get());
        return aresultRepository.findAll();
    }

    // Add new Result
    @PostMapping("/Result")
    public List<Result> addResult(@RequestBody ArrayList<Result> Result) {
        aresultRepository.saveAll(Result);
        return aresultRepository.findAll();
    }

    // Update the Result information
    @PutMapping("/Result/{id}")
    public List<Result> updateResult(@RequestBody Result Result, @PathVariable Integer id) {
        Result ResultObj = aresultRepository.findById(id).get();
        ResultObj.setName(Result.getName());
        ResultObj.setStudentID(Result.getStudentID());
        ResultObj.setCourseID(Result.getCourseID());
        aresultRepository.save(ResultObj);
        return aresultRepository.findAll();
    }

}
