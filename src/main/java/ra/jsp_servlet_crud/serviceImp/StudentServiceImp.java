package ra.jsp_servlet_crud.serviceImp;

import ra.jsp_servlet_crud.model.Student;
import ra.jsp_servlet_crud.repository.StudentRepository;
import ra.jsp_servlet_crud.repositoryImp.StudentRepositoryImp;
import ra.jsp_servlet_crud.service.StudentService;

import java.util.List;

public class StudentServiceImp implements StudentService {
    //Khởi tạo instance của StudentRepository
    private StudentRepository studentRepository;

    public StudentServiceImp() {
        studentRepository = new StudentRepositoryImp();
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentRepository.save(student);
    }
}
