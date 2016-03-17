package hu.bme.mit.sette.snippets._8_multithreading.dependencies;

import hu.bme.mit.sette.common.annotations.SetteDependency;

@SetteDependency
public class SharedResourceUser extends Thread {
    private final SharedResource resource;
    private volatile boolean done = false;

    public SharedResourceUser(SharedResource resource) {
        this.resource = resource;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public void run() {
        int trials = 0;
        while (resource.getUser() != this) {
            if (trials > 10) {
                return;
            }
            // take the resource forcefully
            trials++;
            resource.setUser(this);
            ThreadUtils.busyWait(100);
        }

        done = true;
    }
}
