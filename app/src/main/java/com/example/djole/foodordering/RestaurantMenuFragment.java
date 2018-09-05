package com.example.djole.foodordering;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.djole.foodordering.ListAdapter;

import java.util.zip.Inflater;

/**
 * Created by Djole on 04-Sep-18.
 */

public class RestaurantMenuFragment extends Fragment{
    private Context context;
    private int [] imagesIds = {R.drawable.burger, R.drawable.club_sandwich, R.drawable.dzigerica, R.drawable.krlica, R.drawable.pizza, R.drawable.biftek};
    private String [] titles = {"Burger", "Klub sendvič","Džigerica","Krilca", "Pizza", "Biftek"};
    private String [] prices = {"300 RSD","250 RSD", "380 RSD", "400 RSD", "200 RSD", "600 RSD"};
    private String [] ingridients = {"Pljeskavica, sir, luk", "Šunka, sir, tost", "Džigerica, luk", "Krilca, kurkuma", "Šunka, sir, pečurke","Biftek, so"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_menu_tab, container, false);

        ListView listView = view.findViewById(R.id.listViewMenuTab);
        ViewCompat.setNestedScrollingEnabled(listView,true);
        MyAdapter myAdapter = new MyAdapter(getActivity(),titles, imagesIds, prices, ingridients);
        listView.setAdapter(myAdapter);/*
        ListAdapter listAdapter = new ListAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.listViewMenuTab);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);*/

        return view;
    }
}

class MyAdapter extends ArrayAdapter<String> {
    private Context context;
    private String [] titles;
    private String [] prices;
    private String [] ingredients;
    private int [] imagesIds;
    public MyAdapter(@NonNull Context context, String [] titles, int[] imagesIds, String [] prices, String [] ingridients) {
        super(context, R.layout.restaurant_menu_list_item);
        this.context = context;
        this.imagesIds = imagesIds;
        this.titles = titles;
        this.prices = prices;
        this.ingredients = ingridients;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.restaurant_menu_list_item,parent,false);

        ImageView image = row.findViewById(R.id.imageMenuItem);
        TextView title = row.findViewById(R.id.textViewFoodTitle);
        TextView price = row.findViewById(R.id.textViewPrice);
        TextView ingridient = row.findViewById(R.id.textViewIngredients);

        image.setImageResource(imagesIds[position]);
        title.setText(titles[position]);
        price.setText(prices[position]);
        ingridient.setText(ingredients[position]);
        return row;
    }
}
