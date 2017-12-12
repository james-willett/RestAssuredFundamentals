public class VideoGame
{
    private String id;

    private String category;

    private String releaseDate;

    private String name;

    private String rating;

    private String reviewScore;

    public VideoGame(String id, String category, String releaseDate, String name, String rating, String reviewScore) {
        this.id = id;
        this.category = category;
        this.releaseDate = releaseDate;
        this.name = name;
        this.rating = rating;
        this.reviewScore = reviewScore;
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

    public String getReviewScore ()
    {
        return reviewScore;
    }

    public void setReviewScore (String reviewScore)
    {
        this.reviewScore = reviewScore;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", category = "+category+", releaseDate = "+releaseDate+", name = "+name+", rating = "+rating+", reviewScore = "+reviewScore+"]";
    }
}