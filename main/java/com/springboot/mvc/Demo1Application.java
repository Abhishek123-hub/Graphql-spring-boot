package com.springboot.mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo1Application
{

public static void main(String[] args) 
   {

SpringApplication.run(Demo1Application.class, args);
   }

@Bean
public BookResolver authorResolver(AuthorRepository authorRepository)
{
	return new BookResolver(authorRepository);
}

@Bean
public Query query(AuthorRepository authorRepository,BookRepository bookRepository)
{
	return new Query(authorRepository,bookRepository);
	
}
@Bean 
public Mutation mutation(AuthorRepository authorRepository,BookRepository bookRepository)
{
	return new Mutation(authorRepository,bookRepository);
}


@Bean
public CommandLineRunner demo(AuthorRepository authorRepository,BookRepository bookRepository)
{
	return (args) ->
	   {
		for(int i=1;i<=50;i++)
		       {
		Author author=new Author("Herbert"+i,"Schildt"+i);
		authorRepository.save(author);
		bookRepository.save(new Book("Java : A Beginner's Guide"+i, "A0"+i,i, author));
		         }
	   };

}

   }

