package com.springcore.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        @SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        Student1 student1 =  (Student1) context.getBean("student1");
        System.out.println("\nStudentId =" +student1.getStudentId());
        System.out.println("StudentName =" +student1.getStudentName());
        System.out.println("StudentAddress =" +student1.getStudentAddress());
        System.out.println("Subject =" +student1.getSubject());
        
        Student1 student2 = (Student1) context.getBean("student2");
        System.out.println("\nStudentId =" +student2.getStudentId());
        System.out.println("StudentName =" +student2.getStudentName());
        System.out.println("StudentAddress =" +student2.getStudentAddress());
        System.out.println(student2.getSubject());
    }
}
