import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 25, 60000, "Engineering", "New York"),
                new Person("Jane", "Doe", 30, 65000, "Marketing", "New York"),
                new Person("John", "Smith", 35, 70000, "Engineering", "San Francisco"),
                new Person("Alice", "Johnson", 28, 62000, "HR", "Chicago"),
                new Person("Bob", "Brown", 40, 75000, "Engineering", "Los Angeles"),
                new Person("Emily", "Davis", 33, 68000, "Marketing", "San Francisco"),
                new Person("Michael", "Williams", 27, 61000, "HR", "Chicago"),
                new Person("Sophia", "Miller", 32, 69000, "Engineering", "Los Angeles"),
                new Person("David", "Wilson", 29, 63000, "Marketing", "New York"),
                new Person("Olivia", "Moore", 31, 67000, "Engineering", "San Francisco")
        );


        //Given a list of people, create a map where their name is the key and value is the  people.                ---> GroupingBy
        Map<String, List<Person>> question1 = people.stream()
                .collect(Collectors.groupingBy(Person::name));
        System.out.println("Question1");
        question1.forEach((name,peopleList) -> System.out.println(name + " " + peopleList));
        System.out.println();


        //Given a list of people, create a map where their name is the key and value should be length .        -------> GroupingBy and mapping  --- mapping variable should link with groupingBy variable
        Map<String, List<Integer>> question2 = people.stream()
                .collect(Collectors.groupingBy(
                        Person::name,
                        Collectors.mapping(person -> person.name().length(),Collectors.toList())
                ));

        System.out.println("Question2");
        question2.forEach((name,peopleList) -> System.out.println(name + " " + peopleList));
        System.out.println();


        //Given a list of people, find the person with the highest salary.                              ---------------->max()
        Optional<Person> question3 = people.stream()
                .max(Comparator.comparing(Person::salary));
        System.out.println("Question3");
        System.out.println("Person with Highest Salary "+ question3);
        System.out.println();


        //Given a list of people, create a list of their names in uppercase.                           ---------------->map
        List<String> question4 = people.stream()
                .map(person -> person.name().toUpperCase())
                .toList();
        System.out.println("Question4");
        System.out.println("List of Persons with name in UpperCase "+ question4);
        System.out.println();


        //Given a list of people, count how many people have a salary greater than 50,000.           ------------------> filter, Count
        long question5 =  people.stream()
                .filter(person -> person.salary() > 50000)
                .count();
        System.out.println("Question5");
        System.out.println("people having salary greater than 50000 "+ question5);
        System.out.println();
        

        //Given a list of people, partition them into two lists:                                 ---------------------->partitioningBy
        // one for people older than 30 and one for people 30 or younger.
        Map<Boolean, List<Person>> question6 = people.stream()
                .collect(Collectors.partitioningBy(person -> person.age() > 30));
        System.out.println("Question6");
        System.out.println("people having age greater than 30 " + question6.get(true));
        System.out.println("people having age less than 30 " + question6.get(false));
        System.out.println();
        

    //Given a list of people, group them by their department.                                                   ------->groupingBy
        Map<String, List<Person>> question7 = people.stream()
                .collect(Collectors.groupingBy(Person::department));
        System.out.println("Question7");
        System.out.println("people belongs to the same group ");
        question7.forEach((name,peopleList) -> System.out.println(name + " " + peopleList));
        System.out.println();
        
        
    //  Given a list of people, find the average age of people in each department.                      ---------------> groupingBy,averagingInt
        Map<String, Double> question8 = people.stream()
                .collect(Collectors.groupingBy(
                        Person::department,
                        Collectors.averagingInt(Person::age)
                ));
        System.out.println("Question8");
        System.out.println("Department average age ");
        question8.forEach((name,peopleList) -> System.out.println(name + " " + peopleList));
        System.out.println();
        

    //  Given a list of people, create a map where the key is the department and                        ---------------> groupingBy, counting
        //the value is the count of people in that department.
        Map<String, Long> question9 = people.stream()
                .collect(Collectors.groupingBy(
                        Person::department,
                        Collectors.counting()
                ));
        System.out.println("Question9");
        System.out.println("Department average age ");
        question9.forEach((name,peopleList) -> System.out.println(name + " " + peopleList));
        System.out.println();
        
        
    // Given a list of people, check if all people have a salary greater than 30,000.                       -----------> allMatch
        boolean question10 = people.stream()
                .allMatch(person -> person.salary() > 30000);
        System.out.println("question10");
        System.out.println("all people have a salary greater than 30,000 "+ question10);
        System.out.println();


    //Given a list of people, check if any person is older than 65.                                     --------------->anyMatch
        boolean question11 = people.stream()
                .anyMatch(person -> person.age() > 65);
        System.out.println("question11");
        System.out.println("if any person is older than 65. "+ question11);
        System.out.println();
        

    //  Given a list of people, find the first person whose name starts with 'J'.                   -------------------> Filter, findFirst, startsWith
        Optional<Person> question12 = people.stream()
                .filter(person -> person.name().startsWith("J"))
                .findFirst();
        System.out.println("question12");
        System.out.println("first person whose name starts with 'J' "+ question12);
        System.out.println();

        
    // Given a list of people, create a list of people sorted by their age.                             ---------------> sorted

        List<Person> question13 = people.stream()
                .sorted(Comparator.comparing(Person::age))
                .toList();
        System.out.println("Question13");
        System.out.println("list of people sorted by their age "+ question13);
        System.out.println();


    //  Given a list of people, create a comma-separated string of their names.                         ---------------> map,joining
        String question14 = people.stream()
                .map(Person::name)
                .collect(Collectors.joining(","));
        System.out.println("Question14");
        System.out.println("comma-separated string of their names "+ question14);
        System.out.println();


    //  Given a list of people, create a map where the key is the first letter of their last name       ---------------> groupingBy
    //  and the value is a list of people with last names starting with that letter.
        Map<Character, List<Person>> question15 = people.stream()
                .collect(Collectors.groupingBy(
                        person -> person.lastName().charAt(0)));
        System.out.println("question15");
        System.out.println("GroupBy LastName First Letter ");
        question15.forEach((name,peopleList) -> System.out.println(name + " " + peopleList));
        System.out.println();


    //  Given a list of people, find the sum of all salaries.                                           ---------------> Sum
        double question16 = people.stream()
                .mapToDouble(Person ::salary)
                .sum();
        System.out.println("question16");
        System.out.println("sum of all salaries. "+ question16);
        System.out.println();


    //  Given a list of people, create a map where the key is the age and the value is a list of people with that age.
        Map<Integer, List<Person>> question17 = people.stream()
                .collect(Collectors.groupingBy(Person::age));
        System.out.println("question17");
        System.out.println("key is the age and the value is a list of people with that age ");
        question17.forEach((name,peopleList) -> System.out.println(name + " " + peopleList));
        System.out.println();



    //  Given a list of people, find the person with the minimum age.                                       -----------> min
        Optional<Person> question18 = people.stream()
                .min(Comparator.comparingInt(Person::age));
        System.out.println("question18");
        System.out.println("the person with the minimum age "+ question18);
        System.out.println();


    //  Given a list of people, filter out people who have a name length less than 5 characters.        ---------------> Filter
        List<Person> question19 = people.stream()
                .filter(person -> person.name().length() > 5)
                .toList();
        System.out.println("question19");
        System.out.println("People who have a name length greater than 5 characters "+ question19);
        System.out.println();


    //  Given a list of integers, find the sum of all ages.                                             ---------------> reduce
        Integer question20 = people.stream()
                .map(Person::age)
                .reduce(0, Integer::sum);
        System.out.println("question20");
        System.out.println("sum of all ages "+ question20);
        System.out.println();


    // Given a list of strings, concatenate all strings into a single comma-separated firstName.            ----------->reduce
        String question21 = String.valueOf(people.stream()
                .map(Person::name)
                .reduce((a,b) -> a + ","+b));
        System.out.println("question21");
        System.out.println("concatenate all strings into a single comma-separated firstName "+ question21);
        System.out.println();
        
        
     //Given a list of Person objects, find all unique cities where they reside.                ----------------------->distinct,Map
        List<String> question22 = people.stream()
                .map(Person::city)
                .distinct()
                .toList();
        System.out.println("question22");
        System.out.println(" all unique cities where they reside "+ question22);
        System.out.println();


    //Given a list of Person objects sorted by age, retrieve the youngest 3 persons.
        List<Person> question23 = people.stream()
                .sorted(Comparator.comparing(Person::age))
                .limit(3)
                .toList();
        System.out.println("question23");
        System.out.println(" Person objects sorted by age, retrieve the youngest 3 persons "+ question23);
        System.out.println();


     //skip the first 2 highest salaries and get the next 5                                                 -----------> Skip,Limit,Sorted,Reversed
        List<Person> question24 = people.stream()
                .sorted(Comparator.comparingDouble(Person::salary).reversed())
                .skip(2)
                .limit(5)
                .toList();
        System.out.println("question24");
        System.out.println(" Person objects sorted by age, retrieve the youngest 3 persons "+ question24);
        System.out.println();

    }
}