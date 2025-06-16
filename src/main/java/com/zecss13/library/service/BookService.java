package com.zecss13.library.service;

import com.zecss13.library.dto.request.BookRequestDTO;
import com.zecss13.library.dto.response.BookResponseDTO;
import com.zecss13.library.model.Author;
import com.zecss13.library.model.Book;
import com.zecss13.library.model.Category;
import com.zecss13.library.repository.AuthorRepository;
import com.zecss13.library.repository.BookRepository;
import com.zecss13.library.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BookResponseDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
        return convertToResponseDTO(book);
    }

    @Transactional
    public BookResponseDTO createBook(BookRequestDTO requestDTO) {
        Author author = authorRepository.findById(requestDTO.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + requestDTO.getAuthorId()));
        
        Category category = categoryRepository.findById(requestDTO.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + requestDTO.getCategoryId()));

        Book book = new Book();
        book.setTitle(requestDTO.getTitle());
        book.setIsbn(requestDTO.getIsbn());
        book.setAuthor(author);
        book.setCategory(category);

        return convertToResponseDTO(bookRepository.save(book));
    }

    @Transactional
    public BookResponseDTO updateBook(Long id, BookRequestDTO requestDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));

        Author author = authorRepository.findById(requestDTO.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + requestDTO.getAuthorId()));
        
        Category category = categoryRepository.findById(requestDTO.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + requestDTO.getCategoryId()));

        book.setTitle(requestDTO.getTitle());
        book.setIsbn(requestDTO.getIsbn());
        book.setAuthor(author);
        book.setCategory(category);

        return convertToResponseDTO(bookRepository.save(book));
    }

    @Transactional
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    private BookResponseDTO convertToResponseDTO(Book book) {
        return new BookResponseDTO(
            book.getId(),
            book.getTitle(),
            book.getAuthor().getName(),
            book.getIsbn(),
            book.getCategory().getName()
        );
    }
} 