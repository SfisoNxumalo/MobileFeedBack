package com.sfiso.feedbackapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Updatetab_Fragment extends androidx.fragment.app.Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceSate)
    {
        View view = inflater.inflate(R.layout.updatetab_fragment,container,false);

        Button btnUpdate = view.findViewById(R.id.btnUpdate);
        TextView txtFeedbackID = view.findViewById(R.id.UpdateFeedbackID);

        EditText txtModuleName = view.findViewById(R.id.UpdateModuleName);
        EditText txtRelevanceNumber = view.findViewById(R.id.UpdateRelevanceNumber);
        EditText lblTechnologyEnhancedNumber = view.findViewById(R.id.UpdateTechnologyEnhancedNumber);
        EditText txtLearningOutcomes = view.findViewById(R.id.UpdateLearningOutcomesNumber);
        EditText txtOpportunitiesNumber = view.findViewById(R.id.UpdateOpportunitiesNumber);
        EditText lblNeedImprove = view.findViewById(R.id.UpdateNeedImprove);
        EditText txtLecturerRespondedNumber = view.findViewById(R.id.UpdateLecturerRespondedNumber);

        btnUpdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String FeedbackID = txtFeedbackID.getText().toString();
                String ModuleName = txtModuleName.getText().toString();
                String NeedImprove = lblNeedImprove.getText().toString();

                int LearningOutcomes = Integer.parseInt(txtLearningOutcomes.getText().toString());
                int TechnologyEnhancedNumber = Integer.parseInt(lblTechnologyEnhancedNumber.getText().toString());
                int RelevanceNumber = Integer.parseInt(txtRelevanceNumber.getText().toString());
                int LecturerRespondedNumber = Integer.parseInt(txtLecturerRespondedNumber.getText().toString());
                int OpportunitiesNumber = Integer.parseInt(txtOpportunitiesNumber.getText().toString());

                StudentFeedbackTable studentFeedbackTable = new StudentFeedbackTable(getContext());
                studentFeedbackTable.openDB();
                studentFeedbackTable.updateRecord(FeedbackID, ModuleName, LearningOutcomes, OpportunitiesNumber, RelevanceNumber, LecturerRespondedNumber, TechnologyEnhancedNumber, NeedImprove);

                txtFeedbackID.setText("");
                txtModuleName.setText("");
                txtLearningOutcomes.setText("");
                txtOpportunitiesNumber.setText("");
                txtRelevanceNumber.setText("");
                txtLecturerRespondedNumber.setText("");
                lblTechnologyEnhancedNumber.setText("");
                lblNeedImprove.setText("");

                Toast.makeText(getContext(), "Submission has been updated", Toast.LENGTH_SHORT).show();
                studentFeedbackTable.closeDB();
            }
        });
        return view;
    }
}
