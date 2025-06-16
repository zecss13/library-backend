package com.zecss13.library.service;

import com.zecss13.library.dto.request.CategoryRequestDTO;
import com.zecss13.library.dto.response.CategoryResponseDTO;
import com.zecss13.library.model.Category;
import com.zecss13.library.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        return convertToResponseDTO(category);
    }

    @Transactional
    public CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO) {
        Category category = new Category();
        category.setName(requestDTO.getName());
        return convertToResponseDTO(categoryRepository.save(category));
    }

    @Transactional
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO requestDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        category.setName(requestDTO.getName());
        return convertToResponseDTO(categoryRepository.save(category));
    }

    @Transactional
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }

    private CategoryResponseDTO convertToResponseDTO(Category category) {
        return new CategoryResponseDTO(category.getId(), category.getName());
    }
}
