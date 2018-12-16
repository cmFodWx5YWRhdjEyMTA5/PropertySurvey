package frameworks.network.interceptor;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;

import frameworks.network.model.BaseResponseError;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by hendry on 9/15/2017.
 */

public class ErrorResponseInterceptor implements Interceptor {
    private static final int BYTE_COUNT = 2048;
    private Class<? extends BaseResponseError> responseErrorClass;

    public ErrorResponseInterceptor(@NonNull Class<? extends BaseResponseError> responseErrorClass) {
        this.responseErrorClass = responseErrorClass;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        ResponseBody responseBody = null;
        String responseBodyString = "";
        if (mightContainCustomError(response)) {
            responseBody = response.peekBody(BYTE_COUNT);
            responseBodyString = responseBody.string();

            Gson gson = new Gson();
            BaseResponseError responseError = null;
            try {
                responseError = gson.fromJson(responseBodyString, responseErrorClass);
            } catch (JsonSyntaxException e) { // the json might not be TkpdResponseError instance, so just return it
                return response;
            }
            if (responseError == null) { // no error object
                return response;
            } else {
                if(responseError.getStatusCode() == 401) {
                    return createUnauthorizedResponse(response,responseBodyString);
                }else {
                    if (responseError.hasBody()) {
                        //noinspection ConstantConditions
                        response.body().close();
                        throw responseError.createException();
                    } else {
                        return response;
                    }
                }
            }
        }
        return response;
    }
    protected Response createUnauthorizedResponse(Response oldResponse, String oldBodyResponse) {
        ResponseBody body = ResponseBody.create(oldResponse.body().contentType(), oldBodyResponse);

        Response.Builder builder = new Response.Builder();
        builder.body(body)
                .headers(oldResponse.headers())
                .message(oldResponse.message())
                .handshake(oldResponse.handshake())
                .protocol(oldResponse.protocol())
                .cacheResponse(oldResponse.cacheResponse())
                .priorResponse(oldResponse.priorResponse())
                .code(401)
                .request(oldResponse.request())
                .networkResponse(oldResponse.networkResponse());

        return builder.build();
    }

    protected boolean mightContainCustomError(Response response) {
        return response != null;
    }
}
