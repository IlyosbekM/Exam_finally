package task2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String json = Files.readString(Path.of("student.json"));
        Type type = TypeToken.getParameterized(ArrayList.class, Student.class).getType();
        List<Student> students = gson.fromJson(json, type);
        Stream<Student> stream = students.stream();

        Optional<Integer> reduce = stream.map(Student::getAge).reduce(Integer::sum);
        Integer i = reduce.get();
        System.out.println(i / students.size());


//        for (task2.Student st : students) {
//            System.out.println(st.getAge());
//        }

    }
}