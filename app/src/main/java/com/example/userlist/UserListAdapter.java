package com.example.userlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.viewpager.widget.ViewPager;

public class UserListAdapter extends BaseAdapter {
    private ArrayList<List> UList;
    private Context context;

    public UserListAdapter(ArrayList<List> uList, UsersFragment usersFragment) {
    }

    public void CustomAdapter(ArrayList<List> list, Context cont){
        this.UList = list;
        this.context = cont;
    }

    @Override
    public int getCount() {
        return this.UList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.UList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView == null){
            LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.activity_userrow, null);

            holder = new ViewHolder();
            holder.fname = (TextView) convertView.findViewById(R.id.Fname);
            holder.lname = (TextView)convertView.findViewById(R.id.Lname);
            holder.age = (TextView)convertView.findViewById(R.id.age);
            holder.gender = (TextView)convertView.findViewById(R.id.gender);
            holder.town = (TextView)convertView.findViewById(R.id.town);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        List stu = UList.get(position);
        holder.id.setText(stu.getID());
        holder.fname.setText(stu.getFname());
        holder.lname.setText(stu.getLname());
        holder.age.setText(stu.getAge());
        holder.town.setText(stu.getHometown());
        holder.gender.setText(stu.getGender());

        return convertView;
    }

    private static class ViewHolder{
        public TextView id;
        public TextView fname;
        public TextView lname;
        public TextView age;
        public TextView gender;
        public TextView town;
    }
}

