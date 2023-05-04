import java.util.List;

import com.ani.project.dto.StudentDto;

public interface StudentService {
    Integer createNewStudent(StudentDto student);
    List<StudentDto> all();
}