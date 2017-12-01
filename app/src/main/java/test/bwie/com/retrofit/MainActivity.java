package test.bwie.com.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
   private  IAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);

        Call<Bean> call = service.get("88f7bbc507e3ecacfaeab2b47dd8936f");

        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean bean = response.body();
                System.out.println("bean------");
                LinearLayoutManager manager=new LinearLayoutManager(MainActivity.this);
                recyclerview.setLayoutManager(manager);
              adapter=  new IAdapter(MainActivity.this,bean.getResult().getList());
              recyclerview.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {

            }
        });


    }

}
