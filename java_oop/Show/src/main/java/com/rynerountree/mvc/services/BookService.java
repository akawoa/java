package com.rynerountree.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rynerountree.mvc.models.Book;
import com.rynerountree.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
	}
	
	// deletes a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
  
    // edits a book
    public Book updateBook(Book b) {
    	return bookRepository.save(b);
    }
    
    public Optional<Book> updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Optional <Book> temp = bookRepository.findById(id);
    	/*
    	if(temp != null) {
    		temp.get().setTitle(title);
    		temp.get().setDescription(desc);
    		temp.get().setLanguage(lang);
    		temp.get().setNumberOfPages(numOfPages);

    		return bookRepository.save(temp);
    		*/
    		if (bookRepository.findById(id).isPresent()) {
    			Book existingBook = bookRepository.findById(id).get();
    			
        		existingBook.setTitle(title);
        		existingBook.setDescription(desc);
        		existingBook.setLanguage(lang);
        		existingBook.setNumberOfPages(numOfPages);
        		
        		Book updatedBook = bookRepository.save(existingBook);
        		
        		return bookRepository.findById(updatedBook.getId());
    		
    	}
    	return null;        
    }    
    
}
