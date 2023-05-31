package com.example.DoThanhPhuong_2011062697.controller;

import com.example.DoThanhPhuong_2011062697.entity.Category;
import com.example.DoThanhPhuong_2011062697.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllCategory(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "category/list";
    }


    @GetMapping("/add")
    public String addCategoryForm(Model model){
        model.addAttribute("category",new Category());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/add";
    }
    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category")Category category, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());

            return "category/add";
        }
        categoryService.addCategory(category);
        return "redirect:/category";
    }


    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") Long CategoryID, Model model) {
        Category category = categoryService.getCategoryById(CategoryID);
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "Category/edit";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long CategoryID, @ModelAttribute("Category") Category updateCategory) {
        Category category = categoryService.getCategoryById(CategoryID);
        category.setName(updateCategory.getName());
        categoryService.updateCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long CategoryID) {
        categoryService.deleteCategory(CategoryID);
        return "redirect:/category";
    }

}
