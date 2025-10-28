package com.example.notepad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> notes;

    public NoteAdapter(Context context, ArrayList<String> notes) {
        super(context, R.layout.note_item, notes);
        this.context = context;
        this.notes = notes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        View rowView = inflater.inflate(R.layout.note_item, parent, false);
        TextView textView = rowView.findViewById(R.id.noteText);
        textView.setText(notes.get(position));
        
        return rowView;
    }
}