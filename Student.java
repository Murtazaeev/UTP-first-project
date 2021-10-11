public class Student implements IAggregable<Student, Double>, IDeeplyCloneable<Student> {

    private String name;
    private double averageGrade;

    Student(String name, double averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    String getName() {
        return name;
    }

    double getAverageGrade() {
        return averageGrade;
    }

    public Double aggregate(Double iResult) {
        return iResult == null ? averageGrade : (averageGrade > iResult ? averageGrade : iResult);
    }

    public Student deepClone() {
        return new Student(name, averageGrade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
    }
}