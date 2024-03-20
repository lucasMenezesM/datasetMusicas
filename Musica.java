public class Musica {
    private String artist;
    private String title;
    private String year;
    private String sales;
    private String rating;
    private String streams;

    public Musica(String artist, String title, String year, String sales, String rating, String streams) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.sales = sales;
        this.rating = rating;
        this.streams = streams;
    }

    public String getArtist() {
        return artist;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getYear() {
        return year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public String getSales() {
        return sales;
    }
    
    public void setSales(String sales) {
        this.sales = sales;
    }
    
    public String getRating() {
        return rating;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public String getStreams() {
        return streams;
    }
    
    public void setStreams(String streams) {
        this.streams = streams;
    }
}
