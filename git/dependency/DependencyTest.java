package dependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DependencyTest {


	public Map<Character,Set<Character>> depTest1(){
		
		Character[] charArray1 = {'A','B','T','W'};
		Character[] charArray2 = {'B','F'};
		Character[] charArray3 = {'O','Y','K'};
		Character[] charArray4 = {'Y','K','L'};
		Character[] charArray5 = {'F','I','N','G','Q'};
		
		List<Character[]> charArrayList = new ArrayList<Character[]>();
		charArrayList.add(charArray1);
		charArrayList.add(charArray2);
		charArrayList.add(charArray3);
		charArrayList.add(charArray4);
		charArrayList.add(charArray5);
		
		Map<Character,Set<Character>> result = null;
		DependencyCal dependencyCal = new DependencyCal();
		result = dependencyCal.calculateDep(charArrayList);
		
		return result;
		
	}
	
	
public Map<Character,Set<Character>> depTest2(){
		
		Character[] charArray1 = {'U','I'};
		Character[] charArray2 = {'U','J','L'};
		Character[] charArray3 = {'L','O','S'};
		Character[] charArray4 = {'J','Y','K'};
		Character[] charArray5 = {'Y','O'};
		
		List<Character[]> charArrayList = new ArrayList<Character[]>();
		charArrayList.add(charArray1);
		charArrayList.add(charArray2);
		charArrayList.add(charArray3);
		charArrayList.add(charArray4);
		charArrayList.add(charArray5);
		
		Map<Character,Set<Character>> result = null;
		DependencyCal dependencyCal = new DependencyCal();
		result = dependencyCal.calculateDep(charArrayList);
		
		return result;
		
	}

public Map<Character,Set<Character>> depTest3(){
	
	Character[] charArray1 = {'S','T'};
	Character[] charArray2 = {'T','F','L'};
	Character[] charArray3 = {'F','Y','K',};
	Character[] charArray4 = {'Y','O'};
	
	List<Character[]> charArrayList = new ArrayList<Character[]>();
	charArrayList.add(charArray1);
	charArrayList.add(charArray2);
	charArrayList.add(charArray3);
	charArrayList.add(charArray4);
	
	Map<Character,Set<Character>> result = null;
	DependencyCal dependencyCal = new DependencyCal();
	result = dependencyCal.calculateDep(charArrayList);
	
	return result;
	
}
}



