package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories= new ArrayList<>();
	static {
		Category category= new Category();
		category.setName("Television");
		category.setId(1);
		category.setImageURL("CAT_1.png");
		category.setDescription("This is good Television");
		categories.add(category);
		//category 2
		category= new Category();
		category.setName("Mobile");
		category.setId(2);
		category.setImageURL("CAT_2.png");
		category.setDescription("This is good Mobile");
		categories.add(category);
		
		//category 3
				category= new Category();
				category.setName("Laptop");
				category.setId(3);
				category.setImageURL("CAT_3.png");
				category.setDescription("This is good Laptop");
				categories.add(category);
	}
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	@Override
	public Category get(int id) {
		
		for(Category category:categories) {
			if(category.getId()==id) return category;
		}
		return null;
	}

}
