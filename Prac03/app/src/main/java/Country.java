import android.os.Parcel;
import android.os.Parcelable;

public class Country implements Parcelable {
    private String name;
    private String capital;
    private int population;
    private int area;
    private int flagResourceId;

    public Country(String name, String capital, int population, int area, int flagResourceId) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.flagResourceId = flagResourceId;
    }

    protected Country(Parcel in) {
        name = in.readString();
        capital = in.readString();
        population = in.readInt();
        area = in.readInt();
        flagResourceId = in.readInt();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(capital);
        dest.writeInt(population);
        dest.writeInt(area);
        dest.writeInt(flagResourceId);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFlagResourceId() {
        return flagResourceId;
    }

    public void setFlagResourceId(int flagResourceId) {
        this.flagResourceId = flagResourceId;
    }
}
