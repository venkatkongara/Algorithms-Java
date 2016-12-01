// knapsack problem solution using backtracking
public static HashSet<String> knapSackProblem(ArrayList<Integer> sampleSet,int target) {
Set<String> set = new HashSet<String>();
Collections.sort(sampleSet);
ArrayList<String> list = findCombinations(sampleSet, target);
set.addAll(list);
return (HashSet<String>) set;
}

public static ArrayList<String> findCombinations(ArrayList<Integer> sampleSet,int target) {
ArrayList<String> list = new ArrayList<>();
if(sampleSet.size() == 0) {
return list;
}
int selectedNum = 0;
int sum = 0;
int i =0;
while(sum < target && i<sampleSet.size()) {
selectedNum = sampleSet.get(i);
sum = sum + selectedNum;
i++;
ArrayList<Integer> reducedList = new ArrayList<>(sampleSet);
reducedList.remove(i-1);
list.addAll(findCombinations(reducedList, target));
}
if(sum >= target) {
if(sum == target) {
String combo = "0";
for(int j=0;j<i;j++) {
combo = combo + "," + sampleSet.get(j).toString();
}
list.add(combo);
ArrayList<Integer> reducedList = new ArrayList<>(sampleSet);
reducedList.remove(i-1);
list.addAll(findCombinations(reducedList, target));
}
ArrayList<Integer> reducedList = new ArrayList<>(sampleSet);
reducedList.remove(0);
list.addAll(findCombinations(reducedList, target));
}
return list;
}