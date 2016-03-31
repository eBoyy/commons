package com.utils;

import java.util.concurrent.locks.LockSupport;

/**
 * Description: CachedClock
 * Author: zhumengzhu
 * Create: 2016-03-30 11:06
 */
public class CachedClock {
    private static final int UPDATE_THRESHOLD = 1000;
    private volatile long millis = System.currentTimeMillis();
    private short count = 0;

    private static class CachedClockHolder {
        private static CachedClock INSTANCE = new CachedClock();
    }

    public static CachedClock instance() {
        return CachedClockHolder.INSTANCE;
    }

    private CachedClock() {
        final Thread updater = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    final long time = System.currentTimeMillis();
                    millis = time;

                    // avoid explicit dependency on sun.misc.Util
                    LockSupport.parkNanos(1000 * 1000);
                }
            }
        }, "Clock Updater Thread");
        updater.setDaemon(true);
        updater.start();
    }

    /**
     * Returns the value of a private long field that is updated by a background
     * thread once every millisecond. Timers on most platforms do not
     * have millisecond granularity, the returned value may "jump" every 10 or
     * 16 milliseconds. To reduce this problem, this method also updates the
     * internal time value every 1024 calls.
     *
     * @return the cached time
     */
    public long currentTimeMillis() {

        // The count field is not volatile on purpose to reduce contention on this field.
        // This means that some threads may not see the increments made to this field
        // by other threads. This is not a problem: the timestamp does not need to be
        // updated exactly every 1000 calls.
        if (++count > UPDATE_THRESHOLD) {
            millis = System.currentTimeMillis(); // update volatile field: store-store barrier
            count = 0; // after a memory barrier: this change _is_ visible to other threads
        }
        return millis;
    }
}
