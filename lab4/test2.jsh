/open ImmutableList.java
List<Integer> mList = new ArrayList<Integer>(Arrays.asList(1,2,3))
ImmutableList<Integer> imList = new ImmutableList<Integer>(mList)
imList.remove(3)
imList
imList.remove(3).add(2)
imList
imList.remove(6)
imList.add(1).replace(1,3)
imList.add(1).replace(1,1)
imList.replace(6,3)
mList.set(0,10)
mList
imList
Integer[] array = {1, 2, 3}
ImmutableList<Integer> imList = new ImmutableList<Integer>(array)
array[0] = 10
imList
new ImmutableList<Integer>(List.of(4,5,6)).add(7)
ImmutableList<String> stringList = new ImmutableList<String>(Arrays.asList("One","Two","Three"))
stringList.add("Four");
stringList
/exit
