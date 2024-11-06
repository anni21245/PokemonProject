package springbootpokemon.pokemonproject.dto;



public class ReviewDto {
    private int id;
    private String title;
    private String content;
    private int stars;

    // No-args constructor
    public ReviewDto() {
    }

    // All-args constructor
    public ReviewDto(int id, String title, String content, int stars) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.stars = stars;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    // Builder Pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private String title;
        private String content;
        private int stars;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder stars(int stars) {
            this.stars = stars;
            return this;
        }

        public ReviewDto build() {
            return new ReviewDto(id, title, content, stars);
        }
    }
}

