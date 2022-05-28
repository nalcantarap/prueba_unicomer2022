package com.example.demo.util;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.enums.GenderEnum;

@Service
public class CustomerMapping {

	public Customer modelToEntity(CustomerDTO entry) {
		Customer customer=null;
		if (entry!=null && entry.getFirstName()!=null && entry.getLastName()!=null && !entry.getFirstName().trim().isEmpty() && !entry.getLastName().trim().isEmpty()){
			customer=new Customer();
			customer.setAddresshome(entry.getAddresshome());
			customer.setBirthday(entry.getBirthday());
			customer.setCellphone(entry.getCellphone());
			customer.setFirstName(entry.getFirstName());
			customer.setGender(entry.getGender().getCode());
			customer.setHomephone(entry.getHomephone());
			customer.setId(entry.getId());
			customer.setIncomes(entry.getIncomes());
			customer.setLastName(entry.getLastName());
			customer.setProfession(entry.getProfession());
		}
		return customer;
	}
	public CustomerDTO entityToModel(Customer entry) {
		CustomerDTO customer=null;
		if (entry!=null){
			customer=new CustomerDTO();
			customer.setAddresshome(entry.getAddresshome());
			customer.setBirthday(entry.getBirthday());
			customer.setCellphone(entry.getCellphone());
			customer.setFirstName(entry.getFirstName());
			customer.setGender(entry.getGender().equals(GenderEnum.MALE.getCode())?GenderEnum.MALE:GenderEnum.FEMALE);
			customer.setHomephone(entry.getHomephone());
			customer.setId(entry.getId());
			customer.setIncomes(entry.getIncomes());
			customer.setLastName(entry.getLastName());
			customer.setProfession(entry.getProfession());
		}
		return customer;
	}
}
