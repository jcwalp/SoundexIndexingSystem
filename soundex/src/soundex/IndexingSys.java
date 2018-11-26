
//  ---_____-------------------------------_------------------
//  --/-____|-----------------------------|-|-----------------
//  -|-(___-----___----_---_---_-__-----__|-|---___--__--__---
//  --\___-\---/-_-\--|-|-|-|-|-'_-\---/-_`-|--/-_-\-\-\/-/---
//  --____)-|-|-(_)-|-|-|_|-|-|-|-|-|-|-(_|-|-|--__/-->--<----
//  -|_____/---\___/---\__,_|-|_|-|_|--\__,_|--\___|-/_/\_\---
//  --_____---------------_-----------------_-----------------
//  -|_---_|-------------|-|---------------(_)----------------
//  ---|-|----_-__-----__|-|---___--__--__--_---_-__-----__-_-
//  ---|-|---|-'_-\---/-_`-|--/-_-\-\-\/-/-|-|-|-'_-\---/-_`-|
//  --_|-|_--|-|-|-|-|-(_|-|-|--__/-->--<--|-|-|-|-|-|-|-(_|-|
//  -|_____|-|_|-|_|--\__,_|-_\___|-/_/\_\-|_|-|_|-|_|--\__,-|
//  --/-____|---------------|-|--------------------------__/-|
//  -|-(___----_---_---___--|-|_----___---_-__-___------|___/-
//  --\___-\--|-|-|-|-/-__|-|-__|--/-_-\-|-'_-`-_-\-----------
//  --____)-|-|-|_|-|-\__-\-|-|_--|--__/-|-|-|-|-|-|----------
//  -|_____/---\__,-|-|___/--\__|--\___|-|_|-|_|-|_|----------
//  ------------__/-|-----------------------------------------
//  -----------|___/------------------------------------------
//------------------------------------- Jon Walp ( ͡° ͜ʖ ͡°) 2018
//------------------------------------------------------------
//-------------------Read Me----------------------------------
//---I found it way more efficient to use the switch case-----
//---logic instead of writing if statements that ended up-----
//---being super long, but I have prior experience with them--
//---from javascript (programming key events for a game)------
//---so I researched on using them in Java so I hope this is--
//---cool w/ you.(ﾉ◕ヮ◕)ﾉ--------------------------------------
package soundex;
import java.util.*;
// input one string
// take first letter
// 1 --- b, f, p, v
// 2 --- c,g,j,k,q,s,x,z
// 3 --- d, t
// 4 --- l
// 5 --- m, n
// 6 --- r

public class IndexingSys {
	public static String indexRequest(String str) { //creating a function that takes the input and does the indexing outside of other code bc cleanliness

		char[] userIn = str.toUpperCase().toCharArray(); //taking string and making it a char array
		char firstLet = userIn[0]; //store the first character

		for (int i = 0; i < userIn.length; i++) { //running through input
			switch (userIn[i]) { //switch expression
            case 'B': //first set of cases
            case 'F':
            case 'P':
            case 'V': {
                userIn[i] = '1'; //replacing all of the found cases w/ 1
                break; //break bc done with first case
            }
            case 'C': //case 2
            case 'G':
            case 'J':
            case 'K':
            case 'Q':
            case 'S':
            case 'X':
            case 'Z': {
                userIn[i] = '2'; //replace all with 2
                break; //break after changing this case
            }
            case 'D': //case 3
            case 'T': {
                userIn[i] = '3'; //replace all with 3
                break; // break here
            }
            case 'L': { //case 4
                userIn[i] = '4'; ///replace with 4
                break; //break
            }
            case 'M': //case 5
            case 'N': {
                userIn[i] = '5'; //replace all with 5
                break; //break
            }
            case 'R': { //case 6
                userIn[i] = '6'; //replace with 6
                break; //break
            }
            default: { //default case to replace everything else with 0's
                userIn[i] = '0'; //replacing
                break; //break
            }
		} //end of switch expression
	} //end of FOR loop
		String userOut = "" + firstLet; //setting up the output
		//case for when two letters with same code num are next to each other
		for (int i = 1; i < userIn.length; i++) {
			if (userIn[i] != userIn[i - 1] && userIn[i] != '0') {
				userOut += userIn[i]; //only going to add the numbers that we need to the output
			}
		}
		userOut = userOut + "0000"; //4 zeros in cases where the input does not have any code nums
		return userOut.substring(0, 4); //returning a letter and 3 numbers
	}
	public static void main(String[] args) { //main code segment where we input things
		Scanner kb = new Scanner(System.in); //setup for scanner
		System.out.println("Enter Word To Find Its Index: ");
		String in1 = kb.next();
		System.out.println("Your input: (" + in1.toUpperCase() + ")" + " Index Returned: " + IndexingSys.indexRequest(in1));


		kb.close();
	}
}
