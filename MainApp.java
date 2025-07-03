public class MainApp {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        service.addStudent("John Doe", 85.5);
        service.listStudents();
    }
}
