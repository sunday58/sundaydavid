
package sundaydavid.venten.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VentenFilter implements Parcelable {

    private int id;
    @SerializedName("start_year")
    private int startYear;
    @SerializedName("end_year")
    private int endYear;
    private String gender;
    private List<String> countries = null;
    private List<String> colors = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public VentenFilter() {
    }

    public VentenFilter(int id, int startYear, int endYear, String gender, List<String> countries, List<String> colors) {
        super();
        this.id = id;
        this.startYear = startYear;
        this.endYear = endYear;
        this.gender = gender;
        this.countries = countries;
        this.colors = colors;
    }

    protected VentenFilter(Parcel in) {
        id = in.readInt();
        startYear = in.readInt();
        endYear = in.readInt();
        gender = in.readString();
        countries = in.createStringArrayList();
        colors = in.createStringArrayList();
    }

    public static final Creator<VentenFilter> CREATOR = new Creator<VentenFilter>() {
        @Override
        public VentenFilter createFromParcel(Parcel in) {
            return new VentenFilter(in);
        }

        @Override
        public VentenFilter[] newArray(int size) {
            return new VentenFilter[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(startYear);
        dest.writeInt(endYear);
        dest.writeString(gender);
        dest.writeStringList(countries);
        dest.writeStringList(colors);
    }
}
