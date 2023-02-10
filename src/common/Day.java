package common;

public abstract class Day {
    protected Day() {}

    public abstract Object[] getSolutions(String fileAsText);

    public void PrintParts(String fileAsText){
        Object[] parts = getSolutions(fileAsText);
        for (int i = 0; i < parts.length; i++) {
            System.out.println("Part " + (i+1) + ": " + parts[i]);
        }
        System.out.println();
    }
}
