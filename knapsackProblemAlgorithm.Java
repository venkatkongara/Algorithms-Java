// knapsack problem solution using backtracking. use this method to get the answer with all the possible combinations.
// example:
//	  int[] sampleArray = {10,2,3,4,5,6,7,1};
//	  ArrayList<Integer> sampleSet = new ArrayList<>();
//	  for(int num:sampleArray) {
//		  sampleSet.add(num);
//	  }
// System.out.println(knapSackProblem(sampleSet, 8));
//
// would print [0,1,3,4, 0,1,2,5, 0,3,5, 0,2,6, 0,1,7] as output set of combinations for target 8


// knapsack problem solution using backtracking
public HashSet<String> knapSackProblem(ArrayList<Integer> sampleSet,int target) {
    Set<String> set = new HashSet<String>();
    Collections.sort(sampleSet);
    ArrayList<String> list = findCombinations(sampleSet, target);
    set.addAll(list);
    return (HashSet<String>) set;
}

private ArrayList<String> findCombinations(ArrayList<Integer> sampleSet,int target) {
    ArrayList<String> list = new ArrayList<>();
    if(sampleSet.size() == 0) {
        return list;
    }
    int selectedNum = 0;
    int sum = 0;
    int i =0;
    while(sum <= target && i<sampleSet.size()) {
        selectedNum = sampleSet.get(i);
        sum = sum + selectedNum;
        i++;
        if(sum == target) {
            String combo = "0";
            for(int j=0;j<i;j++) {
                combo = combo + "," + sampleSet.get(j).toString();
            }
        list.add(combo);
        }
        ArrayList<Integer> reducedList = new ArrayList<>(sampleSet);
        reducedList.remove(i-1);
        list.addAll(findCombinations(reducedList, target));
    }
    return list;
}
