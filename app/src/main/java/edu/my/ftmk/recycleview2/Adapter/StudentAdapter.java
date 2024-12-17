package edu.my.ftmk.recycleview2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

import edu.my.ftmk.recycleview2.R;
import edu.my.ftmk.recycleview2.model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private final Vector<Student> students;

    public StudentAdapter(Vector<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate a simple layout for RecyclerView items
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Format the student data into a single string for display
        Student student = students.get(position);
        String displayText = "Name: " + student.getStrFullname() + "\n"
                + "Student No: " + student.getStrStudNo() + "\n"
                + "Email: " + student.getStrEmail() + "\n"
                + "Birthdate: " + student.getStrBirthdate() + "\n"
                + "Gender: " + student.getStrGender() + "\n"
                + "State: " + student.getStrState();

        holder.textView.setText(displayText);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
