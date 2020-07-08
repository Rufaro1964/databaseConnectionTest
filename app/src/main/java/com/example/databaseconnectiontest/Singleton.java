package com.example.databaseconnectiontest;

import android.content.Context;

class Singleton {
    private static Singleton instance;
    private static Context context;
    private RequestQueue requestQueue;

    private Singleton(Context context){
        this.context = context;
        this.instance = getInstance(context);
    }

    public static synchronized Singleton getInstance(Context context){
        if(instance == null){
           instance = new Singleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public<T> void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }
}
