import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import kotlinx.coroutines.scheduling.Task;

public class AddTaskActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextCategory;
    private EditText editTextDueDate;
    private Button buttonSave;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextCategory = findViewById(R.id.editTextCategory);
        editTextDueDate = findViewById(R.id.editTextDueDate);
        buttonSave = findViewById(R.id.buttonSave);

        databaseHelper = new DatabaseHelper(this);

        buttonSave.setOnClickListener(v -> {
            String title = editTextTitle.getText().toString();
            String category = editTextCategory.getText().toString();
            String dueDate = editTextDueDate.getText().toString();

            Task task = new Task();
            task.setTitle(title);
            task.setCategory(category);
            task.setDueDate(dueDate);

            databaseHelper.insertTask(task);
            finish();
        });
    }
}
