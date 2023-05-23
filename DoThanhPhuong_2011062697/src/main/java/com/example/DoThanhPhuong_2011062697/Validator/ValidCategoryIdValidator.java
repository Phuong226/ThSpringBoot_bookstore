package com.example.DoThanhPhuong_2011062697.Validator;


import com.example.DoThanhPhuong_2011062697.Validator.annotation.ValidCategoryId;
import com.example.DoThanhPhuong_2011062697.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context){
        return category != null && category.getId() !=null;
    }
}
