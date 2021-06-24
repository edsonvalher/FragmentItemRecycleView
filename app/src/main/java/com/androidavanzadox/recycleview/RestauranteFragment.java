package com.androidavanzadox.recycleview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidavanzadox.recycleview.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class RestauranteFragment extends Fragment {

    //mis variables
    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurantes;
    List<Restaurante> restauranteList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //lista de elementos de restaurantes
            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Pizzeria Carlos","https://image.freepik.com/free-vector/flying-slice-pizza-cartoon-vector-illustration-fast-food-concept-isolated-vector-flat-cartoon-style_138676-1934.jpg", (float) 4.0,"Madrid España"));
            restauranteList.add(new Restaurante("Hamburguesas San Carlos","https://image.freepik.com/free-vector/vintage-background-with-appetizing-burger_23-2147629963.jpg", (float) 3.0,"Barcelona España"));
            restauranteList.add(new Restaurante("Cerveceria Monte Azul","https://image.freepik.com/free-vector/line-graphics-monogram-template-with-logos-emblems-beer-house-bar-pub-brewing-company-brewery-tavern_1284-49312.jpg", (float) 4.0,"Madrid Fuerteventura"));
            restauranteList.add(new Restaurante("Jamones Miguel","https://image.freepik.com/free-vector/vintage-vector-meat-products-design-template-hand-drawn-ham-sausages-jamon-spices-herbs-retro-illustration-can-be-use-restaurant-menu_97441-2210.jpg", (float) 4.0,"Cantabria España"));



            //adapterRestaurantes = new MyRestauranteRecyclerViewAdapter(PlaceholderContent.ITEMS);
            adapterRestaurantes = new MyRestauranteRecyclerViewAdapter(getActivity(),restauranteList);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}