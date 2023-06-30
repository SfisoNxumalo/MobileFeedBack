package com.sfiso.feedbackapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Readtab_Fragment extends androidx.fragment.app.Fragment{
    Cursor cursor;
    ListView lstReadView;
    int intListViewItemPosition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceSate)
    {
        View view = inflater.inflate(R.layout.readtab_fragment,container,false);
        lstReadView = view.findViewById(R.id.lstReadView);
        updateListView();
        registerForContextMenu(lstReadView);

        lstReadView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                intListViewItemPosition=i;

                return false;
            }
        });
        registerForContextMenu(lstReadView);

        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Menu");

        menu.add("Edit");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case 0:
                cursor.moveToPosition();

                String strFeedbackID = cursor.getString(0);;
                String strModuleName = cursor.getString(1);
                String strLearningOutcomes = cursor.getString(2);
                String strOpportunitiesNumber = cursor.getString(3);
                String strRelevanceNumber = cursor.getString(4);
                String strLecturerRespondedNumber = cursor.getString(5);
                String strTechnologyEnhancedNumber = cursor.getString(6);
                String strNeedImprove = cursor.getString(7);

                TextView lblFeedbackID = getActivity().findViewById(R.id.UpdateFeedbackID);
                TextView lblLearningOutcomes = getActivity().findViewById(R.id.UpdateLearningOutcomesNumber);
                TextView lblOpportunitiesNumber = getActivity().findViewById(R.id.UpdateOpportunitiesNumber);
                TextView lblTechnologyEnhancedNumber = getActivity().findViewById(R.id.UpdateTechnologyEnhancedNumber);
                TextView lblNeedImprove = getActivity().findViewById(R.id.UpdateNeedImprove);
                TextView lblModuleName = getActivity().findViewById(R.id.UpdateModuleName);
                TextView lblLecturerRespondedNumber = getActivity().findViewById(R.id.UpdateLecturerRespondedNumber);
                TextView lblRelevanceNumber = getActivity().findViewById(R.id.UpdateRelevanceNumber);

                lblModuleName.setText(strModuleName);
                lblTechnologyEnhancedNumber.setText(strTechnologyEnhancedNumber);
                lblNeedImprove.setText(strNeedImprove);
                lblLecturerRespondedNumber.setText(strRelevanceNumber);
                lblFeedbackID.setText(strFeedbackID);
                lblLearningOutcomes.setText(strLearningOutcomes);
                lblOpportunitiesNumber.setText(strOpportunitiesNumber);
                lblRelevanceNumber.setText(strLecturerRespondedNumber);
                updateListView();

                Toast.makeText(getContext(), "Select the update tab to proceed with editing", Toast.LENGTH_LONG).show();
                return true;
            default:
                Toast.makeText(getContext(), "Incorrect Selection.", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    void updateListView()
    {
        StudentFeedbackTable studentFeedbackTable = new StudentFeedbackTable(getContext());
        studentFeedbackTable.openDB();
        cursor = studentFeedbackTable.getAllRecords();
        CustomAdapter customAdapter = new CustomAdapter();
        lstReadView.setAdapter(customAdapter);
        studentFeedbackTable.closeDB();
    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount()
        {
            return cursor.getCount();
        }

        @Override
        public Object getItem(int i)
        {
            return null;
        }

        @Override
        public long getItemId(int i)
        {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            view = getLayoutInflater().inflate(R.layout.custom_layout, null);

            TextView FeedbackID = view.findViewById(R.id.CustomFeedbackID);
            TextView RelevanceNumber = view.findViewById(R.id.CustomRelevanceNumber);
            TextView LecturerRespondedNumber = view.findViewById(R.id.CustomLecturerRespondedNumber);
            TextView ModuleName = view.findViewById(R.id.CustomModuleName);
            TextView NeedImprove = view.findViewById(R.id.CustomNeedImprove);
            TextView LearningOutcomesNumber = view.findViewById(R.id.CustomLearningOutcomesNumber);
            TextView TechnologyEnhancedNumber = view.findViewById(R.id.CustomTechnologyEnhancedNumber);
            TextView  OpportunitiesNumber = view.findViewById(R.id.CustomOpportunitiesNumber);

            cursor.moveToPosition(i);

            FeedbackID.setText(cursor.getString(0));
            ModuleName.setText(cursor.getString(1));
            LearningOutcomesNumber.setText(cursor.getString(2));
            OpportunitiesNumber.setText(cursor.getString(3));
            RelevanceNumber.setText(cursor.getString(4));
            LecturerRespondedNumber.setText(cursor.getString(5));
            TechnologyEnhancedNumber.setText(cursor.getString(6));
            NeedImprove.setText(cursor.getString(7));

            return view;
        }
    }

}
