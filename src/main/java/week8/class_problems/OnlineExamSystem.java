package session8.practice.p3;

abstract class Question {
    protected int points;

    public Question(int points) {
        this.points = points;
    }

    public abstract int evaluate(String studentAnswer);
}

class MultipleChoiceQuestion extends Question {
    private String correctAnswer;

    public MultipleChoiceQuestion(int points, String correctAnswer) {
        super(points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int evaluate(String studentAnswer) {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(int points, boolean correctAnswer) {
        super(points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int evaluate(String studentAnswer) {
        return Boolean.parseBoolean(studentAnswer) == correctAnswer ? points : 0;
    }
}