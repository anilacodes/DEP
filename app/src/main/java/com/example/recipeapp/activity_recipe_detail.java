// src/main/java/com/example/recipeapp/RecipeDetailActivity.java
public class RecipeDetailActivity extends AppCompatActivity {
    private TextView title, ingredients, instructions;
    private ImageView recipeImage;
    private FloatingActionButton fabFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        title = findViewById(R.id.recipeTitle);
        ingredients = findViewById(R.id.recipeIngredients);
        instructions = findViewById(R.id.recipeInstructions);
        recipeImage = findViewById(R.id.recipeImage);
        fabFavorite = findViewById(R.id.fabFavorite);

        // Get recipe data from Intent
        // Set data to views
        // Handle favorite button click
    }
}
