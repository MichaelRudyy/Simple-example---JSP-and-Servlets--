package questions;

import java.util.ArrayList;
import java.util.Random;


public class QuestionAndAnswerArrayList {

    static Random random = new Random();

    public static ArrayList<Cell> getQuestionAndAnswerArrayList(int amountOfQuestions) {
        ArrayList<Cell> cellArrayList = new ArrayList<Cell>();

        for (int i = 0; i < amountOfQuestions; i++) {
            cellArrayList.add(getGeneratedCell());
        }

        return cellArrayList;
    }

    static Cell getGeneratedCell() {
        int atr1, atr2, answer;
        String question;

        atr1 = random.nextInt(10);
        atr2 = random.nextInt(10);

        if (random.nextBoolean()) {
            question = atr1 + "+" + atr2;
            answer = atr1 + atr2;
        } else {
            question = atr1 + "-" + atr2;
            answer = atr1 - atr2;
        }

        return new Cell(question, "" + answer);
    }

    public static class Cell {
        private String question;
        private String answer;

        Cell(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() {
            return this.question;
        }

        public String getAnswer() {
            return answer;
        }
    }
}
