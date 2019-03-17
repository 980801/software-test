package takeOut;

import java.util.ArrayList;


public class Money {
	
	ArrayList<Integer> havemoney = new ArrayList<Integer>() {{add(50); add(20); add(5); add(5); add(1); add(1); add(1);}};
	public boolean can_take_out(int number) {
		if(havemoney.contains(number)){
			return true;
		}
		else {
			for(int i = 0; i < havemoney.size(); i++) {
				if(number > havemoney.get(i)) {
					int pay = havemoney.get(i);
					havemoney.remove(i);
					return can_take_out(number - pay);
				}
			}
			return false;
		}
	}
}
