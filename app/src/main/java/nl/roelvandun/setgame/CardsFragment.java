package nl.roelvandun.setgame;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CardsFragment extends Fragment {

    private Game game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cards_fragment, container, false);

        final Context context = getActivity().getApplicationContext();

        game = new Game(getActivity().getApplicationContext());
        game.start();

        initCardsGrid(rootView, context);

        return rootView;
    }

    private void initCardsGrid(View rootView, final Context context) {
        final GridView cardsGrid = (GridView) rootView.findViewById(R.id.cards_grid);

        cardsGrid.setAdapter(new CardsAdapter());

        cardsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "clicked " + game.getTableCards().get(position).getId(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    class CardsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return game.getTableCards().size();
        }

        @Override
        public Object getItem(int position) {
            return game.getTableCards().get(position);
        }

        @Override
        public long getItemId(int position) {
            return game.getTableCards().get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return game.getTableCards().get(position).getView();
        }
    }

}
