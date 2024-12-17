package edu.my.ftmk.recycleview2;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.Vector;

import edu.my.ftmk.recycleview2.Adapter.StudentAdapter;
import edu.my.ftmk.recycleview2.R;
import edu.my.ftmk.recycleview2.model.Student;

public class StudentviewholderActivity extends AppCompatActivity {

    private EditText edtFullName, edtStudNum, edtEmail, edtBirthdate;
    private RadioGroup rgGender;
    private Spinner spnState;
    private FloatingActionButton fabAdd;
    private RecyclerView rcvStud;

    private Vector<Student> studentList;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentviewholder);

        // Initialize UI components
        edtFullName = findViewById(R.id.edtFullName);
        edtStudNum = findViewById(R.id.edtStudNum);
        edtEmail = findViewById(R.id.edtEmail);
        edtBirthdate = findViewById(R.id.edtBirthdate);
        rgGender = findViewById(R.id.rgGender);
        spnState = findViewById(R.id.spnState);
        fabAdd = findViewById(R.id.fabAdd);
        rcvStud = findViewById(R.id.rcvStud);

        // Setup RecyclerView
        studentList = new Vector<>();
        adapter = new StudentAdapter(studentList);
        rcvStud.setLayoutManager(new LinearLayoutManager(this));
        rcvStud.setAdapter(adapter);

        // Date Picker for Birthdate
        edtBirthdate.setOnClickListener(view -> showDatePicker());

        // FloatingActionButton click listener
        fabAdd.setOnClickListener(view -> addStudent());
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
            edtBirthdate.setText(dayOfMonth + "/" + (month1 + 1) + "/" + year1);
        }, year, month, day);
        datePickerDialog.show();
    }

    private void addStudent() {
        // Fetch input values
        String fullName = edtFullName.getText().toString().trim();
        String studentNumber = edtStudNum.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String birthdate = edtBirthdate.getText().toString().trim();
        String state = spnState.getSelectedItem().toString();

        // Get selected gender
        int selectedId = rgGender.getCheckedRadioButtonId();
        RadioButton selectedGenderButton = findViewById(selectedId);
        String gender = (selectedGenderButton != null) ? selectedGenderButton.getText().toString() : "Not Selected";

        // Input validation
        if (fullName.isEmpty() || studentNumber.isEmpty() || email.isEmpty() || birthdate.isEmpty() || gender.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Add to RecyclerView
        Student student = new Student(fullName, studentNumber, email, gender, birthdate, state);
        studentList.add(student);
        adapter.notifyItemInserted(studentList.size() - 1);

        // Clear input fields
        clearFields();
    }

    private void clearFields() {
        edtFullName.setText("");
        edtStudNum.setText("");
        edtEmail.setText("");
        edtBirthdate.setText("");
        rgGender.clearCheck();
        spnState.setSelection(0);
    }
}
