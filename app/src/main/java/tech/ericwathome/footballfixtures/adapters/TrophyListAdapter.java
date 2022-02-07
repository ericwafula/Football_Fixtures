package tech.ericwathome.footballfixtures.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tech.ericwathome.footballfixtures.R;
import tech.ericwathome.footballfixtures.models.Trophy;

public class TrophyListAdapter extends RecyclerView.Adapter<TrophyListAdapter.ViewHolder> {
    Context mContext;
    List<Trophy> mTrophies;

    public TrophyListAdapter(Context mContext, List<Trophy> mTrophies) {
        this.mContext = mContext;
        this.mTrophies = mTrophies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trophy_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.league.setText(mTrophies.get(position).getLeague());
        holder.country.setText(mTrophies.get(position).getCountry());
        holder.season.setText(mTrophies.get(position).getSeason());
        holder.place.setText(mTrophies.get(position).getPlace());
    }

    @Override
    public int getItemCount() {
        return mTrophies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView league;
        TextView country;
        TextView season;
        TextView place;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            league = itemView.findViewById(R.id.league);
            country = itemView.findViewById(R.id.country);
            season = itemView.findViewById(R.id.season);
            place = itemView.findViewById(R.id.place);
        }
    }
}
