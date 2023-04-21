package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;

public class StudentService {
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent(Student student) {
        //TODO Add new student to the students hashmap

        students.put(student.getId(), student);
    }

    public Student findStudent(String studentId) {
        //TODO Find the student from the Hashmap with the student id
        return students.get(studentId);
    }

    public void enrollToCourse(String studentId, Course course) {
        //TODO check if students hashmap contains the studentsId, if not enroll student to the course
        if (students.containsKey(studentId)) {
            Student student = students.get(studentId);
            EnrolledCourse enrolledCourse = new EnrolledCourse(course);
            student.getEnrolledCourses().put(course.getCode(), enrolledCourse);
        }
    }

    public void showSummary() {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses
        System.out.println("Student details: ");
        for (Student student : students.values()) {
            System.out.println(student);
            System.out.println("Enrolled courses:");
            HashMap<String, EnrolledCourse> enrolledCourses = enrolledCourses(student);
            System.out.println(enrolledCourses);
        }

    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student) {
        //TODO return a HashMap of all the enrolledCourses
        return student.getEnrolledCourses();

    }

    public Course findEnrolledCourse(Student student, String courseId) {
        //TODO return the course enrolled by the student from the course Id
        if (enrolledCourses(student).containsKey(courseId)) {
            return enrolledCourses(student).get(courseId);
        }
        return null;
    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }


    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}// End of StudentService Class
