public class Article implements IAggregable<Article, String>, IDeeplyCloneable<Article> {

    private String title;
    private String text;

    Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    String getTitle() {
        return title;
    }

    String getText() {
        return text;
    }

    @Override
    public String aggregate(String iResult) {
        return iResult == null ? title + "\n" + text : iResult + "\n" + title + "\n" + text;
    }

    @Override
    public Article deepClone() {
        return new Article(title, text);
    }
}
