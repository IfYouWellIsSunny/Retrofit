package test.bwie.com.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lj on 2017/11/29.
 */

public interface GitHubService {
    //http://v.juhe.cn/weixin/query?key=88f7bbc507e3ecacfaeab2b47dd8936f
    @GET("weixin/query")
    Call<Bean> get(@Query("key") String key);

}
