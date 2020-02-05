package sundaydavid.venten.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        View view = LayoutInflater.from(context).inflate(R.layout.filter_list, null);
        FilterViewHolder filterViewHolder = new FilterViewHolder(view);
        return filterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewHolder holder, int position) {

//        holder.startYear.setText(ventenFilters.get(position).getStartYear());
//        holder.endYear.setText(ventenFilters.get(position).getEndYear());
        holder.gender.setText(ventenFilters.get(position).getGender());

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
