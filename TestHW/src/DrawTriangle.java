/**
 * 
 * @author HW
 * @version 1.0
 * draw triangle in ascending sequence
 *
 */
public class DrawTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 5;
		for(int i = size-1; i>=0; i--)
		{
			for(int j = size-i-1; j>=0; j--)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
		System.exit(0);

	}

}
