package com.springboot.mvc;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {

	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public Mutation(AuthorRepository authorRepository,BookRepository bookRepository) 
	{
	this.authorRepository=authorRepository;
	this.bookRepository=bookRepository;
	}
	
	
	
	public Author newAuthor(String firstName,String lastName)
	{
		Author author=new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);
		
		authorRepository.save(author);
		return author;
	}
	
	public Book newBook(String title,String isbn,Integer pageCount,Long authorId)
	{
		Book book=new Book();
		book.setAuthor(new Author(authorId));
		book.setTitle(title);
		book.setIsbn(isbn);;
		book.setPageCount(0);
		bookRepository.save(book);
		
		return book;
		
	}
	
	
	
}
