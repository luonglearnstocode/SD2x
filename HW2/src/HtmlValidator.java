import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	/*
	 * Take as input a Queue of HtmlTags and return a Stack of HtmlTags that verifies the correctness of the tag structure
	 * If the HTML file is well formatted, the method should return an empty Stack. 
	 * If the HTML file is not well formatted, the method should return the Stack in its current state at the time the code determined that the tags were not balanced.
	 */
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> stack = new Stack<>();
		
		for (HtmlTag tag : tags) {
			if (tag.isOpenTag()) {
				stack.push(tag);
			} else {
				if (!tag.isSelfClosing()) { // if is closing tag
					if (stack.isEmpty()) { // closing tag with no opening tag,  everything okay until then
						return null;
					}
					
					if (tag.matches(stack.peek())) {
						stack.pop();
					} else {  // closing tag with no opening tag
						return stack;
					}
				}
			}
		}
		
		return stack; 
	}
	

}

