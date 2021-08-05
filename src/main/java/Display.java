public class Display {
    private String firstLine;
    private String secondLine;

    public Display(String firstLine, String secondLine) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
    }

    @Override
    public String toString() {
        return "Display{" +
                "firstLine='" + firstLine + '\'' +
                ", secondLine='" + secondLine + '\'' +
                '}';
    }
}
