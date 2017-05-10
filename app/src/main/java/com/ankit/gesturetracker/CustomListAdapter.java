package com.ankit.gesturetracker;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class CustomListAdapter extends BaseAdapter {
    private List<Event> mEventList;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context context, List<Event> mEventList) {
        this.mContext = context;
        this.mEventList = mEventList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mEventList.size();
    }

    @Override
    public Object getItem(int i) {
        return mEventList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.item_event_card, viewGroup, false);
        }
        TextView activityName = (TextView) v.findViewById(R.id.activity_name);
        TextView action = (TextView) v.findViewById(R.id.action);
        TextView viewId = (TextView) v.findViewById(R.id.view_id);
        TextView x = (TextView) v.findViewById(R.id.x_cordinate);
        TextView y = (TextView) v.findViewById(R.id.y_cordinate);
        TextView pressure = (TextView) v.findViewById(R.id.pressure);
        TextView time = (TextView) v.findViewById(R.id.event_time);

        activityName.setText("Activity: " + mEventList.get(i).activityName);
        action.setText("Action: " + mEventList.get(i).action);
        String id = "";
        try {
            View targetView = mEventList.get(i).targetView;
            if (targetView != null)
                id = targetView.getResources().getResourceEntryName((targetView.getId()));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        viewId.setText("View Id: " + id);
        x.setText("X-Coord: " + mEventList.get(i).x + "");
        y.setText("Y-Coord: " + mEventList.get(i).y + "");
        pressure.setText("Pressure: " + mEventList.get(i).pressure + "");
        time.setText("Time: " + mEventList.get(i).time + "");

        return v;
    }

}
