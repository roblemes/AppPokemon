package com.example.apppokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.textResult);
    }

    public void solicitarDado(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://pokeapi.co/api/v2/pokemon/1";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                        /*String dados = "";
                        dados += "Nome do pokemon:\n";
                        dados += response.getString("name");
                        dados += "\nAtaques possiveis:";
                        JSONArray ataques = response.getJSONArray("moves");

                        for(int i=0; i < ataques.length(); i++){
                            JSONObject ataque_info = ataques.getJSONObject(i);
                            JSONObject ataque = ataque_info.getJSONObject("move");
                            dados += "\n" + ataque.getString("name");
                        }

                            textResult.setText(dados);
                            */
                            Pokemon pokemon = new Pokemon();
                            pokemon.setNome(response.getString("name"));

                            JSONArray ataques = response.getJSONArray("moves");

                            for (int i = 0; i < ataques.length(); i++) {
                                JSONObject ataque_info = ataques.getJSONObject(i);
                                JSONObject ataque = ataque_info.getJSONObject("move");
                                pokemon.addAtaque(ataque.getString("name"));
                            }

                            textResult.setText(pokemon.toString());

                        } catch (JSONException error) {
                            textResult.setText(error.getMessage());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textResult.setText(error.getMessage());
            }
        });
        queue.add(request);
    }
}