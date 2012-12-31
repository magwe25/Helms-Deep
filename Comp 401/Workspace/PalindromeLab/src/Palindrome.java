import static java.lang.System.out;

//  Write 3 methods that each test an input for being a palindrome.
//  All 3 must be recursive with no loops.
//  plaindrome2 modifies plaindrome1 to ignore any space characters
//  in the input string.  For example "ab  b a" returns false
//  from palindrome1 but true from palindrome2.
//  palindrome3 generalizes palindrome2 by using the template
//  design patter.  The client supplies an object used by 
//  palindrome3 to determine which characters to ignore.
//  You will need to define the interface CharacterFilter and
//  one class implementing it, SpaceFilter, that causes
//  palindrome3 to ignore any spaces in the input.
//
//  For String s, s.charAt(int index) returns the single character
//  at position index.  For example, String s = "ab  ba"
//  s.charAt(0) = 'a'  s.charAt(1) = 'b'  s.charAt(2) = ' '
//  Remember that single quotes are used for char literals
//  and double quotes for strings.
//
//  If you complete palindrome 1-3, write a JUnit test for
//  palindrome2.  Think out the boundary conditions.
//  Put a test table in the comments of your JUnit test.
//  For example:
//     input          expected return
//     "ab  ba"       true
//     "x"            true
// ........
//
public class Palindrome {
	
	public static void main(String[] args ) {
		System.out.println(palindrome1("abcba"));
		System.out.println(palindrome1("a   b   c          cb    a"));
		System.out.println(palindrome2("abcba"));
		System.out.println(palindrome2("a   b   c       c   b   a"));
		System.out.println(palindrome1("cat"));
		System.out.println(palindrome2("cat"));
		
		CharacterFilter filter = new SpaceFilter();
		System.out.println(palindrome3("abcba", filter));
		System.out.println(palindrome3("a   b   c       c   b   a", filter));
		System.out.println(palindrome3("cat", filter));
		

	}
	

	
	// Check for palindrome.  No special treatment of any characters.
	public static boolean palindrome1(String s){
		return palindrome1Helper(s,0);
	}
	
	
	private static boolean palindrome1Helper(String s, int index) {
		if (index < s.length()-index+1)
			if (s.charAt(index) == s.charAt(s.length()-(index+1)))
				return palindrome1Helper(s, index+1);
			else 
				return false;
		else 
			return true;
	}

	// Check for palindrome.  Spaces ignored.
	public static boolean palindrome2(String s ) {
		return palindrome2Helper(s,0, s.length()-1);

	}
	private static boolean palindrome2Helper(String s, int index, int index2){
		if (index < index2)
			if (s.charAt(index) == ' ')
				return palindrome2Helper(s, index+1, index2);
		
			else
				if (s.charAt(index2) == ' ')
					return palindrome2Helper(s, index, index2-1);
				else if (s.charAt(index2) == s.charAt(index))
					return palindrome2Helper(s, index+1, index2-1);
				else 
					return false;
		else 
			return true;
	}
	
	
	// Check for palindrome.  filter.accept() chooses characters considered significant.
	public static boolean palindrome3(String s, CharacterFilter filter ) {
		return palindrome3Helper(s, 0, s.length()-1, filter);
	}
	
	public static boolean palindrome3Helper(String s, int index, int index2, CharacterFilter filter){
		if (index < index2)
			if (filter.accept(s.charAt(index)))
				return palindrome2Helper(s, index+1, index2);
		
			else
				if (filter.accept(s.charAt(index2)))
					return palindrome2Helper(s, index, index2-1);
				else if (s.charAt(index2) == s.charAt(index))
					return palindrome2Helper(s, index+1, index2-1);
				else 
					return false;
		else 
			return true;
		
	}

}