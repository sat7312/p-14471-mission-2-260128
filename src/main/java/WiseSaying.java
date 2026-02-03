public class WiseSaying {
    private String content;
    private String author;
    private int id;

    public WiseSaying(String content, String author, int id) {
        this.content = content;
        this.author = author;
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
