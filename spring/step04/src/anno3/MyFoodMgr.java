package anno3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myfoodmgr")
public class MyFoodMgr {

	//Qualifier("favoriteFood") : 특정 빈 객체를 설정할 때 사용,반드시 autowired랑 같이 사용해야함.
	@Autowired
	@Qualifier("favoriteFood1")
	private Food favoriteFood;

	@Autowired
	@Qualifier("unFavoriteFood1")
	private Food unFavoriteFood;

	@Override
	public String toString() {
		return "MyFoodMgr [favoriteFood=" + favoriteFood + ",\n unFavoriteFood=" + unFavoriteFood + "]";
	}
	

}
