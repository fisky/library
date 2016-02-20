/*
	input string is "(){}[]"
*/
public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length()%2 != 0) return false;
        HashMap<Character, Character> myMap = new HashMap<Character, Character>();
        myMap.put('(', ')');
        myMap.put('[', ']');
        myMap.put('{', '}');
        Stack<Character> myStack = new Stack<Character>();
        for(int i = 0; i < s.length(); ++i)
        {
            if(myStack.empty())
            {
                if(myMap.containsKey(s.charAt(i)))
                    myStack.push(s.charAt(i));
                else
                    return false;
            }
            else
            {
                if(myMap.get(myStack.peek()) == s.charAt(i))
                    myStack.pop();
                else if(myMap.containsKey(s.charAt(i)))
                    myStack.push(s.charAt(i));
                else
                    return false;
            }
        }
        return myStack.empty();
    }
}