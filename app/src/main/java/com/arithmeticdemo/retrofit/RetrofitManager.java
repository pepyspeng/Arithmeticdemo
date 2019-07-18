package com.arithmeticdemo.retrofit;

import io.reactivex.Observable;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitManager {

    private Retrofit.Builder retrofitBuilder ;
    private CallAdapter.Factory callAdapterFactory;
    private Converter.Factory ConverterFactoy;
    private Retrofit retrofit ;

    private RetrofitManager() {
        retrofitBuilder = new Retrofit.Builder();
    }

    private void initRetrofit(){
        callAdapterFactory = RxJava2CallAdapterFactory.create();
        ConverterFactoy = FastJsonConverterFactory.create();
        retrofitBuilder = retrofitBuilder.baseUrl("")
                .addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(ConverterFactoy)
                .validateEagerly(true);
        retrofit = retrofitBuilder.build();
        TestApi t  = retrofit.create(TestApi.class);
        t.getApi();

    }

    interface TestApi{
        @GET
        Observable<String> getApi();

    }

}
