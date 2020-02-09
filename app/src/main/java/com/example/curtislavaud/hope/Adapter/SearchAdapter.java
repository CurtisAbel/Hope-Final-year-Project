package com.example.curtislavaud.hope.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.curtislavaud.hope.Model.Footballer;
import com.example.curtislavaud.hope.R;

import java.util.List;

/**
 * Created by Curtis Lavaud on 24/03/2019.
 */

class SearchViewHolder extends RecyclerView.ViewHolder{

    public TextView name, age, position, email, area;
    public SearchViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView .findViewById(R.id.name_search);
        age = (TextView)itemView .findViewById(R.id.age_search);
        position = (TextView)itemView .findViewById(R.id.position_search);
        email = (TextView)itemView .findViewById(R.id.email_search);
        area = (TextView)itemView .findViewById(R.id.area_search);
    }
}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder>  {

    private Context context;
    private List<Footballer> footballers;

    public SearchAdapter(Context context, List<Footballer> footballers) {
        this.context = context;
        this.footballers = footballers;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item,parent,false);
        return new SearchViewHolder(itemView) ;
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.name.setText(footballers.get(position).getName());
        holder.age.setText(footballers.get(position).getAge());
        holder.position.setText(footballers.get(position).getPosition());
        holder.email.setText(footballers.get(position).getEmail());
        holder.area.setText(footballers.get(position).getArea() );

    }

    @Override
    public int getItemCount() {
        return footballers.size();
    }
}

