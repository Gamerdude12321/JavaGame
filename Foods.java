import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Foods {
	private ArrayList<Food> foods = new ArrayList<Food>();
	private int size;
	
	public Foods(int s) {
		size = s;
	}
	
	public Foods(ArrayList<Food> a) {
		foods = a;
	}
	
	public int indexOf(Food food) {
		return foods.indexOf(food);
	}
	
	public void setFood(int index, Food food) {
		foods.set(index, food);
	}
	
	public void addFood(Food food) {
		foods.add(food);
	}
	
	public Food getFood(int index) {
		return foods.get(index);
	}
	
	public int getTotalFoods(){
		return foods.size();
	}
	
	public void foodEaten(Graphics window, Food food) {
		int index = 0;
		if(foods.size() != 0){
			for(int i = 0; i < foods.size(); i++){
				if(foods.get(i) == food){
					index = i;
				}
			}
			foods.get(index).erase(window);
			foods.remove(index);
		}
		
	}
	
	public Food checkHit(Ameoba am) {
		for(int i = 0; i < foods.size(); i++) {
			if(am.getX() > foods.get(i).getX() && am.getX() < foods.get(i).getX() + 50) {
				if(am.getY() > foods.get(i).getY() && am.getY() < foods.get(i).getY() + 50) {
					return foods.get(i);
				}
			}
		}
		return null;
	}
	
	public void draw(Graphics window, int num) {
		if(foods.size() != 0){
			foods.get(num).draw(window);
		}
	}
	
	public void draw(Graphics window) {
		for(int i = 0; i < foods.size(); i++){
			foods.get(i).draw(window);
		}
	}
}