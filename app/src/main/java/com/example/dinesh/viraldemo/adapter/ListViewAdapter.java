package com.example.dinesh.viraldemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dinesh.viraldemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dinesh on 1/25/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private ArrayList<String> listResult;
    private Context mContext;

    public ListViewAdapter(Context context, ArrayList<String> listResult) {
        this.mContext = context;
        this.listResult = listResult;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return listResult.size();
         // return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
//convertView is the old View, everytime calls getView, goes to convertView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //each time we scrolled listview, items will be refreshed
        //causes getView method to be called again and again
 //       TextView view = new TextView(mContext);

   //     view.setText(String.valueOf(position));
     //   return view;

        ViewHolder holder;
        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.textView1 = (TextView)convertView.findViewById(R.id.list_view_tv1);
            holder.textView2 = (TextView)convertView.findViewById(R.id.list_view_tv2);
            holder.textView3 = (TextView)convertView.findViewById(R.id.list_view_tv3);
            //text view has textview inside so we can directly use holder
            convertView.setTag(holder); //setTag- set holder inside  getTag- take it out
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(String.valueOf(position));  //if message is sent from outside, icon is on left side
        holder.textView3.setText(String.valueOf(position)); //else righrt side
        holder.textView2.setText(listResult.get(position));
        if(position % 2 == 0 ){
            holder.textView1.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.INVISIBLE);
        }else{
            holder.textView1.setVisibility(View.INVISIBLE);
            holder.textView3.setVisibility(View.VISIBLE);
        }


      /*  View rowView = mInflater.inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView)rowView.findViewById(R.id.list_view_tv);
        textView.setText(String.valueOf(position));*/
        /*textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        return convertView;
    }
}
class ViewHolder{
    TextView textView1;
    TextView textView2;
    TextView textView3;
}
