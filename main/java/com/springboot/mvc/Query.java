package com.springboot.mvc;



import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {

private AuthorRepository authorRepository;
private BookRepository bookRepository;

public Query(AuthorRepository authorRepository,BookRepository bookRepository) 
{
this.authorRepository=authorRepository;
this.bookRepository=bookRepository;
}

public Iterable<Book> findAllBooks()
{
	return bookRepository.findAll();
}


public Iterable<Author> findAllAuthors()
{
	return authorRepository.findAll();
}

public long countAuthors()
{
	return authorRepository.count();
}
public long countBooks()
{
	return bookRepository.count();
}

}