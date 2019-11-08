import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpecialStreamExercise 
{
	
	public static LinkedList<Integer> getSquaresOfThree(){
		List<Integer> res=Stream.iterate(20, n ->n+1).limit(30).filter((n) -> n%3==0 && n%2==1).collect(Collectors.toList());
		LinkedList<Integer> result=new LinkedList<>(res);
		return result;
	}
	public static Object[] getMultiplesOfFive(){
		Object[] result=Stream.iterate(5, m -> m+5).limit(20).toArray();
		return result;
	}
	public static void main(String[] args) 
	{
		SpecialStreamExercise.getSquaresOfThree();
		SpecialStreamExercise.getMultiplesOfFive();
	
	}
}
