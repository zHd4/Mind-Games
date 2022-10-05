package hexlet.code;

public final class GameData {
    private String gameTask;

    private String[][] questionsArgs;

    private String[] correctAnswers;

    public String getGameTask() {
        return gameTask;
    }

    public String[][] getQuestionsArgs() {
        return questionsArgs;
    }

    public String[] getCorrectAnswers() {
        return correctAnswers;
    }

    public void setGameTask(String task) {
        this.gameTask = task;
    }

    public void setQuestionsArgs(String[][] args) {
        this.questionsArgs = args;
    }

    public void setCorrectAnswers(String[] answers) {
        this.correctAnswers = answers;
    }
}
