import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		
		Comparator<String> comp= new Comparator<>(){
			public int compare(String o1, String o2) {
				if(o1.length()<o2.length())
					return -1;
				else
					return 1;
				
			}
			
			
		};
		
		List<String> list = new ArrayList<>();
		list.add("Sailesh");
		list.add("Manjit");
		list.add("Manish");
		list.add("Gita");
		list.add("Ram");
		Collections.sort(list, comp);
		System.out.println( list);
		
	}
}
