public class StudentRecord {
    private String usesAi;
    private int before;
    private int after;

    public StudentRecord(String usesAi, int before, int after) {
        this.usesAi = usesAi;
        this.before = before;
        this.after = after;
    }

    public String getUsesAi() {
        return usesAi;
    }

    public int getBefore() {
        return before;
    }

    public int getAfter() {
        return after;
    }
}
