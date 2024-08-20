package com.example.tattannaguilian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class touristCategory extends AppCompatActivity {

    private ListView listView;
    private CustomArrayAdapter adapter;
    private List<String> touristCategory;
    private Map<String, List<String>> subCategories;
    private boolean isFallsExpanded = false;
    private boolean isFarmRanchExpanded = false;
    private boolean isHistoricMonumentExpanded = false;
    private boolean isHistoricSiteExpanded = false;
    private boolean isLeisureLandExpanded = false;
    private boolean isNatureTrailExpanded = false;
    private boolean isReligiousSiteExpanded = false;
    private boolean isRiverLandscapeExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tourist_category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);

        touristCategory = new ArrayList<>();
        // Folder selection
        touristCategory.add("Falls");
        touristCategory.add("Farm / Ranch");
        touristCategory.add("Historic Monument");
        touristCategory.add("Historic Site / Archeological Sites");
        touristCategory.add("Leisure-land / Theme Park");
        touristCategory.add("Nature Trail Path");
        touristCategory.add("Religious Site");
        touristCategory.add("River & Landscape");

        // Tourist category
        touristCategory.add("Municipal of Naguilian La, Union");
        touristCategory.add("Saint Augustine Of Hippo Parish");

        subCategories = new HashMap<>();
        subCategories.put("Falls", Arrays.asList("Minzi Falls", "Sangbay Falls", "Tuddingan Falls"));
        subCategories.put("Farm / Ranch", Arrays.asList("Naguilian Basi Processing Center", "San Antonio Mini Rice Terraces"));
        subCategories.put("Historic Monument", Arrays.asList("Mangkaeng Memorial Site"));
        subCategories.put("Historic Site / Archeological Sites", Arrays.asList(
                "Gabaldon Building (Dr. Hermogenes F. Belen Elementary School)",
                "Camp Lt. Col. Jose M. Laberinto", "Tomb Of The Unknown Soldiers"));
        subCategories.put("Leisure-land / Theme Park", Arrays.asList(
                "Ivy's Garden Amore", "Naguilian Bougainvillea Park", "Naguilian Eco Sanctuary", "Naguilian Town Plaza"));
        subCategories.put("Nature Trail Path", Arrays.asList("Naguilian Watershed"));
        subCategories.put("Religious Site", Arrays.asList("Daughters Of Mary Consolatrix Monastery"));
        subCategories.put("River & Landscape", Arrays.asList("Baraoas Sur Rapids"));

        adapter = new CustomArrayAdapter(this, touristCategory);
        listView.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.searchEngine);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCategory = adapter.getItem(position);
            if (selectedCategory != null) {
                switch (selectedCategory) {
                    case "Falls":
                        if (isFallsExpanded) {
                            collapseFalls();
                        } else {
                            expandFalls();
                        }
                        break;
                    case "Farm / Ranch":
                        if (isFarmRanchExpanded) {
                            collapseFarmRanch();
                        } else {
                            expandFarmRanch();
                        }
                        break;
                    case "Historic Monument":
                        if (isHistoricMonumentExpanded) {
                            collapseHistoricMonument();
                        } else {
                            expandHistoricMonument();
                        }
                        break;
                    case "Historic Site / Archeological Sites":
                        if (isHistoricSiteExpanded) {
                            collapseHistoricSite();
                        } else {
                            expandHistoricSite();
                        }
                        break;
                    case "Leisure-land / Theme Park":
                        if (isLeisureLandExpanded) {
                            collapseLeisureLand();
                        } else {
                            expandLeisureLand();
                        }
                        break;
                    case "Nature Trail Path":
                        if (isNatureTrailExpanded) {
                            collapseNatureTrail();
                        } else {
                            expandNatureTrail();
                        }
                        break;
                    case "Religious Site":
                        if (isReligiousSiteExpanded) {
                            collapseReligiousSite();
                        } else {
                            expandReligiousSite();
                        }
                        break;
                    case "River & Landscape":
                        if (isRiverLandscapeExpanded) {
                            collapseRiverLandscape();
                        } else {
                            expandRiverLandscape();
                        }
                        break;
                    default:
                        handleCategorySelection(selectedCategory);
                        break;
                }
            }
        });

        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(touristCategory.this, HomePage.class);
                startActivity(intent);
            }
        });

        Button categoryButton = findViewById(R.id.categoryButton);
        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(touristCategory.this, touristCategory.class);
                startActivity(intent);
            }
        });

        Button multilingualButton = findViewById(R.id.multilingialButton);
        multilingualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(touristCategory.this, englishToilocano.class);
                startActivity(intent);
            }
        });
    }

    private void expandFalls() {
        int index = touristCategory.indexOf("Falls");
        if (index != -1) {
            touristCategory.addAll(index + 1, subCategories.get("Falls"));
            adapter.notifyDataSetChanged();
            isFallsExpanded = true;
        }
    }

    private void collapseFalls() {
        int index = touristCategory.indexOf("Falls");
        if (index != -1) {
            touristCategory.removeAll(subCategories.get("Falls"));
            adapter.notifyDataSetChanged();
            isFallsExpanded = false;
        }
    }

    private void expandFarmRanch() {
        int index = touristCategory.indexOf("Farm / Ranch");
        if (index != -1) {
            touristCategory.addAll(index + 1, subCategories.get("Farm / Ranch"));
            adapter.notifyDataSetChanged();
            isFarmRanchExpanded = true;
        }
    }

    private void collapseFarmRanch() {
        int index = touristCategory.indexOf("Farm / Ranch");
        if (index != -1) {
            touristCategory.removeAll(subCategories.get("Farm / Ranch"));
            adapter.notifyDataSetChanged();
            isFarmRanchExpanded = false;
        }
    }

    private void expandHistoricMonument() {
        int index = touristCategory.indexOf("Historic Monument");
        if (index != -1) {
            touristCategory.addAll(index + 1, subCategories.get("Historic Monument"));
            adapter.notifyDataSetChanged();
            isHistoricMonumentExpanded = true;
        }
    }

    private void collapseHistoricMonument() {
        int index = touristCategory.indexOf("Historic Monument");
        if (index != -1) {
            touristCategory.removeAll(subCategories.get("Historic Monument"));
            adapter.notifyDataSetChanged();
            isHistoricMonumentExpanded = false;
        }
    }

    private void expandHistoricSite() {
        int index = touristCategory.indexOf("Historic Site / Archeological Sites");
        if (index != -1) {
            touristCategory.addAll(index + 1, subCategories.get("Historic Site / Archeological Sites"));
            adapter.notifyDataSetChanged();
            isHistoricSiteExpanded = true;
        }
    }

    private void collapseHistoricSite() {
        int index = touristCategory.indexOf("Historic Site / Archeological Sites");
        if (index != -1) {
            touristCategory.removeAll(subCategories.get("Historic Site / Archeological Sites"));
            adapter.notifyDataSetChanged();
            isHistoricSiteExpanded = false;
        }
    }

    private void expandLeisureLand() {
        int index = touristCategory.indexOf("Leisure-land / Theme Park");
        if (index != -1) {
            touristCategory.addAll(index + 1, subCategories.get("Leisure-land / Theme Park"));
            adapter.notifyDataSetChanged();
            isLeisureLandExpanded = true;
        }
    }

    private void collapseLeisureLand() {
        int index = touristCategory.indexOf("Leisure-land / Theme Park");
        if (index != -1) {
            touristCategory.removeAll(subCategories.get("Leisure-land / Theme Park"));
            adapter.notifyDataSetChanged();
            isLeisureLandExpanded = false;
        }
    }

    private void expandNatureTrail() {
        int index = touristCategory.indexOf("Nature Trail Path");
        if (index != -1) {
            touristCategory.addAll(index + 1, subCategories.get("Nature Trail Path"));
            adapter.notifyDataSetChanged();
            isNatureTrailExpanded = true;
        }
    }

    private void collapseNatureTrail() {
        int index = touristCategory.indexOf("Nature Trail Path");
        if (index != -1) {
            touristCategory.removeAll(subCategories.get("Nature Trail Path"));
            adapter.notifyDataSetChanged();
            isNatureTrailExpanded = false;
        }
    }

    private void expandReligiousSite() {
        int index = touristCategory.indexOf("Religious Site");
        if (index != -1) {
            touristCategory.addAll(index + 1, subCategories.get("Religious Site"));
            adapter.notifyDataSetChanged();
            isReligiousSiteExpanded = true;
        }
    }

    private void collapseReligiousSite() {
        int index = touristCategory.indexOf("Religious Site");
        if (index != -1) {
            touristCategory.removeAll(subCategories.get("Religious Site"));
            adapter.notifyDataSetChanged();
            isReligiousSiteExpanded = false;
        }
    }

    private void expandRiverLandscape() {
        int index = touristCategory.indexOf("River & Landscape");
        if (index != -1) {
            touristCategory.addAll(index + 1, subCategories.get("River & Landscape"));
            adapter.notifyDataSetChanged();
            isRiverLandscapeExpanded = true;
        }
    }

    private void collapseRiverLandscape() {
        int index = touristCategory.indexOf("River & Landscape");
        if (index != -1) {
            touristCategory.removeAll(subCategories.get("River & Landscape"));
            adapter.notifyDataSetChanged();
            isRiverLandscapeExpanded = false;
        }
    }

    private void handleCategorySelection(String selectedCategory) {
        switch (selectedCategory) {
            case "Baraoas Sur Rapids":
                startActivity(new Intent(touristCategory.this, Rapids.class));
                break;
            case "Camp Lt. Col. Jose M. Laberinto":
                startActivity(new Intent(touristCategory.this, campLt.class));
                break;
            case "Daughters Of Mary Consolatrix Monastery":
                startActivity(new Intent(touristCategory.this, daughters.class));
                break;
            case "Gabaldon Building (Dr. Hermogenes F. Belen Elementary School)":
                startActivity(new Intent(touristCategory.this, gabaldon.class));
                break;
            case "Ivy's Garden Amore":
                startActivity(new Intent(touristCategory.this, ivys.class));
                break;
            case "Mangkaeng Memorial Site":
                startActivity(new Intent(touristCategory.this, mangkaeng.class));
                break;
            case "Minzi Falls":
                startActivity(new Intent(touristCategory.this, minzi.class));
                break;
            case "Municipal of Naguilian La, Union":
                startActivity(new Intent(touristCategory.this, municipal.class));
                break;
            case "Naguilian Basi Processing Center":
                startActivity(new Intent(touristCategory.this, basi.class));
                break;
            case "Naguilian Bougainvillea Park":
                startActivity(new Intent(touristCategory.this, bougainvilla.class));
                break;
            case "Naguilian Eco Sanctuary":
                startActivity(new Intent(touristCategory.this, sanctuary.class));
                break;
            case "Naguilian Town Plaza":
                startActivity(new Intent(touristCategory.this, plaza.class));
                break;
            case "Naguilian Watershed":
                startActivity(new Intent(touristCategory.this, watershed.class));
                break;
            case "Saint Augustine Of Hippo Parish":
                startActivity(new Intent(touristCategory.this, church.class));
                break;
            case "San Antonio Mini Rice Terraces":
                startActivity(new Intent(touristCategory.this, terraces.class));
                break;
            case "Sangbay Falls":
                startActivity(new Intent(touristCategory.this, sangbay.class));
                break;
            case "Tomb Of The Unknown Soldiers":
                startActivity(new Intent(touristCategory.this, tomb.class));
                break;
            case "Tuddingan Falls":
                startActivity(new Intent(touristCategory.this, tudingan.class));
                break;
        }
    }
}
