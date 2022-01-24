package ir.mohammad.testtamrini;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ir.mohammad.testtamrini.Adapter.HomeAdapter;
import ir.mohammad.testtamrini.model.HomeModel;
import ir.mohammad.testtamrini.model.HomeUrl;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewhome;
    private List<HomeUrl> homeUrls = new ArrayList<>();
    private HomeAdapter homeAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewhome = (RecyclerView) view.findViewById(R.id.recyclerhomejson);
        recyclerViewhome.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String Divarurl = "http://10.0.2.2:5000/";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Divarurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("tag", "onResponse: " + response);
                try {
                    JSONArray jsonArrayparent = new JSONArray(response);
                    HomeModel homeModel = new HomeModel();
                    for (int i = 0; i < jsonArrayparent.length(); i++) {
                        JSONObject jsonObject = jsonArrayparent.getJSONObject(i);
                        HomeUrl homeUrl = new HomeUrl();
                        homeUrl.setTitle(jsonObject.getString("title"));
                        homeUrl.setTozih(jsonObject.getString("description"));
                        homeUrl.setPrice(jsonObject.getString("price"));
                        homeUrl.setData(jsonObject.getString("date"));
                        if (jsonObject.has("thumbnail")) {
                            homeUrl.setImageurl(jsonObject.getString("thumbnail"));
                        } else {
                            homeUrl.setImageurl("not found");
                        }
                        JSONArray jsonArray = jsonObject.getJSONArray("web_images");
                        for (int a = 0; a < jsonArray.length(); a++) {

                        }
                        homeUrls.add(homeUrl);

                    }
                    homeModel.setHomeUrls(homeUrls);
                    homeAdapter = new HomeAdapter(homeUrls);
                    recyclerViewhome.setAdapter(homeAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("TAG", "onResponse: "+e.getMessage() );
                    Toast.makeText(getContext(), "catch" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Tag", "onErrorResponse: " + error.getMessage());
                Toast.makeText(getContext(), "khata da barghari internet", Toast.LENGTH_SHORT).show();

            }
        });
        stringRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 180000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 180000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        queue.add(stringRequest);

        return view;
    }
}