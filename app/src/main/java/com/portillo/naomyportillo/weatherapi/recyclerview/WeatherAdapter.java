package com.portillo.naomyportillo.weatherapi.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.portillo.naomyportillo.weatherapi.R;
import com.portillo.naomyportillo.weatherapi.WeatherModel;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherHolder> {

    List<WeatherModel> weatherModelList;

    public WeatherAdapter(List<WeatherModel> weatherModelList) {
        this.weatherModelList = weatherModelList;
    }

    @NonNull
    @Override
    public WeatherHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_layout_item, viewGroup, false);
        return new WeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherHolder weatherHolder, int pos) {
        WeatherModel weatherModel = weatherModelList.get(pos);
        WeatherHolder.onBind(weatherModel);
    }

    @Override
    public int getItemCount() {
        return weatherModelList.size();
    }
}
