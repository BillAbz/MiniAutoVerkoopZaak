package classicalmusic;

import java.util.Arrays;
import java.util.stream.Stream;

public class LambdaStream {
    public static void main(String[] args) {

        String[] classicalMusicArray = new String[]{
                "Mozart - Serenade No. 13 for strings in G Major",
                "Beethoven - Für Elise",
                "Puccini - O mio babbino caro",
                "J.S. Bach - Toccata and Fugue in D Minor",
                "Beethoven - Symphony No.5 in C minor"
        };

        Stream<String> classicalMusicStream = Arrays.stream(classicalMusicArray); // Opdracht 1.

        Stream<String[]> classicalComposerAndIndex = classicalMusicStream.map( music -> {
           String [] composerAndIndex = music.indexOf();
        }








//        String [][] classical2DArray = new String [classicalMusicArray.length][2];
//
//        for (int musicIndex = 0; musicIndex < classicalMusicArray.length; musicIndex++) { // Loop to print
//            String[] composerMusic = classicalMusicArray[musicIndex].;
//            classical2DArray[musicIndex] = composerMusic;
//
//        System.out.println(Arrays.deepToString(classical2DArray));
    }
}
