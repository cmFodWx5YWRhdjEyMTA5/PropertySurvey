package com.softminesol.survey_framework.getToken.data.interceptor;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.softminesol.survey_framework.getToken.model.LoginResponse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.UnknownHostException;

import frameworks.network.interceptor.AppBaseInterceptor;
import frameworks.network.model.DataResponse;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by sandeep on 5/5/18.
 */
public class GetTokenInterceptor extends AppBaseInterceptor {
    private static final int BYTE_COUNT = 2048;

    @Override
    protected Response getResponse(Chain chain, Request request) throws IOException {
        try {
            Response response = chain.proceed(request);
            if (response != null) {
                ResponseBody responseBody = response.peekBody(BYTE_COUNT);
                String responseBodyString = responseBody.string();
                String token = response.header("GIS_TOKEN");
                Gson gson = new Gson();
                DataResponse<LoginResponse> dataResponse = null;
                try {
                    Type collectionType = new TypeToken<DataResponse<LoginResponse>>() {
                    }.getType();
                    dataResponse = gson.fromJson(responseBodyString, collectionType);
                } catch (JsonSyntaxException e) { // the json might not be TkpdResponseError instance, so just return it
                    return response;
                }
                if (dataResponse == null) { // no error object
                    return response;
                } else {
                    dataResponse.getData().setAuthToken(token);
                }
                return createNewResponse(response, gson.toJson(dataResponse));
            }
            return response;
        } catch (Error e) {
            throw new UnknownHostException();
        }
    }

    protected Response createNewResponse(Response oldResponse, String oldBodyResponse) {
        ResponseBody body = ResponseBody.create(oldResponse.body().contentType(), oldBodyResponse);
        Response.Builder builder = new Response.Builder();
        builder.body(body)
                .headers(oldResponse.headers())
                .message(oldResponse.message())
                .handshake(oldResponse.handshake())
                .protocol(oldResponse.protocol())
                .cacheResponse(oldResponse.cacheResponse())
                .priorResponse(oldResponse.priorResponse())
                .code(oldResponse.code())
                .request(oldResponse.request())
                .networkResponse(oldResponse.networkResponse());
        return builder.build();
    }
}
