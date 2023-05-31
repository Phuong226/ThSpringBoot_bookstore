package com.example.DoThanhPhuong_2011062697.services;

import com.example.DoThanhPhuong_2011062697.entity.Category;
import com.example.DoThanhPhuong_2011062697.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public List<Category>getAllCategories(){
        return categoryRepository.findAll();
    }
    public  Category getCategoryById(Long id){
        Optional<Category>optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()){
            return optionalCategory.get();
        }else {
            throw new RuntimeException("Category not found");
        }
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }
    public Category saveCategory(Category category){ return categoryRepository.save(category); }
    public void deleteCategory(Long id){ categoryRepository.deleteById(id); }
}
