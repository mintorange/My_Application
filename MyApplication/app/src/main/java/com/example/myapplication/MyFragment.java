package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
/**
 * Created by Administrator on 2018/4/24.
 */
public class MyFragment extends Fragment{
    View view;

    ListView listView;
    private String data[]={"清晨","海洋","丛林","雨夜","庭院","高山","教堂","篝火","旷野","湖泊","宇宙","闹市","乡野","咖啡馆","图书馆"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment, null);
        listView=(ListView)view.findViewById(R.id.listView);
        return  view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),R.layout.simple_adapter_item, R.id.text1,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),data[i],Toast.LENGTH_SHORT).show();
            }
        });

    }

}