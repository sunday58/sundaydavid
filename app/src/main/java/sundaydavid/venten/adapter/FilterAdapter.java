package sundaydavid.venten.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sundaydavid.venten.CarOwnersActivity;
import sundaydavid.venten.R;
import sundaydavid.venten.data.VentenFilter;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder> {

    Context context;
    List<VentenFilter> ventenFilters;

    public FilterAdapter(Context context, List<VentenFilter> ventenFilters){
        this.ventenFilters = ventenFilters;
        this.context = context;
    }

    @NonNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       View view = layoutInflater.inflate(R.layout.filter_list, parent, false);
       return new FilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewHolder holder, final int position) {

        if (ventenFilters.get(position).getGender().isEmpty() && ventenFilters.get(position)
                .getCountries().isEmpty() && ventenFilters.get(position).getColors().isEmpty()){

            holder.gender.setVisibility(View.GONE);
            holder.genderData.setVisibility(View.GONE);
            holder.countries.setVisibility(View.GONE);
            holder.countriesData.setVisibility(View.GONE);
            holder.colors.setVisibility(View.GONE);
            holder.colorsData.setVisibility(View.GONE);

            holder.startYear.setText(String.format(String.valueOf(ventenFilters.get(position).getStartYear())));
            holder.endYear.setText(String.format(String.valueOf(ventenFilters.get(position).getEndYear())));

        }else if (ventenFilters.get(position).getGender().isEmpty() &&
                ventenFilters.get(position).getColors().isEmpty()){

            holder.gender.setVisibility(View.GONE);
            holder.genderData.setVisibility(View.GONE);
            holder.colors.setVisibility(View.GONE);
            holder.colorsData.setVisibility(View.GONE);

            holder.startYear.setText(String.format(String.valueOf(ventenFilters.get(position).getStartYear())));
            holder.endYear.setText(String.format(String.valueOf(ventenFilters.get(position).getEndYear())));


            ArrayList<String> arrayListCountry = new ArrayList<>();
            arrayListCountry.add(ventenFilters.get(position).getCountries().toString());
            StringBuilder builderCountry = new StringBuilder();

            for (String valueCountry : arrayListCountry) {
                builderCountry.append(valueCountry);

            }
            String formattedStringCountry = builderCountry.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .trim();
            holder.countries.setText(formattedStringCountry);

        } else if (ventenFilters.get(position).getGender().isEmpty()){
            holder.gender.setVisibility(View.GONE);
            holder.genderData.setVisibility(View.GONE);

            holder.startYear.setText(String.format(String.valueOf(ventenFilters.get(position).getStartYear())));
            holder.endYear.setText(String.format(String.valueOf(ventenFilters.get(position).getEndYear())));


            ArrayList<String> arrayListCountry = new ArrayList<>();
            arrayListCountry.add(ventenFilters.get(position).getCountries().toString());
            StringBuilder builderCountry = new StringBuilder();

            for (String valueCountry : arrayListCountry) {
                builderCountry.append(valueCountry);

            }
            String formattedStringCountry = builderCountry.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .trim();
            holder.countries.setText(formattedStringCountry);


            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(ventenFilters.get(position).getColors().toString());
            StringBuilder builder = new StringBuilder();

            for (String value : arrayList) {
                builder.append(value);


            }
            String formattedString = builder.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .trim();
            holder.colors.setText(formattedString);

        }else if (ventenFilters.get(position).getCountries().isEmpty()){
            holder.countries.setVisibility(View.GONE);
            holder.countriesData.setVisibility(View.GONE);

            holder.gender.setText(ventenFilters.get(position).getGender());
            holder.startYear.setText(String.format(String.valueOf(ventenFilters.get(position).getStartYear())));
            holder.endYear.setText(String.format(String.valueOf(ventenFilters.get(position).getEndYear())));


            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(ventenFilters.get(position).getColors().toString());
            StringBuilder builder = new StringBuilder();

            for (String value : arrayList) {
                builder.append(value);


            }
            String formattedString = builder.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .trim();
            holder.colors.setText(formattedString);
        }else if (ventenFilters.get(position).getColors().isEmpty()){
            holder.colors.setVisibility(View.GONE);
            holder.colorsData.setVisibility(View.GONE);

            holder.gender.setText(ventenFilters.get(position).getGender());
            holder.startYear.setText(String.format(String.valueOf(ventenFilters.get(position).getStartYear())));
            holder.endYear.setText(String.format(String.valueOf(ventenFilters.get(position).getEndYear())));


            ArrayList<String> arrayListCountry = new ArrayList<>();
            arrayListCountry.add(ventenFilters.get(position).getCountries().toString());
            StringBuilder builderCountry = new StringBuilder();

            for (String valueCountry : arrayListCountry) {
                builderCountry.append(valueCountry);

            }
            String formattedStringCountry = builderCountry.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .trim();
            holder.countries.setText(formattedStringCountry);

        }

        else {
            holder.gender.setText(ventenFilters.get(position).getGender());
            holder.startYear.setText(String.format(String.valueOf(ventenFilters.get(position).getStartYear())));
            holder.endYear.setText(String.format(String.valueOf(ventenFilters.get(position).getEndYear())));


            ArrayList<String> arrayListCountry = new ArrayList<>();
            arrayListCountry.add(ventenFilters.get(position).getCountries().toString());
            StringBuilder builderCountry = new StringBuilder();

            for (String valueCountry : arrayListCountry) {
                builderCountry.append(valueCountry);

            }
            String formattedStringCountry = builderCountry.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .trim();
            holder.countries.setText(formattedStringCountry);


            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(ventenFilters.get(position).getColors().toString());
            StringBuilder builder = new StringBuilder();

            for (String value : arrayList) {
                builder.append(value);


            }
            String formattedString = builder.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .trim();
            holder.colors.setText(formattedString);
        }

    }

    @Override
    public int getItemCount() {
        return ventenFilters.size();
    }

    class FilterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView startYear, endYear, gender, countries, colors;
        TextView genderData, countriesData, colorsData;

        public FilterViewHolder(@NonNull View itemView) {
            super(itemView);

            startYear = itemView.findViewById(R.id.start_year_data);
            endYear = itemView.findViewById(R.id.end_year_data);
            gender = itemView.findViewById(R.id.gender_data);
            countries = itemView.findViewById(R.id.countries_data);
            colors = itemView.findViewById(R.id.colors_data);

            //non data
            genderData = itemView.findViewById(R.id.car_gender);
            countriesData = itemView.findViewById(R.id.countries);
            colorsData = itemView.findViewById(R.id.colors);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            VentenFilter ventenFilter = ventenFilters.get(position);
            Intent intent = new Intent(v.getContext(), CarOwnersActivity.class);
            intent.putExtra("filters", ventenFilter);
            v.getContext().startActivity(intent);
        }
    }
}
