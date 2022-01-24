package ir.mohammad.testtamrini;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ir.mohammad.testtamrini.Adapter.FiilteerAdapter;
import ir.mohammad.testtamrini.Adapter.PishnahadAdapter;
import ir.mohammad.testtamrini.model.Fiilteer;
import ir.mohammad.testtamrini.model.Pishnahad;

public class TablighFragment extends Fragment {

    private List<Fiilteer>fiilteers=new ArrayList<>();
    private List<Pishnahad>pishnahads=new ArrayList<>();
    private PishnahadAdapter pishnahadAdapter;
    private FiilteerAdapter fiilteerAdapter;
    private RecyclerView recyclerViewfilter;
    private RecyclerView recyclerViewpishnahad;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tbligh, container, false);
        recyclerViewfilter=(RecyclerView)view.findViewById(R.id.recyclerfiilter);
        fiilteerAdapter=new FiilteerAdapter(fiilteers);
        recyclerViewfilter.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerViewfilter.setAdapter(fiilteerAdapter);
        fiilteers.add(new Fiilteer("ورزشی"));
        fiilteers.add(new Fiilteer("کتابخانه"));
        fiilteers.add(new Fiilteer("رستوران"));
        fiilteers.add(new Fiilteer("بوتیک"));
        fiilteers.add(new Fiilteer("اکسسوری"));
        fiilteers.add(new Fiilteer("خرازی"));

        recyclerViewpishnahad=(RecyclerView)view.findViewById(R.id.recyclerpishnahad);
        pishnahadAdapter=new PishnahadAdapter(pishnahads);
        recyclerViewpishnahad.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerViewpishnahad.setAdapter(pishnahadAdapter);
        pishnahads.add(new Pishnahad("1200","tehran","https://cdn.takhfifan.com/images/1.0?id=/142203/2/_/2_954_21.jpg"));
        pishnahads.add(new Pishnahad("2500","qazvin","https://cdn.takhfifan.com/images/1.0?id=/97584/f/i/first_28_29_2_1_1_1.jpg"));
        pishnahads.add(new Pishnahad("3600","tehran","https://cdn.takhfifan.com/images/1.0?id=/104541/3/1/31556657_239636886787362_3586279060591869952_n.jpg"));
        pishnahads.add(new Pishnahad("4700","shiraz","https://cdn.takhfifan.com/images/1.0?id=/199735/_/1/_1__630_32_1_1.jpg"));
        pishnahads.add(new Pishnahad("3000","tehran","https://cdn.takhfifan.com/images/1.0?id=/82288/_/5/_5__330_17.jpg"));

        return view;
    }
}