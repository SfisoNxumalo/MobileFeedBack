package com.sfiso.feedbackapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Createtab_Fragment extends androidx.fragment.app.Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceSate)
    {
        View view = inflater.inflate(R.layout.createtab_fragment,container,false);

        Button btnSubmit = view.findViewById(R.id.btnSubmit);

        EditText txtModuleName = view.findViewById(R.id.txtModuleName);
        EditText txtLearningOutcomes = view.findViewById(R.id.txtLearningNumber);
        EditText txtTechnologyEnhancedNumber = view.findViewById(R.id.txtTechnologyEnhancedNumber);
        EditText txtRelevanceNumber = view.findViewById(R.id.txtRelevanceNumber);
        EditText txtLecturerRespondedNumber = view.findViewById(R.id.txtLecturerRespondedNumber);
        EditText txtNeedImprove = view.findViewById(R.id.txtNeedImprove);
        EditText txtOpportunitiesNumber = view.findViewById(R.id.txtOpportunitiesNumber);

        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String NeedImprove = txtNeedImprove.getText().toString();
                String ModuleName = txtModuleName.getText().toString();

                int LearningOutcomesScores = Integer.parseInt(txtLearningOutcomes.getText().toString());
                int TechnologyEnhanced = Integer.parseInt(txtTechnologyEnhancedNumber.getText().toString());
                int Relevance = Integer.parseInt(txtRelevanceNumber.getText().toString());
                int LecturerResponded = Integer.parseInt(txtLecturerRespondedNumber.getText().toString());
                int Opportunities = Integer.parseInt(txtOpportunitiesNumber.getText().toString());

                StudentFeedbackTable studentFeedbackTable = new StudentFeedbackTable(getContext());
                studentFeedbackTable.openDB();
                studentFeedbackTable.insertRecord(ModuleName, LearningOutcomesScores, Opportunities, Relevance, LecturerResponded, TechnologyEnhanced, NeedImprove);
                Toast.makeText(getContext(), "successfully submitted.", Toast.LENGTH_SHORT).show();

                txtTechnologyEnhancedNumber.setText("");
                txtModuleName.setText("");
                txtRelevanceNumber.setText("");
                txtNeedImprove.setText("");
                txtLecturerRespondedNumber.setText("");
                txtLearningOutcomes.setText("");
                txtOpportunitiesNumber.setText("");

                studentFeedbackTable.closeDB();
            }
        });

        return view;
    }
}
