package eggroll.jaggedarraycombinationalgorithm;

import java.util.ArrayList;

public class Main {
	public static void main( String[ ] args ) {
		String[ ][ ] testArray = { { "oranges", "bananas", "apples" }, { "test" }, { "shirt", "pants", "woods" } };
		ArrayList< String[ ] > output = JaggedArrayCombinationAlgorithm.processCombinations( testArray );

		for ( String[ ] col : output ) { // Print the outputs for testing.
			for ( String str : col ) {
				System.out.print( str + " " );
			}

			System.out.println( );
		}
	}
}
