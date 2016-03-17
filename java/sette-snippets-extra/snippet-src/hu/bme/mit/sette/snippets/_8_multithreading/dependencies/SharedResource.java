package hu.bme.mit.sette.snippets._8_multithreading.dependencies;

import hu.bme.mit.sette.common.annotations.SetteDependency;

@SetteDependency
public class SharedResource {
    private volatile Object user = null;

    public synchronized Object getUser() {
        return user;
    }

    public synchronized void setUser(Object user) {
        this.user = user;
    }
    
    

}
