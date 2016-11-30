package com.dongshujin.demo.test.multithread;

/**
 * Created by dongsj on 16/11/30.
 */
public class ThreadLocalThread {
    /**
     * 该类在此代表了一些资源
     */
    static class ConnectionSource {


        public ConnectionSource() {

        }

    }

    private static ThreadLocal<ConnectionSource> connectionHolder = new ThreadLocal<ConnectionSource>(){
        @Override
        protected ConnectionSource initialValue() {
            return new ConnectionSource();
        }
    };

    public static ConnectionSource getConnection() {
        return connectionHolder.get();
    }
}
