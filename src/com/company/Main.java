
package com.company;

import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Main {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("java.txt");
            Scanner scan = new Scanner(file);
            Integer count_alphabet = scan.nextInt();

            Integer count_states = scan.nextInt();

            Integer begin_state = scan.nextInt();

            Integer count_final_states = scan.nextInt();

            ArrayList<Integer> final_states = new ArrayList<Integer>();

            Map< Pair<Integer, Character>, Integer> moves = new HashMap<Pair<Integer, Character>, Integer>();
            for (int i = 0; i < count_final_states; i++) {
                Integer temp = scan.nextInt();
                final_states.add(temp);
            }
            while (scan.hasNext()) {
                Integer prev_state = scan.nextInt();
                Character letter = scan.next().trim().charAt(0);
                Integer next_state = scan.nextInt();
                Pair<Integer, Character> pair = new Pair<Integer, Character>(prev_state, letter);
                moves.put(pair, next_state);
            }

            // Check if letter is accepted by automat
            String all_letters = "abcdefghijklmnopqrstuvwxyz";

            for (int i = 0; i < count_states; i++) {
                Character ch = all_letters.charAt(i);
                Pair<Integer, Character> temp = new Pair<Integer, Character>(begin_state, ch);
                Integer next_state = moves.getOrDefault(temp, 0);
                if (!(final_states.contains(next_state))) {
                    System.out.print("Do not accept: ");
                    System.out.print(all_letters.charAt(i));
                    System.out.print("\n");
                }
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("No such file");
        }
    }
}
