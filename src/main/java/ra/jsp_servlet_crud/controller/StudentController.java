package ra.jsp_servlet_crud.controller;

import ra.jsp_servlet_crud.model.Student;
import ra.jsp_servlet_crud.service.StudentService;
import ra.jsp_servlet_crud.serviceImp.StudentServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/StudentController")
public class StudentController extends HttpServlet {
    private StudentService studentService;

    public StudentController() {
        studentService = new StudentServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("getAll")) {
            getAllStudent(request, response);
        } else if (action.equals("initUpdate")) {
            //Lấy thông tin sinh viên để sửa
            int studentIdUpdate = Integer.parseInt(request.getParameter("studentId"));
            Student student = studentService.findById(studentIdUpdate);
            if (student != null) {
                request.setAttribute("student", student);
                request.getRequestDispatcher("views/updateStudent.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        } else if (action.equals("Delete")) {
            int studentIdDelete = Integer.parseInt(request.getParameter("studentId"));
            boolean result = studentService.delete(studentIdDelete);
            if (result){
                getAllStudent(request,response);
            }else{
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }

    }

    public void getAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Nhận request, phân tích request, lựa chọn service và lựa view hiển thị
        //1. Lấy tham số action trên URL (GET) --> phân tích request

        //2. Lựa chọn service thực hiện
        List<Student> listStudent = studentService.findAll();
        //3. Nhận kết quả trả về của service, chọn view thích hợp để hiển thị dữ liệu lên browser
        //3.1. Chuyển listStudent sang view có tên là students.jsp --> cho dữ liệu vào request
        request.setAttribute("listStudent", listStudent);
        //3.2. forward toàn bộ request và response sang students.jsp
        request.getRequestDispatcher("views/students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set trên servlet hỗ trợ UTF-8
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            //Thực hiện thêm mới sinh viên
            //1. Lấy dữ liệu sinh viên cần thêm mới ở body của request
            Student student = new Student();
            student.setStudentName(request.getParameter("studentName"));
            student.setAge(Integer.parseInt(request.getParameter("age")));
            student.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            //2. Chọn service thích hợp để thực hiện thêm mới sinh viên
            boolean result = studentService.save(student);
            if (result) {
                //Thêm mới thành công
                getAllStudent(request, response);
            } else {
                //Thêm mới thất bại
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        } else if (action.equals("Update")) {
            //Thực hiện update
            Student studentUpdate = new Student();
            studentUpdate.setStudentId(Integer.parseInt(request.getParameter("studentId")));
            studentUpdate.setStudentName(request.getParameter("studentName"));
            studentUpdate.setAge(Integer.parseInt(request.getParameter("age")));
            studentUpdate.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            //Gọi service
            boolean result = studentService.update(studentUpdate);
            if (result){
                getAllStudent(request,response);
            }else {
                request.getRequestDispatcher("views/error.jsp").forward(request,response);
            }
        }
    }
}
