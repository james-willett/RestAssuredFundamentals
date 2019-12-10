public class VideoGame
{
    private String reviewScore;

    private String releaseDate;

    private String name;

    private String rating;

    private String id;

    private String category;

    public VideoGame() {

    }

    public VideoGame(String reviewScore, String releaseDate, String name, String rating, String id, String category) {
        this.reviewScore = reviewScore;
        this.releaseDate = releaseDate;
        this.name = name;
        this.rating = rating;
        this.id = id;
        this.category = category;
    }


    public String getReviewScore ()
    {
        return reviewScore;
    }

    public void setReviewScore (String reviewScore)
    {
        this.reviewScore = reviewScore;
    }

    public String getReleaseDate ()
    {
        return releaseDate;
    }

    public void setReleaseDate (String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [reviewScore = "+reviewScore+", releaseDate = "+releaseDate+", name = "+name+", rating = "+rating+", id = "+id+", category = "+category+"]";
    }
}