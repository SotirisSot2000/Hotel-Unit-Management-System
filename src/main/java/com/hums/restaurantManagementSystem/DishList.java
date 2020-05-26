package com.hums.restaurantManagementSystem;

import java.util.ArrayList;

public class DishList {
	
	private ArrayList<Dish> dishes = new ArrayList<Dish>();
	
	public DishList()
	{
		dishes = new ArrayList<Dish>();
	}
	
	public void setDishes(ArrayList<Dish> dishes)
	{
		this.dishes = dishes;
	}
	
	public ArrayList<Dish> getDishes()
	{
		return dishes;
	}
	
	public void addDish(Dish dish)
	{	//searches for the new "dish" in  the "dishes" ArrayList
		//if it finds it, replaces the old dish with the new version of itself
		//if it doesn't find it, the new dish is added in the end of the ArrayList
		int flag = 0;
		
		for (int i=0;i<dishes.size();i++) {
			if (dishes.get(i).equals(dish)) {
				dishes.remove(i);
				dishes.add(i, dish);
				flag = 1;
				break;
			}
		}
		if (flag==0) {
			dishes.add(dish);
		}
		//write to file//
	}
	
	public void removeDish(String dishname)
	{
		for(int i=0;i<dishes.size();i++)
		{
			if(dishname.equals(dishes.get(i).getName()))
			{
				dishes.remove(i);
				break;
			}
		}
	}
	
	public void changeDishMenu(String dishname, ArrayList<Integer> dailyMenu) {
		//this method finds the dish "dishname" and changes its menu by calling the method changeMenu of class Dish
		//it works for the first plate it finds with the name "dishname", if there is another dish with the same name it doesn't get  updated
		int flag=0;
		
		for(int i=0;i<dishes.size();i++) {
			if (dishname.equals(dishes.get(i).getName())){
				dishes.get(i).changeMenu(dailyMenu);
				flag=1;
				break;
			}
		}
		if (flag==0) {
			System.out.println("ERROR! The dish wasn't found...");
		}
	}
	
	public ArrayList<int[]> getDishMenu() {
		//gets all menu arrays from every dish in the DishList
		//returns them in an ArrayList<int[]>
		int[] menuMat = new int[7];
		ArrayList<int[]> dishMenu = new ArrayList<int[]>();
		for(int i=0;i<dishes.size();i++) {
			menuMat=dishes.get(i).getMenu();
			dishMenu.add(menuMat);
		}
		return dishMenu;
	}
	
	public ArrayList<Dish> getTodayMenu(int day){
		//scans the ArrayList dishes and checks the array menu of class Dish
		//if the position menu[day] is equal to 1 adds the dish to the  ArrayList<dish> todayMenu
		//return todayMenu
		//NOTE: the value of the day parameter needs to be from 0 to 6
		ArrayList<Dish> todayMenu = new ArrayList<Dish>();
		int dishChecker;
		
		if (day>6 || day<0) {
			System.out.println("ERROR! Not valid day value. Check the input.");
			return null;
		}
		
		for (int i=0;i<dishes.size();i++) {
			dishChecker=dishes.get(i).getMenu()[day];
			if (dishChecker==1) {
				todayMenu.add(dishes.get(i));
			}
		}
		return todayMenu;
	}
}
