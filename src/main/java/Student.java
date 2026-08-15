public class Student {

    private String name;
    private String course;
    private int year;
    private int semester;

    public Student(String name, String course, int year, int semester) {
        this.name = name;
        this.course = course;
        this.year = year;
        this.semester = semester;
    }

    public void displayStudentInfo() {

        System.out.println("\n----- Student Information -----");
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Year: " + year);
        System.out.println("Semester: " + semester);
        System.out.println("-------------------------------");
    }
}