package days;

public abstract class Day {
    protected final int day;

    protected Day(int day) {
        this.day = day;
    }

    public abstract Object[] getSolutions(String fileAsText);

    public void PrintParts(String fileAsText){
        Object[] parts = getSolutions(fileAsText);
        for (int i = 0; i < parts.length; i++) {
            System.out.println("Part " + (i+1) + ": " + parts[i]);
        }
        System.out.println();
    }
}
