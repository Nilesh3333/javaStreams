public record Person(String name, String lastName, int age, double salary, String department, String city) {


    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
