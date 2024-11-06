package springbootpokemon.pokemonproject.review;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import springbootpokemon.pokemonproject.model.Pokemon;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private int stars;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    // No-args constructor
    public Review() {}

    // All-args constructor
    public Review(int id, String title, String content, int stars, Pokemon pokemon) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.stars = stars;
        this.pokemon = pokemon;
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

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    // Builder pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private String title;
        private String content;
        private int stars;
        private Pokemon pokemon;

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

        public Builder pokemon(Pokemon pokemon) {
            this.pokemon = pokemon;
            return this;
        }

        public Review build() {
            return new Review(id, title, content, stars, pokemon);
        }
    }
}
