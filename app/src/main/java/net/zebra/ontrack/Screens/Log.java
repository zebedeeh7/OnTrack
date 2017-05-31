package net.zebra.ontrack.Screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.zebra.ontrack.R;
import net.zebra.ontrack.tools.RecordedTime;
import net.zebra.ontrack.tools.Time;

import java.util.ArrayList;

public class Log extends Fragment{
    private ListView lv;
    private final ArrayList<Time> timeArrayList = new ArrayList<Time>();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.log, container, false);

        for (int i = 0; i < RecordedTime.getTimeArrayListLength(); i++){
            timeArrayList.add(RecordedTime.getTimeAtIndex(i));
        }

        String[] listItems = new String[timeArrayList.size()];
        lv = (ListView)v.findViewById(R.id.log_list_view);
        if (timeArrayList.size() > 0) {
            for (int i = 0; i < timeArrayList.size(); i++){
                Time t = timeArrayList.get(i);
                listItems[i] = t.toString();
            }
            ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listItems);
            lv.setAdapter(adapter);
        }
        return v;
    }
}
