package com.springboot.mvc;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class BookResolver implements GraphQLResolver<Book> {
	private AuthorRepository authorRepository;
	
	
	public BookResolver(AuthorRepository authorRepository) {
		// TODO Auto-generated constructor stub
		this.authorRepository=authorRepository;
	}

	//public Author getAuthor(Book book)
	//{
	//	return authorRepository.findOne(book.getAuthor().getId());
	//}

}
