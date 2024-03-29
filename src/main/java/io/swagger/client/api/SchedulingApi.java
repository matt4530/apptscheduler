/*
 * Brevium Interview 2021 API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.AppointmentInfo;
import io.swagger.client.model.AppointmentInfoRequest;
import io.swagger.client.model.AppointmentRequest;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchedulingApi {
    private ApiClient apiClient;

    public SchedulingApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SchedulingApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for apiSchedulingAppointmentRequestGet
     * @param token Your unique API token (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call apiSchedulingAppointmentRequestGetCall(UUID token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/api/Scheduling/AppointmentRequest";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call apiSchedulingAppointmentRequestGetValidateBeforeCall(UUID token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = apiSchedulingAppointmentRequestGetCall(token, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Returns the next appointment request to be serviced.
     * 
     * @param token Your unique API token (optional)
     * @return AppointmentRequest
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AppointmentRequest apiSchedulingAppointmentRequestGet(UUID token) throws ApiException {
        ApiResponse<AppointmentRequest> resp = apiSchedulingAppointmentRequestGetWithHttpInfo(token);
        return resp.getData();
    }

    /**
     * Returns the next appointment request to be serviced.
     * 
     * @param token Your unique API token (optional)
     * @return ApiResponse&lt;AppointmentRequest&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AppointmentRequest> apiSchedulingAppointmentRequestGetWithHttpInfo(UUID token) throws ApiException {
        com.squareup.okhttp.Call call = apiSchedulingAppointmentRequestGetValidateBeforeCall(token, null, null);
        Type localVarReturnType = new TypeToken<AppointmentRequest>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns the next appointment request to be serviced. (asynchronously)
     * 
     * @param token Your unique API token (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call apiSchedulingAppointmentRequestGetAsync(UUID token, final ApiCallback<AppointmentRequest> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = apiSchedulingAppointmentRequestGetValidateBeforeCall(token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AppointmentRequest>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for apiSchedulingScheduleGet
     * @param token Your unique API token (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call apiSchedulingScheduleGetCall(UUID token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/api/Scheduling/Schedule";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call apiSchedulingScheduleGetValidateBeforeCall(UUID token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = apiSchedulingScheduleGetCall(token, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Returns the initial monthly schedule.
     * 
     * @param token Your unique API token (optional)
     * @return List&lt;AppointmentInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<AppointmentInfo> apiSchedulingScheduleGet(UUID token) throws ApiException {
        ApiResponse<List<AppointmentInfo>> resp = apiSchedulingScheduleGetWithHttpInfo(token);
        return resp.getData();
    }

    /**
     * Returns the initial monthly schedule.
     * 
     * @param token Your unique API token (optional)
     * @return ApiResponse&lt;List&lt;AppointmentInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<AppointmentInfo>> apiSchedulingScheduleGetWithHttpInfo(UUID token) throws ApiException {
        com.squareup.okhttp.Call call = apiSchedulingScheduleGetValidateBeforeCall(token, null, null);
        Type localVarReturnType = new TypeToken<List<AppointmentInfo>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns the initial monthly schedule. (asynchronously)
     * 
     * @param token Your unique API token (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call apiSchedulingScheduleGetAsync(UUID token, final ApiCallback<List<AppointmentInfo>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = apiSchedulingScheduleGetValidateBeforeCall(token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<AppointmentInfo>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for apiSchedulingSchedulePost
     * @param body The information about the appointment you&#x27;d like to set. &lt;br /&gt;&lt;br /&gt;Note that the appointmentTime should be in the practice time (UTC). You may send dates in the ISO 8601 format (with timezone information and as shown in the example) or in that same format but without the timezone information.&lt;br /&gt;&lt;br /&gt;If you submit without the timezone information the time will be assumed to be in UTC time. For example: &#x27;2021-10-14T15:00:00.000&#x27; is interpreted as &#x27;2021-10-14T15:00:00.000Z&#x27;&lt;br /&gt;&lt;br /&gt;If you submit but with a timezone offset it will be converted into UTC time.For example: &#x27;2021-10-14T15:00:00.000-06:00&#x27; is converted to &#x27;2021-10-14T21:00:00.000Z&#x27; (optional)
     * @param token Your unique API token (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call apiSchedulingSchedulePostCall(AppointmentInfoRequest body, UUID token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/api/Scheduling/Schedule";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "text/json", "application/_*+json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call apiSchedulingSchedulePostValidateBeforeCall(AppointmentInfoRequest body, UUID token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = apiSchedulingSchedulePostCall(body, token, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Marks an appointment slot as taken.
     * 
     * @param body The information about the appointment you&#x27;d like to set. &lt;br /&gt;&lt;br /&gt;Note that the appointmentTime should be in the practice time (UTC). You may send dates in the ISO 8601 format (with timezone information and as shown in the example) or in that same format but without the timezone information.&lt;br /&gt;&lt;br /&gt;If you submit without the timezone information the time will be assumed to be in UTC time. For example: &#x27;2021-10-14T15:00:00.000&#x27; is interpreted as &#x27;2021-10-14T15:00:00.000Z&#x27;&lt;br /&gt;&lt;br /&gt;If you submit but with a timezone offset it will be converted into UTC time.For example: &#x27;2021-10-14T15:00:00.000-06:00&#x27; is converted to &#x27;2021-10-14T21:00:00.000Z&#x27; (optional)
     * @param token Your unique API token (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void apiSchedulingSchedulePost(AppointmentInfoRequest body, UUID token) throws ApiException {
        apiSchedulingSchedulePostWithHttpInfo(body, token);
    }

    /**
     * Marks an appointment slot as taken.
     * 
     * @param body The information about the appointment you&#x27;d like to set. &lt;br /&gt;&lt;br /&gt;Note that the appointmentTime should be in the practice time (UTC). You may send dates in the ISO 8601 format (with timezone information and as shown in the example) or in that same format but without the timezone information.&lt;br /&gt;&lt;br /&gt;If you submit without the timezone information the time will be assumed to be in UTC time. For example: &#x27;2021-10-14T15:00:00.000&#x27; is interpreted as &#x27;2021-10-14T15:00:00.000Z&#x27;&lt;br /&gt;&lt;br /&gt;If you submit but with a timezone offset it will be converted into UTC time.For example: &#x27;2021-10-14T15:00:00.000-06:00&#x27; is converted to &#x27;2021-10-14T21:00:00.000Z&#x27; (optional)
     * @param token Your unique API token (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> apiSchedulingSchedulePostWithHttpInfo(AppointmentInfoRequest body, UUID token) throws ApiException {
        com.squareup.okhttp.Call call = apiSchedulingSchedulePostValidateBeforeCall(body, token, null, null);
        return apiClient.execute(call);
    }

    /**
     * Marks an appointment slot as taken. (asynchronously)
     * 
     * @param body The information about the appointment you&#x27;d like to set. &lt;br /&gt;&lt;br /&gt;Note that the appointmentTime should be in the practice time (UTC). You may send dates in the ISO 8601 format (with timezone information and as shown in the example) or in that same format but without the timezone information.&lt;br /&gt;&lt;br /&gt;If you submit without the timezone information the time will be assumed to be in UTC time. For example: &#x27;2021-10-14T15:00:00.000&#x27; is interpreted as &#x27;2021-10-14T15:00:00.000Z&#x27;&lt;br /&gt;&lt;br /&gt;If you submit but with a timezone offset it will be converted into UTC time.For example: &#x27;2021-10-14T15:00:00.000-06:00&#x27; is converted to &#x27;2021-10-14T21:00:00.000Z&#x27; (optional)
     * @param token Your unique API token (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call apiSchedulingSchedulePostAsync(AppointmentInfoRequest body, UUID token, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = apiSchedulingSchedulePostValidateBeforeCall(body, token, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for apiSchedulingStartPost
     * @param token Your unique API token (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call apiSchedulingStartPostCall(UUID token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/api/Scheduling/Start";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call apiSchedulingStartPostValidateBeforeCall(UUID token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = apiSchedulingStartPostCall(token, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Hit this endpoint to reset the test system before each &#x27;run&#x27; of your program.
     * 
     * @param token Your unique API token (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void apiSchedulingStartPost(UUID token) throws ApiException {
        apiSchedulingStartPostWithHttpInfo(token);
    }

    /**
     * Hit this endpoint to reset the test system before each &#x27;run&#x27; of your program.
     * 
     * @param token Your unique API token (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> apiSchedulingStartPostWithHttpInfo(UUID token) throws ApiException {
        com.squareup.okhttp.Call call = apiSchedulingStartPostValidateBeforeCall(token, null, null);
        return apiClient.execute(call);
    }

    /**
     * Hit this endpoint to reset the test system before each &#x27;run&#x27; of your program. (asynchronously)
     * 
     * @param token Your unique API token (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call apiSchedulingStartPostAsync(UUID token, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = apiSchedulingStartPostValidateBeforeCall(token, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for apiSchedulingStopPost
     * @param token Your unique API token (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call apiSchedulingStopPostCall(UUID token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/api/Scheduling/Stop";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call apiSchedulingStopPostValidateBeforeCall(UUID token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = apiSchedulingStopPostCall(token, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * This is an optional endpoint that will allow you to mark a test run as &#x27;done&#x27;. The API will then return the current schedule as you have requested it, for your debugging pleasure.
     * 
     * @param token Your unique API token (optional)
     * @return List&lt;AppointmentInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<AppointmentInfo> apiSchedulingStopPost(UUID token) throws ApiException {
        ApiResponse<List<AppointmentInfo>> resp = apiSchedulingStopPostWithHttpInfo(token);
        return resp.getData();
    }

    /**
     * This is an optional endpoint that will allow you to mark a test run as &#x27;done&#x27;. The API will then return the current schedule as you have requested it, for your debugging pleasure.
     * 
     * @param token Your unique API token (optional)
     * @return ApiResponse&lt;List&lt;AppointmentInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<AppointmentInfo>> apiSchedulingStopPostWithHttpInfo(UUID token) throws ApiException {
        com.squareup.okhttp.Call call = apiSchedulingStopPostValidateBeforeCall(token, null, null);
        Type localVarReturnType = new TypeToken<List<AppointmentInfo>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * This is an optional endpoint that will allow you to mark a test run as &#x27;done&#x27;. The API will then return the current schedule as you have requested it, for your debugging pleasure. (asynchronously)
     * 
     * @param token Your unique API token (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call apiSchedulingStopPostAsync(UUID token, final ApiCallback<List<AppointmentInfo>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = apiSchedulingStopPostValidateBeforeCall(token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<AppointmentInfo>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
