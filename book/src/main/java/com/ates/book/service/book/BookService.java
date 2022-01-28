package com.ates.book.service.book;

import java.util.List;

import com.ates.book.dao.model.BookEntity;
import com.ates.book.service.model.BookModel;
import com.ates.book.utils.SufficientException;

public interface BookService {
	
	public List<BookModel> getAllBooks();
	
	public BookModel getBookInfo(Long id);
	
	public BookModel addBook(BookModel bookModel);
	
	public Boolean deleteBook(Long id);
	
	public BookEntity checkBookCount(Long bookId, int bookCount) throws SufficientException;

}
