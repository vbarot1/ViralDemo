package com.example.dinesh.viraldemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dinesh.viraldemo.R;

import java.util.List;

/**
 * Created by Dinesh on 1/25/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private Context mContext;

    public ListViewAdapter(Context context) {
        this.mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
 //       TextView view = new TextView(mContext);

   //     view.setText(String.valueOf(position));
     //   return view;
        View rowView = mInflater.inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView)rowView.findViewById(R.id.list_view_tv);
        textView.setText(String.valueOf(position));
        return rowView;
    }
}
