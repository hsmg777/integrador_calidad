
public class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");
        if (grade < 0 || grade > 100) throw new IllegalArgumentException("Grade must be between 0 and 100.");
        this.name = name;
        this.grade = grade;
    }

    public String getName() { return name; }
    public double getGrade() { return grade; }
}
