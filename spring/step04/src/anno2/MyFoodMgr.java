package anno2;

public class MyFoodMgr {
	private Food favoriteFood;
	private Food unFavoriteFood;

	@Override
	public String toString() {
		return "MyFoodMgr [favoriteFood=" + favoriteFood + ",\n unFavoriteFood=" + unFavoriteFood + "]";
	}

	public Food getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Food getUnFavoriteFood() {
		return unFavoriteFood;
	}

	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}

}
