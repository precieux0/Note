package com.example.notepad;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button saveButton;
    private ListView listView;
    private ArrayList<String> notes;
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        saveButton = findViewById(R.id.saveButton);
        listView = findViewById(R.id.listView);
        
        notes = new ArrayList<>();
        adapter = new NoteAdapter(this, notes);
        listView.setAdapter(adapter);

        saveButton.setOnClickListener(v -> {
            String note = editText.getText().toString();
            if (!note.isEmpty()) {
                notes.add(note);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
    }
}