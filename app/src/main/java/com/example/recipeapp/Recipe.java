// src/main/java/com/example/recipeapp/Recipe.java
public class Recipe {
    private int id;
    private String title;
    private String image;
    private String ingredients;
    private String instructions;

    // Constructors, Getters, and Setters
    public Recipe(int id, String title, String image, String ingredients, String instructions) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }
}
