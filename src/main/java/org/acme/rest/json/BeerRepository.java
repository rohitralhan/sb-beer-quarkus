package org.acme.rest.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.eclipse.microprofile.config.inject.ConfigProperty;


public class BeerRepository {

	   private static Map<String, Beer> beers = new HashMap<>();
	   
	   static {
	      beers.put("Rodenbach", new Beer("Rodenbach", "Belgium", "Brown ale", 4.2f, "available"));
	      beers.put("Westmalle Triple", new Beer("Westmalle Triple", "Belgium", "Trappist", 3.8f, "available"));
	      beers.put("Weissbier", new Beer("Weissbier", "Germany", "Wheat", 4.1f, "out_of_stock"));
	      beers.put("Orval", new Beer("Orval", "Belgium", "Trappist", 4.3f, "available"));
	      beers.put("Rochefort", new Beer("Rochefort", "Belgium", "Trappist", 4.1f, "out_of_stock"));
	      beers.put("Floreffe", new Beer("Floreffe", "Belgium", "Abbey", 3.4f, "out_of_stock"));
	      beers.put("Maredsous", new Beer("Maredsous", "Belgium", "Abbey", 3.9f, "available"));
	      beers.put("Pilsener", new Beer("Pilsener", "Germany", "Pale beer", 3.2f, "available"));
	      beers.put("Bock", new Beer("Bock", "Germany", "Dark beer", 3.7f, "available"));
	   }

	   public List<Beer> getBeers() throws InterruptedException {
		  Thread.sleep(200L);
	      return new ArrayList<>(beers.values());
	   }

	   public static Beer findByName(String name) {
	      if (beers.containsKey(name)) {
	         return beers.get(name);
	      }
	      return null;
	   }

	   public static List<Beer> findByStatus(String status) {
	      List<Beer> results = beers.values().stream()
	            .filter(beer -> beer.getStatus().equals(status))
	            .collect(Collectors.toList());

	      return results;
	   }
	}