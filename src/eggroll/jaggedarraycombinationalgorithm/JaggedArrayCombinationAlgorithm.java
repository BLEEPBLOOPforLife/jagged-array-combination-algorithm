package eggroll.jaggedarraycombinationalgorithm;

import java.util.ArrayList;

public class JaggedArrayCombinationAlgorithm {
	// Divides a number by numbers in an array. Modulo the last number in the array.
	private static int divideThenModulo( int num, int[ ] divideBy ) {
		int output = num;

		for ( int i = 0; i < divideBy.length; i++ ) {
			if ( i == divideBy.length - 1 ) { // Last iteration, so we must modulo it.
				output %= divideBy[ i ];
			} else { // Divide.
				output /= divideBy[ i ];
			}
		}

		return output;
	}

	// Generates an arraylist of string arrays containing all possible combinations of strings in a jagged array.
	public static ArrayList< String[ ] > processCombinations( String[ ][ ] array ) {
		ArrayList< String[ ] > output = new ArrayList< String[ ] >( );
		int[ ] arrayLengths = new int[ array.length ]; // Holds the lengths of the jagged arrays.

		for ( int i = 0; i < array.length; i++ ) { // Populate array lengths.
			int length = array[ i ].length;

			if ( length == 0 ) {
				throw new IllegalArgumentException( "All arrays provided must have a non-zero length." );
			}

			arrayLengths[ i ] = length;
		}

		int totalNumberOfCombinations = 1; // Initialize as 1 to allow for multiplication.

		for ( int length : arrayLengths ) { // Multiply on the lengths to get the total number of combinations.
			totalNumberOfCombinations *= length;
		}

		for ( int currentComboIndex = 1; currentComboIndex <= totalNumberOfCombinations; currentComboIndex++ ) { // One iteration per combination.
			int[ ] currentCombination = new int[ array.length ]; // Holds the current combination.

			for ( int digitIndex = 0; digitIndex < array.length; digitIndex++ ) { // One iteration per digit.
				int[ ] arrayLengthsForDigit = new int[ array.length - digitIndex ]; // Holds the array lengths to be processed by divideThenModulo.

				for ( int i = 0; i < arrayLengthsForDigit.length; i++ ) { // Calculate array for divideThenModulo.
					arrayLengthsForDigit[ i ] = arrayLengths[ array.length - 1 - i ];
				}

				currentCombination[ digitIndex ] = divideThenModulo( currentComboIndex, arrayLengthsForDigit ); // Calculate current combination using divideThenModulo.
			}

			String[ ] currentStringCombination = new String[ array.length ];

			for ( int i = 0; i < currentCombination.length; i++ ) { // Turn the integer combination array into the matching strings.
				currentStringCombination[ i ] = array[ i ][ currentCombination[ i ] ];
			}

			output.add( currentStringCombination );
		}

		return output;
	}
}
