package com.example.peter.findr_practice_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.peter.findr_practice_app.logics.AdminLogic;
import com.example.peter.findr_practice_app.models.Admin;

import java.util.List;

/**
 * Created by peter on 12/4/17.
 */

public class AdminListView extends BaseAdapter {
    private Context context;
    private List<Admin> adminList = getAdminList();

    public AdminListView(Context context) {
        this.context = context;
    }

    private List<Admin> getAdminList() {
        AdminLogic logic = new AdminLogic();
        return logic.getAdminList();
    }

    @Override
    public int getCount() {
        return adminList.size();
    }

    @Override
    public Object getItem(int i) {
        return adminList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_admin, viewGroup, false);
        }
        Admin currentItem = (Admin) getItem(i);
        ((TextView) view.findViewById(R.id.tv_name)).setText(currentItem.getFullname());
        ((TextView) view.findViewById(R.id.tv_email)).setText(currentItem.getEmail());

        return view;
    }
}
