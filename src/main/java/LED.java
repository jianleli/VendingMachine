public class LED {
    private String firstLine;
    private String secondLine;

    public void update(String firstLine, String secondLine){
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        System.out.println(this);
    }

    LED(String firstLine, String secondLine){
        this.update(firstLine, secondLine);
    }

    @Override
    public String toString() {
        return "LED{" +
                "firstLine='" + firstLine + '\'' +
                ", secondLine='" + secondLine + '\'' +
                '}';
    }
}
