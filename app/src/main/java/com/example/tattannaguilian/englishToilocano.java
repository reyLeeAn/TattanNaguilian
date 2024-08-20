package com.example.tattannaguilian;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class englishToilocano extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> dictionaryList;
    private HashMap<String, String> dictionaryDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_english_to_ilocano);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(englishToilocano.this, HomePage.class);
                startActivity(intent);
            }
        });

        Button categoryButton = findViewById(R.id.categoryButton);
        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(englishToilocano.this, touristCategory.class);
                startActivity(intent);
            }
        });

        listView = findViewById(R.id.listView);

        dictionaryList = new ArrayList<>();
        dictionaryDescription = new HashMap<>();

        dictionaryList.add("A");
        dictionaryDescription.put("A", "a - ilocano, adjective -\n\nmaysa\n\narticle\n\nThe first letter of the alphabet - Umuna a letra ti alpabeto");

        dictionaryList.add("Abandon");
        dictionaryDescription.put("Abandon", "abandon - ilocano, verb -\n\nbaybay-an\n\nibati\n\nlikudan");

        dictionaryList.add("Abdomen");
        dictionaryDescription.put("Abdomen", "abdomen - ilocano, noun -\n\nbuksit");

        dictionaryList.add("Abduct");
        dictionaryDescription.put("Abduct", "abduct - ilocano, verb -\n\nitaray\n\nagawen");

        dictionaryList.add("Abeyance");
        dictionaryDescription.put("Abeyance", "abeyance - ilocano, noun -\n\npanagur-uray\n\npanangtengngel");

        dictionaryList.add("Abide");
        dictionaryDescription.put("Abide", "abide - ilocano, verb -\n\nagtaeng");

        dictionaryList.add("Ability");
        dictionaryDescription.put("Ability", "ability - ilocano, noun -\n\nkabaelan");

        dictionaryList.add("Able");
        dictionaryDescription.put("Able", "able - ilocano, adjective -\n\nnapigsa\n\naddaan ti bileg\n\naddaan ti kabaelan");

        dictionaryList.add("Abnormal");
        dictionaryDescription.put("Abnormal", "abnormal - ilocano, adjective -\n\nnaisupadi ti kaaduan\n\nsaan a kadawyan");

        dictionaryList.add("Aboard");
        dictionaryDescription.put("Aboard", "aboard - ilocano, adverb -\n\nnakalugan\n\nnakasay");

        dictionaryList.add("Abortion");
        dictionaryDescription.put("Abortion", "abortion - ilocano, noun -\n\npanagpatinnag");

        dictionaryList.add("About");
        dictionaryDescription.put("About", "about - ilocano, preposition -\n\nmaipanggep\n\nmaipapan");

        dictionaryList.add("Above");
        dictionaryDescription.put("Above", "above - ilocano, adverb -\n\nngato\n\nngatuen");

        dictionaryList.add("Abridge");
        dictionaryDescription.put("Abridge", "abridge - ilocano, verb -\n\nyababa\n\ngupongen");

        dictionaryList.add("Abrupt");
        dictionaryDescription.put("Abrupt", "abrupt - ilocano, adjective -\n\ndagus la nga\n\nkellaat");

        dictionaryList.add("Absent");
        dictionaryDescription.put("Absent", "absent - ilocano, adjective -\n\nawan\n\nsaan a simrek");

        dictionaryList.add("Absent Minded");
        dictionaryDescription.put("Absent Minded", "absent minded - ilocano, noun -\n\nmaaw-awan ti kapanunotan na");

        dictionaryList.add("Absolute");
        dictionaryDescription.put("Absolute", "absolute - ilocano, adjective -\n\nmakabalin ti isuamin");

        dictionaryList.add("Absorb");
        dictionaryDescription.put("Absorb", "absorb - ilocano, verb -\n\nsisipen\n\nagsepen\n\nmaikuyog");

        dictionaryList.add("Absurd");
        dictionaryDescription.put("Absurd", "absurd - ilocano, adjective -\n\nnakakat-katawa\n\ndi rumbeng\n\nawan banag na");

        dictionaryList.add("Abundance");
        dictionaryDescription.put("Abundance", "abundance - ilocano, noun -\n\nkinaadu");

        dictionaryList.add("Abuse");
        dictionaryDescription.put("Abuse", "abuse - ilocano, noun - \n\nranggas\n\nverb -\n\nranggasan\n\nirurumen");

        dictionaryList.add("Accent");
        dictionaryDescription.put("Accent", "accent - ilocano, verb -\n\nawaten\n\nalaen");

        dictionaryList.add("Accident");
        dictionaryDescription.put("Accident", "accident - ilocano, noun -\n\nsaan a gargara\n\nsaan a panggep");

        dictionaryList.add("Accompany");
        dictionaryDescription.put("Accompany", "accompany - ilocano, verb -\n\nkaduaan\n\nkuyogen");

        dictionaryList.add("Accomplish");
        dictionaryDescription.put("Accomplish", "accomplish - ilocano, verb -\n\nleppasen\n\naramiden");

        dictionaryList.add("Account");
        dictionaryDescription.put("Account", "account - ilocano, noun -\n\nibilang\n\nsungbatan");

        dictionaryList.add("Accountant");
        dictionaryDescription.put("Accountant", "accountant - ilocano, noun -\n\nmangtaming ti libro ti kompanya");

        dictionaryList.add("Accuse");
        dictionaryDescription.put("Accuse", "accuse - ilocano, verb -\n\npabasolen\n\ndarum");

        dictionaryList.add("Accustom");
        dictionaryDescription.put("Accustom", "accustom - ilocano, verb -\n\nipakadawyan\n\nmairuam\n\niruam");

        dictionaryList.add("Ache");
        dictionaryDescription.put("Ache", "ache - ilocano, noun -\n\nagsakit\n\ngut-ot");

        dictionaryList.add("Acid");
        dictionaryDescription.put("Acid", "acid - ilocano, noun -\n\nkinaalsem\n\nalsem");

        dictionaryList.add("Acknowledge");
        dictionaryDescription.put("Acknowledge", "abundance - ilocano, verb -\n\nbigbigen\n\nawaten");

        dictionaryList.add("Acquaint");
        dictionaryDescription.put("Acquaint", "acquaint - ilocano, verb -\n\nalaen\n\ngun-oden");

        dictionaryList.add("Across");
        dictionaryDescription.put("Across", "across - ilocano, preposition -\n\nballasiw\n\nidiay bangir");

        dictionaryList.add("Act");
        dictionaryDescription.put("Act", "act - ilocano, noun -\n\nagarmid\n\ngumaraw");

        dictionaryList.add("Action");
        dictionaryDescription.put("Action", "action - ilocano, noun -\n\naramid\n\ngaraw");

        dictionaryList.add("Active");
        dictionaryDescription.put("Active", "active - ilocano, adjective -\n\nsibibiag\n\nnaregta");

        dictionaryList.add("Actress");
        dictionaryDescription.put("Actress", "actress - ilocano, noun -\n\nartista nga babai");

        dictionaryList.add("Actual");
        dictionaryDescription.put("Actual", "actual - ilocano, adjective -\n\npudno\n\nagpayso");

        dictionaryList.add("Add");
        dictionaryDescription.put("Add", "add - ilocano, verb -\n\ninayon\n\npagtipunen");

        dictionaryList.add("Addition");
        dictionaryDescription.put("Addition", "addition - ilocano, noun -\n\npanagnanayon");

        dictionaryList.add("Address");
        dictionaryDescription.put("Address", "address - ilocano, noun -\n\npagtaengan\n\npanagbitla");

        dictionaryList.add("Adequate");
        dictionaryDescription.put("Adequate", "adequate - ilocano, adjective -\n\numdas\n\nmakaanay");

        dictionaryList.add("Adjective");
        dictionaryDescription.put("Adjective", "adjective - ilocano, noun -\n\nA story that gives meaning to the thing - Sarita a mangted ti kaipapanan ti banag");

        dictionaryList.add("Adjust");
        dictionaryDescription.put("Adjust", "adjust - ilocano, verb -\n\nibagay");

        dictionaryList.add("Admiral");
        dictionaryDescription.put("Admiral", "admiral - ilocano, noun -\n\nalmirante");

        dictionaryList.add("Admiration");
        dictionaryDescription.put("Admiration", "admiration - ilocano, noun -\n\npanagdayaw");

        dictionaryList.add("Admission");
        dictionaryDescription.put("Admission", "admission - ilocano, noun -\n\npanagawat\n\npanagpastrek");

        dictionaryList.add("Admit");
        dictionaryDescription.put("Admit", "admit - ilocano, verb -\n\nawaten\n\npastreken");

        dictionaryList.add("Adopt");
        dictionaryDescription.put("Adopt", "adopt - ilocano, verb -\n\ntaraknen\n\nalaen\n\npanangala a kas kukua");

        dictionaryList.add("Adult");
        dictionaryDescription.put("Adult", "adult - ilocano, noun -\n\nlakay\n\nnataengan");

        dictionaryList.add("Advantage");
        dictionaryDescription.put("Advantage", "advantage - ilocano, noun -\n\ngundaway\n\npagsayaatan");

        dictionaryList.add("Adventure");
        dictionaryDescription.put("Adventure", "adventure - ilocano, noun -\n\npanagpadas");

        dictionaryList.add("Advertise");
        dictionaryDescription.put("Advertise", "advertise - ilocano, verb -\n\nipaammo\n\niwarnak\n\nipakdaar");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dictionaryList);
        listView.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.searchEngine);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                String description = dictionaryDescription.get(selectedItem);

                Intent intent = new Intent(englishToilocano.this, DetailActivity.class);
                intent.putExtra("item", selectedItem);
                intent.putExtra("description", description);
                startActivity(intent);
            }
        });
    }
}
