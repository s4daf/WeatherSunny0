package c.weathersunny;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapterActivity extends AppCompatActivity {

    List<Datum> datumList;

    public ItemAdapterActivity(List<Datum> weatherList) {

        datumList = weatherList;
    }

    @NonNull
    @Override
    public ItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_adapter, parent, false);
        ItemAdapterViewHolder itemAdapterViewHolder = new ItemAdapterViewHolder(view);
        return itemAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterViewHolder holder, int position) {

        String date;
        String weatherIcon;
        String weatherDescription;
        Double minWeather;
        Double maxWeather;

        date = datumList.get(position).getValidDate();
        holder.txtDate.setText(date);
        weatherIcon = datumList.get(position).getWeather().getIcon();
        weatherIcon = "https://www.weatherbit.io/static/img/icons/" + weatherIcon + ".png";
        Picasso.get().load(weatherIcon).into(holder.imgWeatherIcon);
        weatherDescription = datumList.get(position).getWeather().getDescription();
        holder.txtWeatherDescription.setText(weatherDescription);
        minWeather = datumList.get(position).getMinTemp();
        holder.txtMinWeather.setText(minWeather.toString() + " °C");
        maxWeather = datumList.get(position).getMaxTemp();
        holder.txtMaxWeather.setText(maxWeather.toString() + " °C");
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ItemAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView txtCity;
        TextView txtDate;
        ImageView imgWeatherIcon;
        TextView txtWeatherDescription;
        TextView txtMinWeather;
        TextView txtMaxWeather;

        public ItemAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCity = itemView.findViewById(R.id.txtCity);
            txtDate = itemView.findViewById(R.id.txtDate);
            imgWeatherIcon = itemView.findViewById(R.id.imgWeatherIcon);
            txtWeatherDescription = itemView.findViewById(R.id.txtWeatherDescription);
            txtMinWeather = itemView.findViewById(R.id.txtMinWeather);
            txtMaxWeather = itemView.findViewById(R.id.txtMaxWeather);
        }
    }
}
