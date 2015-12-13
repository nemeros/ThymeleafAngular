package com.nemeros.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nemeros.api.pojo.Items;

@RestController
@RequestMapping("/api/items")
public class ItemsApi {

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Items> getHome(){
		List<Items> retour = new ArrayList<Items>();
		retour.add(new Items(1, "Bianca"));
		retour.add(new Items(2, "Blanco"));
		retour.add(new Items(3, "Lino"));
		
		return retour;
	}
}
