package com.example.userlist;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

public class UsersFragment extends Fragment {
    private ListView myListview;
    DatabaseHelper dbhelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_users, container, false);
        myListview =(ListView) rootview.findViewById(R.id.list1);
        dbhelper = new DatabaseHelper(getActivity());
        fillList();
        return rootview;
    }
    public void fillList() {
        ArrayList<List> UList = dbhelper.getData();
        UserListAdapter myAdapter = new UserListAdapter(UList, this);
        myListview.setAdapter(myAdapter);
    }
}
