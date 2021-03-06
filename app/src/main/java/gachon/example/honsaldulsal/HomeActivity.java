package gachon.example.honsaldulsal;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag_home home;
    private Frag_info info;
    private Frag_posting posting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);//main이 아닌 home으로

        Button searchBtn = (Button) findViewById(R.id.btn_search);
        Button locationBtn = (Button) findViewById(R.id.btn_loca);

        // 구현필요
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Map activity로 연결
        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(intent);
            }
        });

        bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        setFrag(0);
                        break;
                    case R.id.posting:
                        setFrag(1);
                        break;
                    case R.id.info:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
        home = new Frag_home();
        info = new Frag_info();
        posting = new Frag_posting();
        setFrag(0);
    }

    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.frame_container, home);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.frame_container, posting);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.frame_container, info);
                ft.commit();
                break;
        }
    }
}