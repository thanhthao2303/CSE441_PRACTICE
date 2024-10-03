import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.prac03.R;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countryList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Country country);
    }

    public CountryAdapter(List<Country> countryList, OnItemClickListener listener) {
        this.countryList = countryList;
        this.listener = listener;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.bind(country, listener);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView, capitalTextView;
        private ImageView flagImageView;

        public CountryViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.countryNameTextView);
            capitalTextView = itemView.findViewById(R.id.capitalTextView);
            flagImageView = itemView.findViewById(R.id.flagImageView);
        }

        public void bind(final Country country, final OnItemClickListener listener) {
            nameTextView.setText(country.getName());
            capitalTextView.setText(country.getCapital());
            flagImageView.setImageResource(country.getFlagResourceId());
            itemView.setOnClickListener(v -> listener.onItemClick(country));
        }
    }
}
