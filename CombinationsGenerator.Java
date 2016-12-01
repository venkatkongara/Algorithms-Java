//	printing all combinations of all numbers given in an array. Make sure you implement toString() method in your custom object type<T>, only then the combinations can be properly serialized into string and at the end they can be deserialized 
//	back for fast processing.
//  example usage:
//  ArrayList<Integer> list = new ArrayList<>();
//  for(int i=1;i<7;i++) {
//	  list.add(i);
//  }
//  printCombinations(list,"");
// Author: Venkat Kongara
  
  public static <T> String printCombinations(ArrayList<T>array,String previous) {
	  String current = "";
	  for(int i=0;i<array.size();i++) {
		  current = array.get(i).toString();
		  ArrayList<T> temp = new ArrayList<T>(array);
		  temp.remove(i);
		  String nextItem = printCombinations(temp,previous + current);
		  if(nextItem == "") {
			  System.out.println(previous + current);
		  }
	  }
	  return current;
  }
