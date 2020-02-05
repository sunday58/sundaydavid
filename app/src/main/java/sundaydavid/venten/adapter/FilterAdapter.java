package sundaydavid.venten.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sundaydavid.venten.R;
import sundaydavid.venten.data.VentenFilter;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder> {

    Context context;
    List<VentenFilter> ventenFilters;
    List<String> countries = new ArrayList<>();



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

        holder.gender.setText(ventenFilters.get(position).getGender());
        holder.startYear.setText(String.format(String.valueOf(ventenFilters.get(position).getStartYear())));
        holder.endYear.setText(String.format(String.valueOf(ventenFilters.get(position).getEndYear())));

        holder.countries.setText(ventenFilters.get(position).getCountries().toString());
//        holder.colors.setText(ventenFilters.get(position).getColors().toString());

        ArrayList<String> colorful = new ArrayList<>();
        colorful.add(ventenFilters.get(position).getColors().toString());
        StringBuffer sb = new StringBuffer();

        for (String s : colorful){
            sb.append(s);
            sb.append(", ");

        }

        String str = sb.toString();
        holder.colors.setText(str);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, String.valueOf(ventenFilters.get(position).getId()), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ventenFilters.size();
    }

    class FilterViewHolder extends RecyclerView.ViewHolder{

        TextView startYear, endYear, gender, countries, colors;

        public FilterViewHolder(@NonNull View itemView) {
            super(itemView);

            startYear = itemView.findViewById(R.id.start_year_data);
            endYear = itemView.findViewById(R.id.end_year_data);
            gender = itemView.findViewById(R.id.gender_data);
            countries = itemView.findViewById(R.id.countries_data);
            colors = itemView.findViewById(R.id.colors_data);
        }
    }
}
