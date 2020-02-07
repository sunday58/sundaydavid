package sundaydavid.venten.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sundaydavid.venten.R;
import sundaydavid.venten.data.CarOwnersList;

public class CarDetailsAdapter extends RecyclerView.Adapter<CarDetailsAdapter.ViewHolder> {

    private List<CarOwnersList> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
   public CarDetailsAdapter(Context context, List<CarOwnersList> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_items, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

       if (mData.get(position).getGender() == null && mData.get(position).getCountry() == null
                && mData.get(position).getCar_color() == null){

            holder.gender.setVisibility(View.GONE);
            holder.genderData.setVisibility(View.GONE);
            holder.country.setVisibility(View.GONE);
            holder.countryData.setVisibility(View.GONE);
            holder.carColor.setVisibility(View.GONE);
            holder.colorData.setVisibility(View.GONE);


            holder.firstName.setText(mData.get(position).getFirst_name());
            holder.lastName.setText(mData.get(position).getLast_name());
            holder.email.setText(mData.get(position).getEmail());
            holder.carModel.setText(mData.get(position).getCar_model());
            holder.jobTitle.setText(mData.get(position).getJob_title());
            holder.bio.setText(mData.get(position).getBio());

            holder.carModelYear.setText(mData.get(position).getCar_model_year());
        }else if (mData.get(position).getGender() == null && mData.get(position).getCar_color()==null){

            holder.gender.setVisibility(View.GONE);
            holder.genderData.setVisibility(View.GONE);
            holder.carColor.setVisibility(View.GONE);
            holder.colorData.setVisibility(View.GONE);


            holder.firstName.setText(mData.get(position).getFirst_name());
            holder.lastName.setText(mData.get(position).getLast_name());
            holder.email.setText(mData.get(position).getEmail());
            holder.country.setText(mData.get(position).getCountry());
            holder.carModel.setText(mData.get(position).getCar_model());
            holder.jobTitle.setText(mData.get(position).getJob_title());
            holder.bio.setText(mData.get(position).getBio());

            holder.carModelYear.setText(mData.get(position).getCar_model_year());
        } else if (mData.get(position).getGender() == null){
           holder.gender.setVisibility(View.GONE);
           holder.genderData.setVisibility(View.GONE);

           holder.firstName.setText(mData.get(position).getFirst_name());
           holder.lastName.setText(mData.get(position).getLast_name());
           holder.email.setText(mData.get(position).getEmail());
           holder.country.setText(mData.get(position).getCountry());
           holder.carModel.setText(mData.get(position).getCar_model());
           holder.carColor.setText(mData.get(position).getCar_color());
           holder.jobTitle.setText(mData.get(position).getJob_title());
           holder.bio.setText(mData.get(position).getBio());

           holder.carModelYear.setText(mData.get(position).getCar_model_year());
       }else if (mData.get(position).getCountry() == null){

           holder.country.setVisibility(View.GONE);
           holder.countryData.setVisibility(View.GONE);

           holder.firstName.setText(mData.get(position).getFirst_name());
           holder.lastName.setText(mData.get(position).getLast_name());
           holder.email.setText(mData.get(position).getEmail());
           holder.carModel.setText(mData.get(position).getCar_model());
           holder.carColor.setText(mData.get(position).getCar_color());
           holder.gender.setText(mData.get(position).getGender());
           holder.jobTitle.setText(mData.get(position).getJob_title());
           holder.bio.setText(mData.get(position).getBio());

           holder.carModelYear.setText(mData.get(position).getCar_model_year());
       }
       else {

           holder.firstName.setText(mData.get(position).getFirst_name());
           holder.lastName.setText(mData.get(position).getLast_name());
           holder.email.setText(mData.get(position).getEmail());
           holder.country.setText(mData.get(position).getCountry());
           holder.carModel.setText(mData.get(position).getCar_model());
           holder.carColor.setText(mData.get(position).getCar_color());
           holder.gender.setText(mData.get(position).getGender());
           holder.jobTitle.setText(mData.get(position).getJob_title());
           holder.bio.setText(mData.get(position).getBio());

           holder.carModelYear.setText(mData.get(position).getCar_model_year());
       }

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView firstName, lastName, email, country, carModel, carModelYear, carColor, gender,
                jobTitle, bio;

        TextView genderData, countryData, colorData;

        ViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.first_name);
            lastName = itemView.findViewById(R.id.last_name);
            email = itemView.findViewById(R.id.email);
            country = itemView.findViewById(R.id.car_country);
            carModel = itemView.findViewById(R.id.car_model);
            carModelYear = itemView.findViewById(R.id.car_model_year);
            carColor = itemView.findViewById(R.id.car_color);
            gender = itemView.findViewById(R.id.car_gender);
            jobTitle = itemView.findViewById(R.id.job_title);
            bio = itemView.findViewById(R.id.bio);

            //datas
            genderData = itemView.findViewById(R.id.gender_data);
            countryData = itemView.findViewById(R.id.country_data);
            colorData = itemView.findViewById(R.id.car_color_data);
        }

}
}
