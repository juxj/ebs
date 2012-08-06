package org.tju.ebs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tju.ebs.entity.Category;
import org.tju.ebs.service.AccountService;
import org.tju.ebs.utils.DataSourceContextHolder;
import org.tju.ebs.utils.DataSourceName;


@Controller
public class CategoryController {
	
	@Autowired
	private AccountService accountService;

	@RequestMapping("/category/showCategoryHome/{accountId}")
	public ModelAndView showCategoryHome(@PathVariable int accountId, HttpServletRequest request, HttpServletResponse response) {
		int shardingIndex = accountId % 2;
		
		if (shardingIndex==0) {
			DataSourceContextHolder.setCurrentDataSource(DataSourceName.DS_PRODUCT_0);
		} else {
			DataSourceContextHolder.setCurrentDataSource(DataSourceName.DS_PRODUCT_1);
		}
		
		List<Category> list = this.accountService.getCategoryList();
		return new ModelAndView("category_home", "categoryList", list);
	}
	
}
