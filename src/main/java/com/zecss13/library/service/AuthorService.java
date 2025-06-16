package com.zecss13.library.service;

import com.zecss13.library.dto.request.AuthorRequestDTO;
import com.zecss13.library.dto.response.AuthorResponseDTO;
import com.zecss13.library.model.Author;
import com.zecss13.library.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public List<AuthorResponseDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AuthorResponseDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + id));
        return convertToResponseDTO(author);
    }

    @Transactional
    public AuthorResponseDTO createAuthor(AuthorRequestDTO requestDTO) {
        Author author = new Author();
        author.setName(requestDTO.getName());
        return convertToResponseDTO(authorRepository.save(author));
    }

    @Transactional
    public AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO requestDTO) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + id));
        author.setName(requestDTO.getName());
        return convertToResponseDTO(authorRepository.save(author));
    }

    @Transactional
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new EntityNotFoundException("Author not found with id: " + id);
        }
        authorRepository.deleteById(id);
    }

    private AuthorResponseDTO convertToResponseDTO(Author author) {
        return new AuthorResponseDTO(author.getId(), author.getName());
    }
}
