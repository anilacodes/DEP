// src/main/java/com/example/recipeapp/RecipeDao.java
@Dao
public interface RecipeDao {
    @Insert
    void insert(Recipe recipe);

    @Delete
    void delete(Recipe recipe);

    @Query("SELECT * FROM recipe_table")
    LiveData<List<Recipe>> getAllFavorites();
}
