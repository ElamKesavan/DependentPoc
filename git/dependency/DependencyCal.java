package dependency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class uses most of Java util Collections for calculating dependecies. Used Concurrent hashmap to enable modification of Set outside iterating loop
 * @author Elamparuthi
 *
 */
public class DependencyCal {


	public static void main(String[] args) {

		DependencyTest dependencyTest = new DependencyTest();
		System.out.println(dependencyTest.depTest1());
		System.out.println(dependencyTest.depTest2());
		System.out.println(dependencyTest.depTest3());

	}

/**
 * This method will calculate dependencies among the characters in the list of Character arrays given.
 * @param charList
 * @return
 */
	public Map<Character,Set<Character>> calculateDep(List<Character[]> charList){

		//Declarations:
		Map<Character,Set<Character>> masterMap = new HashMap<Character,Set<Character>>();
		Set<Character> masterSet = new HashSet<Character>();
		Set<Character> masterSubSet = null;
		
		//Set to masterSet
		for(Character[] ca1 : charList){

			for(char c1 : ca1){
				masterSet.add(c1);
			}
		}
	//	System.out.println("Master Set values : "+masterSet);
		
		//Loop master set characters against each Character Array and find dependencies
		for(Character c2 : masterSet){
			
			//Using ConcurrentHashMap as masterSubset will be modified outside iterating loop
			masterSubSet = ConcurrentHashMap.newKeySet();
			
			//put character in loop and new TreeSet as value which will have nothing for masterMap 
			masterMap.put(c2, masterSubSet);
			
			//Loop through main charArrayList having input list of Character arrays
			for(Character[] ca2 : charList){
				
				boolean metChar1= false;
				
				for(Character c1 : ca2){
					
					if(c1==c2){
						metChar1 = true;
						continue;
					}

					if(metChar1){
						masterSubSet.add(c1);
						masterMap.put(c2, masterSubSet);
					}
					
					//Find next level dependencies for resulted masterSubset if has values
					for(Character c3 : masterSubSet){
						
						for(Character[] ca3 : charList){
							
							boolean metChar2 = false;
							
							for(Character c4 : ca3){
								
								if(c4==c3){
									metChar2 = true;
									continue;
								}
								
								if(metChar2){
									masterSubSet.add(c4);
									masterMap.put(c2, masterSubSet);
									//System.out.println("Master map values inside if: "+masterMap);
								}
							}
						}
						
					}
				}
			}
			
		}
		
		return masterMap;
	}
	


}
